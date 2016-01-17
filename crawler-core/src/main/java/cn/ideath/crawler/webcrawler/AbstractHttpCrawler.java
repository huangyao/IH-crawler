package cn.ideath.crawler.webcrawler;

import cn.ideath.crawler.AbstractCrawler;
import cn.ideath.crawler.bean.vo.HttpRequestData;
import cn.ideath.crawler.bean.vo.HttpResponseData;
import cn.ideath.crawler.fetch.Fetcher;
import cn.ideath.crawler.fetch.DefaultHttpFetcher;

/**
 * 
 * @author HuangYao
 *
 */
public abstract class AbstractHttpCrawler extends AbstractCrawler<HttpRequestData, HttpResponseData>{

	public AbstractHttpCrawler() {
		this(new DefaultHttpFetcher());
	}
	
	public AbstractHttpCrawler(Fetcher<HttpRequestData, HttpResponseData> fetcher) {
		super(fetcher);
	}

}
