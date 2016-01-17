package cn.ideath.crawler.fetch;

import cn.ideath.crawler.bean.vo.HttpRequestData;
import cn.ideath.crawler.bean.vo.HttpResponseData;
import cn.ideath.crawler.constants.HttpConstants;
import cn.ideath.crawler.util.HttpClientUtil;

/**
 * 
 * @author HuangYao
 *
 */
public class DefaultHttpFetcher implements Fetcher<HttpRequestData, HttpResponseData> {

	public HttpResponseData fetch(HttpRequestData request) {
		HttpResponseData response = null;
		String method = request.getMethod();
		if (HttpConstants.METHOD_GET.equals(method)) {
			response = HttpClientUtil.getDataBySendHttpGetRequest(request.getUrl());
		} else if (HttpConstants.METHOD_POST.equals(method)) {
			if (request.getNameValueMap() != null) {
				response = HttpClientUtil.getDataBySendHttpPostRequest(request.getUrl(), request.getNameValueMap());
			} else if (request.getParams() != null) {
				response = HttpClientUtil.getDataBySendHttpPostRequest(request.getUrl(), request.getParams());
			} else {
				response = HttpClientUtil.getDataBySendHttpPostRequest(request.getUrl());
			}
		} else {
			throw new RuntimeException("NO MATCHED HTTP METHOD.");
		}
		return response;
	}

}
