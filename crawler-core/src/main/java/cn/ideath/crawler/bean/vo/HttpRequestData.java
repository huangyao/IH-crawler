package cn.ideath.crawler.bean.vo;

import cn.ideath.crawler.bean.RequestData;

/**
 * HTTP请求
 * @author HuangYao
 *
 */
public class HttpRequestData implements RequestData {
	
	/** 请求地址 */
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
