package com.greenflag.utils.http;

import java.net.URL;


public class WebClientRequest {
	public enum RequestTypes{ GET,POST,PUT,DELETE }
	private RequestTypes requestType;
	private URL requestUrl;
	public RequestTypes getRequestType() {
		return requestType;
	}
	public void setRequestType(RequestTypes requestType) {
		this.requestType = requestType;
	}
	public URL getRequestUrl() {
		return requestUrl;
	}
	public void setRequestUrl(URL requestUrl) {
		this.requestUrl = requestUrl;
	}
}
