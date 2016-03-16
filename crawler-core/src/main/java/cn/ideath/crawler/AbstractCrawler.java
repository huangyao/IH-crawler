package cn.ideath.crawler;

import cn.ideath.crawler.bean.RequestData;
import cn.ideath.crawler.bean.ResponseData;
import cn.ideath.crawler.fetch.Fetcher;

/**
 * 
 * @author HuangYao
 *
 */
public abstract class AbstractCrawler<Req extends RequestData, Res extends ResponseData> implements Runnable {

	/**
	 * 执行业务逻辑处理之前进行的操作
	 */
	protected abstract void beforeProcess();

	/**
	 * 执行业务逻辑处理之后进行的操作
	 */
	protected abstract void afterProcess();

	/**
	 * 生成请求信息
	 */
	protected abstract Req createRequest();

	/**
	 * 处理返回结果的方法，主要的执行业务逻辑都在当中写
	 */
	protected abstract void process(Res response);

	private Fetcher<Req, Res> fetcher;

	private boolean stop = false;

	protected void shutdown() {
		this.stop = true;
	}

	public AbstractCrawler(Fetcher<Req, Res> fetcher) {
		this.fetcher = fetcher;
	}

	public void run() {

		while (!stop) {
			try {
				beforeProcess();
				Res response = fetcher.fetch(createRequest());
				process(response);
				afterProcess();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
