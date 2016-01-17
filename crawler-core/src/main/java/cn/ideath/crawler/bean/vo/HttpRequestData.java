package cn.ideath.crawler.bean.vo;

import java.util.Map;

import cn.ideath.crawler.bean.RequestData;
import cn.ideath.crawler.constants.HttpConstants;

/**
 * HTTP请求
 * @author HuangYao
 *
 */
public class HttpRequestData implements RequestData {

	/** 请求地址 */
	private String url;
	/** 请求方法 */
	private String method;
	/** 参数 */
	private String params;
	/** 参数键值对 */
	private Map<String, String> nameValueMap;

	private static final String DEFAULT_METHOD = HttpConstants.METHOD_GET;

	public HttpRequestData() {
		this(DEFAULT_METHOD);
	}

	public HttpRequestData(String method) {
		this.method = method;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public Map<String, String> getNameValueMap() {
		return nameValueMap;
	}

	public void setNameValueMap(Map<String, String> nameValueMap) {
		this.nameValueMap = nameValueMap;
	}

}
