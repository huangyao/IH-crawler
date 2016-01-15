package cn.ideath.crawler;

import cn.ideath.crawler.bean.RequestData;
import cn.ideath.crawler.bean.ResponseData;
import cn.ideath.crawler.fetch.Fetcher;

/**
 * Title: AbstractCrawler.java<br>
 * Description: <br>
 * Copyright (c) 人和网版权所有 2016    <br>
 * Create DateTime: 2016年1月15日 下午2:16:39 <br>
 * @author HuangYao
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

	private Fetcher<Req, Res> fetcher;

	protected abstract Req createRequest();

	private boolean stop = false;

	protected void shutdown() {
		this.stop = true;
	}

	public AbstractCrawler(Fetcher<Req, Res> fetcher) {
		this.fetcher = fetcher;
	}

	public void run() {
		try {
			while (!stop) {
				beforeProcess();

				Res response = fetcher.fetch(createRequest());
				// TODO

				afterProcess();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
