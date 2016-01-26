package cn.ideath.crawler.bean.vo;

import java.net.URI;

import org.apache.http.Header;

import cn.ideath.crawler.bean.ResponseData;

/**
 * Title: HttpResponseData.java<br>
 * Description: <br>
 * Copyright (c) 人和网版权所有 2016    <br>
 * Create DateTime: 2016年1月15日 上午10:51:55 <br>
 * @author HuangYao
 */
public class HttpResponseData implements ResponseData {

	private int statusCode;
	private String mimeType;
	private Header[] headers;
	private String body;
	private URI requestURI;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public Header[] getHeaders() {
		return headers;
	}

	public void setHeaders(Header[] headers) {
		this.headers = headers;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public URI getRequestURI() {
		return requestURI;
	}

	public void setRequestURI(URI requestURI) {
		this.requestURI = requestURI;
	}

}
