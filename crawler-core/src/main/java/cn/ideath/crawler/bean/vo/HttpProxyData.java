package cn.ideath.crawler.bean.vo;

/**
 * Title: HttpProxyData.java<br>
 * Description: 代理属性<br>
 * Copyright (c) 人和网版权所有 2016    <br>
 * Create DateTime: 2016年3月18日 下午4:15:07 <br>
 * @author HuangYao
 */
public class HttpProxyData {

	private String host;
	private int port;
	private String protocol;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

}
