package com.core.liemao.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpClientUtil {
	
	private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

//	private static CloseableHttpClient client = HttpClientBuilder.create().build();
//	private static RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(100).setConnectTimeout(30000).setSocketTimeout(100).build();
	//doGet
	public static String doGet(String url) {
		String resData = null;
		CloseableHttpClient client = null;
		HttpGet httpGet = null;
		try {
			client = HttpClientBuilder.create().build();
			httpGet = new HttpGet(url);
			HttpResponse response = client.execute(httpGet);
			HttpEntity entity = response.getEntity();
			resData = EntityUtils.toString(entity);
		} catch (ClientProtocolException e) {
			logger.error(e.getMessage(),e);
		} catch (IOException e) {
			logger.error(e.getMessage(),e);
		}finally{
			if(httpGet!=null){
				httpGet.releaseConnection();
			}
			if(client!=null){
				try {
					client.close();
				} catch (IOException e) {
					logger.error("关闭httpclient失败");
				}
			}
		}
		return resData;
	}

	//doPostJSON
	/**
	 * JSON请求
	 * JSON请求JSON返回
	 *
	 * @param url
	 * @param jsonContent
	 * @return
	 */
	public static String doJSONPost(String url, String jsonContent) {
		HttpResponse result = null;
		String resData = null;
		HttpPost httppost = null;
		CloseableHttpClient client = null;
		try {
			client = HttpClientBuilder.create().build();
			httppost = new HttpPost(url);
			StringEntity entity = new StringEntity(jsonContent, "UTF-8");//解决中文乱码问题    
			entity.setContentEncoding("UTF-8");
			entity.setContentType("application/json");
			httppost.setEntity(entity);
			result = client.execute(httppost);
			resData = EntityUtils.toString(result.getEntity());
		} catch (ClientProtocolException e) {
			logger.error(e.getMessage(),e);
		} catch (IOException e) {
			logger.error(e.getMessage(),e);
		}finally{
			if(httppost!=null){
				httppost.releaseConnection();
			}
			if(client!=null){
				try {
					client.close();
				} catch (IOException e) {
					logger.error("关闭httpclient失败");
				}
			}
		}
		return resData;
	}

	public static String doFormPost(String url, HashMap parameterMap) {
		HttpResponse response = null;
		String resData = null;
		HttpPost httppost = null;
		CloseableHttpClient client = null;
		try {
			client = HttpClientBuilder.create().build();
			httppost = new HttpPost(url);
			// 构造最简单的字符串数据
			StringBuilder sb = new StringBuilder();
			if (parameterMap != null && parameterMap.size() > 0) {
				Set<Map.Entry> parSet = parameterMap.entrySet();
				int index = 0;
				for (Map.Entry entry : parSet) {
					if (index == 0) {
						sb.append(entry.getKey());
						sb.append("=");
						if (entry.getValue() == null) {
							sb.append("");
						} else {
							try {
								sb.append(URLEncoder.encode(entry.getValue().toString(), "utf8"));
							} catch (UnsupportedEncodingException e) {
								logger.error(e.getMessage(),e);
							}
						}
						index++;
					} else {
						sb.append("&");
						sb.append(entry.getKey());
						sb.append("=");
						if (entry.getValue() == null) {
							sb.append("");
						} else {
							sb.append(URLEncoder.encode(entry.getValue().toString(), "utf8"));
						}
					}
				}
			}
			StringEntity reqEntity = new StringEntity(sb.toString());
			// 设置类型
			reqEntity.setContentEncoding("UTF-8");
			reqEntity.setContentType("application/x-www-form-urlencoded");
			// 设置请求的数据
			httppost.setEntity(reqEntity);
			// 执行
			response = client.execute(httppost);
			HttpEntity entity = response.getEntity();
			
			resData = EntityUtils.toString(entity); //会关闭stream。
		} catch (Exception ex) {
			logger.error(ex.getMessage(),ex);
		} finally{
			if(httppost!=null){
				httppost.releaseConnection();
			}
			if(client!=null){
				try {
					client.close();
				} catch (IOException e) {
					logger.error("关闭httpclient失败");
				}
			}
		}
		return resData;
	}
	
	public static String doFormJSONPost(String url, String jsonContent) {
		HttpResponse result = null;
		String resData = null;
		HttpPost httppost = new HttpPost(url);
		CloseableHttpClient client = null;
		try {
			client = HttpClientBuilder.create().build();
			StringEntity entity = new StringEntity(jsonContent, "UTF-8");//解决中文乱码问题    
			entity.setContentEncoding("UTF-8");
			entity.setContentType("application/json");
			httppost.setEntity(entity);
			result = client.execute(httppost);
			resData = EntityUtils.toString(result.getEntity());
		} catch (ClientProtocolException e) {
			logger.error(e.getMessage(),e);
		} catch (IOException e) {
			logger.error(e.getMessage(),e);
		} finally{
			if(httppost!=null){
				httppost.releaseConnection();
			}
			if(client!=null){
				try {
					client.close();
				} catch (IOException e) {
					logger.error("关闭httpclient失败");
				}
			}
		}
		return resData;
	}
	
	
	public static String doNameValuePairPost(String url,List<NameValuePair> params){
		HttpResponse result = null;
		String resData = null;
		HttpPost httppost = new HttpPost(url);
		CloseableHttpClient client = null;
		try {
			client = HttpClientBuilder.create().build();
			httppost.setEntity(new UrlEncodedFormEntity(params));
			String dd = EntityUtils.toString(httppost.getEntity());
			System.out.println(dd);
			result = client.execute(httppost);
			resData = EntityUtils.toString(result.getEntity());
		} catch (ClientProtocolException e) {
			logger.error(e.getMessage(),e);
		} catch (IOException e) {
			logger.error(e.getMessage(),e);
		} finally{
			if(httppost!=null){
				httppost.releaseConnection();
			}
			if(client!=null){
				try {
					client.close();
				} catch (IOException e) {
					logger.error("关闭httpclient失败");
				}
			}
		}
		return resData;
	}
	
	
}