package cn.guxiangfly.proxy;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class TestProxy {
    public static void main(String[] args)throws Exception {
        //设置代理IP、端口、协议（请分别替换）
        HttpHost proxy = new HttpHost("42.51.42.254", 16816, "http");

        //把代理设置到请求配置
        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setProxy(proxy)
                .build();

        //实例化CloseableHttpClient对象
        CloseableHttpClient httpclient = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();

        //访问目标地址
        HttpGet httpGet = new HttpGet("http://www.baidu.com");

        //请求返回
        CloseableHttpResponse httpResp = httpclient.execute(httpGet);
        try {
            System.out.println("----------------------------------------");
            System.out.println(httpResp.getStatusLine());
            System.out.println(EntityUtils.toString(httpResp.getEntity()));
        } finally {
            httpResp.close();
        }
    }
}