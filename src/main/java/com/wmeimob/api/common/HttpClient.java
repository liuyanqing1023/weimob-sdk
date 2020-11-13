package com.wmeimob.api.common;

import com.alibaba.fastjson.JSON;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * http请求客户端
 * @author LYQ
 * 
 */
public class HttpClient {
	private String url;
	private Map<String, Object> params;
	private Map<String, String> headers;
	private String param;
	private int statusCode;
	private String content;
	private String xmlParam;
	private boolean isHttps;

	public boolean isHttps() {
		return isHttps;
	}

	public void setHttps(boolean isHttps) {
		this.isHttps = isHttps;
	}

	public String getXmlParam() {
		return xmlParam;
	}

	public void setXmlParam(String xmlParam) {
		this.xmlParam = xmlParam;
	}

	public HttpClient(String url, Map<String, Object> param) {
		this.url = url;
		this.params = param;
	}

	public HttpClient(String url) {
		this.url = url;
	}

	public void setParameter(Map<String, Object> map) {
		this.params = map;
	}
	public void setParameter(Map<String, Object> map,Map<String, String> headers) {
		this.params = map;
		this.headers = headers;
	}
	public void setParameter(String body) {
		param = body;
	}
	public void setParameter(String body,Map<String, String> headers) {
		this.param = body;
		this.headers = headers;
	}

	public void addParameter(String key, String value) {
		if (params == null) {
			params = new HashMap<String, Object>();
		}
		params.put(key, value);
	}

	public void post() throws ClientProtocolException, IOException {
		HttpPost http = new HttpPost(url);
		http.setHeader("Accept","application/json;charset=UTF-8");
		setEntity(http);
		execute(http);
	}
	public void postForJson() throws ClientProtocolException, IOException {
		HttpPost http = new HttpPost(url);
		http.setHeader("Accept","application/json;charset=UTF-8");
		http.setHeader("Content-Type","application/json;charset=UTF-8");
		if (headers != null) {
			http.setHeader("appkey",headers.get("appkey"));
			http.setHeader("sign",headers.get("sign"));
			http.setHeader("timestamp",headers.get("timestamp"));
		}
		setEntityForJson(http);
		execute(http);
	}

	public void put() throws ClientProtocolException, IOException {
		HttpPut http = new HttpPut(url);
		setEntity(http);
		execute(http);
	}

	public void get() throws ClientProtocolException, IOException {
		if (params != null) {
			StringBuilder url = new StringBuilder(this.url);
			boolean isFirst = true;
			for (String key : params.keySet()) {
				if (isFirst) {
					url.append("?");
					isFirst = false;
				} else {
					url.append("&");
				}
				url.append(key).append("=").append(params.get(key));
			}
			this.url = url.toString();
		}
		HttpGet http = new HttpGet(url);
		http.setHeader("Accept","application/json;charset=UTF-8");
		if (headers != null) {
			http.setHeader("appkey",headers.get("appkey"));
			http.setHeader("sign",headers.get("sign"));
			http.setHeader("timestamp",headers.get("timestamp"));
		}
		execute(http);
	}

	/**
	 * set http post,put param
	 */
	private void setEntity(HttpEntityEnclosingRequestBase http) {
		if (params != null) {
			List<NameValuePair> nvps = new LinkedList<NameValuePair>();
			for (String key : params.keySet()) {
				nvps.add(new BasicNameValuePair(key, (String) params.get(key))); // 参数
			}
			http.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8)); // 设置参数
		}
		if (xmlParam != null) {
			http.setEntity(new StringEntity(xmlParam, Consts.UTF_8));
		}
	}
	private void setEntityForJson(HttpEntityEnclosingRequestBase http) {
		if (param!=null && !"".equals(param)){
			StringEntity entity = new StringEntity(param, "utf-8");
			http.setEntity(entity); // 设置参数
		}else if (params != null) {
			StringEntity entity = new StringEntity(JSON.toJSONString(params), "utf-8");
			http.setEntity(entity); // 设置参数
		}

		if (xmlParam != null) {
			http.setEntity(new StringEntity(xmlParam, Consts.UTF_8));
		}
	}

	private void execute(HttpUriRequest http) throws ClientProtocolException,
			IOException {
		CloseableHttpClient httpClient = null;
		try {
			if (isHttps) {
				SSLContext sslContext = new SSLContextBuilder()
						.loadTrustMaterial(null, new TrustStrategy() {
							// 信任所有
							//@Override
							public boolean isTrusted(X509Certificate[] chain,
													 String authType)
									throws CertificateException {
								return true;
							}
						}).build();
				SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
						sslContext);
				httpClient = HttpClients.custom().setSSLSocketFactory(sslsf)
						.build();
			} else {
				httpClient = HttpClients.createDefault();
			}
			CloseableHttpResponse response = httpClient.execute(http);
			try {
				if (response != null) {
					if (response.getStatusLine() != null) {
						statusCode = response.getStatusLine().getStatusCode();
					}
					HttpEntity entity = response.getEntity();
					// 响应内容
					content = EntityUtils.toString(entity, Consts.UTF_8);
				}
			} finally {
				response.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpClient.close();
		}
	}

	public int getStatusCode() {
		return statusCode;
	}

	public String getContent() throws ParseException, IOException {
		return content;
	}

}
