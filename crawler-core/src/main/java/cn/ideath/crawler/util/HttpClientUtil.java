package cn.ideath.crawler.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.util.PublicSuffixMatcher;
import org.apache.http.conn.util.PublicSuffixMatcherLoader;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * Title: HttpClientUtil.java<br>
 * Description: <br>
 * Copyright (c) �˺�����Ȩ���� 2016    <br>
 * Create DateTime: 2016��1��13�� ����3:54:32 <br>
 * @author HuangYao
 */
public class HttpClientUtil {

	private static RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(15000).setConnectTimeout(15000).setConnectionRequestTimeout(15000).build();
	private static final String DEFAULT_POST_CONTENT_TYPE = "application/x-www-form-urlencoded";
	private static final String DEFAULT_CHARSET = "UTF-8";

	public static String sendHttpRequest(HttpRequestBase httpRequest) {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		HttpEntity entity = null;
		String responseContent = null;
		try {
			// ����Ĭ��httpClientʵ��
			httpClient = HttpClients.createDefault();
			httpRequest.setConfig(requestConfig);
			// ִ������
			response = httpClient.execute(httpRequest);
			entity = response.getEntity();
			responseContent = EntityUtils.toString(entity, DEFAULT_CHARSET);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// �ر����ӣ��ͷ���Դ
				if (response != null) {
					response.close();
				}
				if (httpClient != null) {
					httpClient.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return responseContent;
	}

	public static String sendHttpsRequest(HttpRequestBase httpRequest) {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		HttpEntity entity = null;
		String responseContent = null;
		try {
			PublicSuffixMatcher publicSuffixMatcher = PublicSuffixMatcherLoader.load(new URL(httpRequest.getURI().toString()));
			DefaultHostnameVerifier hostnameVerifier = new DefaultHostnameVerifier(publicSuffixMatcher);
			httpClient = HttpClients.custom().setSSLHostnameVerifier(hostnameVerifier).build();
			httpRequest.setConfig(requestConfig);
			// ִ������
			response = httpClient.execute(httpRequest);
			entity = response.getEntity();
			responseContent = EntityUtils.toString(entity, DEFAULT_CHARSET);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// �ر����ӣ��ͷ���Դ
				if (response != null) {
					response.close();
				}
				if (httpClient != null) {
					httpClient.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return responseContent;
	}

	public static String sendHttpPost(String httpUrl) {
		HttpPost httpPost = new HttpPost(httpUrl);
		return sendHttpRequest(httpPost);
	}

	public static String sendHttpPost(String httpUrl, String params) {
		HttpPost httpPost = new HttpPost(httpUrl);
		try {
			// ���ò���
			StringEntity stringEntity = new StringEntity(params, DEFAULT_CHARSET);
			stringEntity.setContentType(DEFAULT_POST_CONTENT_TYPE);
			httpPost.setEntity(stringEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sendHttpRequest(httpPost);
	}

	public static String sendHttpPost(String httpUrl, Map<String, String> maps) {
		HttpPost httpPost = new HttpPost(httpUrl);
		// ������������
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		for (String key : maps.keySet()) {
			nameValuePairs.add(new BasicNameValuePair(key, maps.get(key)));
		}
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, DEFAULT_CHARSET));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sendHttpRequest(httpPost);
	}

	public static String sendHttpPost(String httpUrl, Map<String, String> maps, List<File> fileLists) {
		HttpPost httpPost = new HttpPost(httpUrl);
		MultipartEntityBuilder meBuilder = MultipartEntityBuilder.create();
		for (String key : maps.keySet()) {
			meBuilder.addPart(key, new StringBody(maps.get(key), ContentType.TEXT_PLAIN));
		}
		for (File file : fileLists) {
			FileBody fileBody = new FileBody(file);
			meBuilder.addPart("files", fileBody);
		}
		httpPost.setEntity(meBuilder.build());
		return sendHttpRequest(httpPost);
	}

	public static String sendHttpGet(String httpUrl) {
		HttpGet httpGet = new HttpGet(httpUrl);
		return sendHttpRequest(httpGet);
	}

	public static String sendHttpsGet(String httpUrl) {
		HttpGet httpGet = new HttpGet(httpUrl);
		return sendHttpsRequest(httpGet);
	}

}
