package com.gudt.imis.clubmanageis.util.https;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.*;
import java.io.*;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.cert.X509Certificate;
import java.util.Map;

/**
 * @ClassName : HttpsUtils
 * @Description :
 * @Author : WDD
 * @Date: 2020-10-21 14:57
 */

@Slf4j
public class HttpsUtils {

    public static JSONObject GET(String requestUrl,Map<String, Object> params){
        String URL=concatUrlParam(requestUrl,params);
        return request(URL,"GET",null);
    }

    /**
     * 发起https请求并获取结果
     * @param requestUrl 请求地址
     * @param requestMethod 请求方式（GET、post）
     * @param outputStr 提交的数据
     * @return json字符串
     */

    public static JSONObject request(String requestUrl, String requestMethod, String outputStr) {
        StringBuffer buffer = new StringBuffer();
        JSONObject jsonObject ;
        try {
            // 创建SSLContext对象，并使用我们制定的信任管理器初始化
            TrustManager[] tm = {new MyX509TrustManager()};
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);

            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod)) {
                httpUrlConn.connect();
            }

            // 当有数据需要提交时
            if (null != outputStr) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                // 注意编码格式，防止中文乱码
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            httpUrlConn.disconnect();
            log.debug("https buffer:" + buffer.toString());
        } catch (ConnectException ce) {
            log.error("server connection timed out");
        } catch (Exception e) {
            log.error( e.getMessage());
        }
        jsonObject = JSON.parseObject(buffer.toString());
        return jsonObject;
    }
    /**
     * 连接url和参数
     * @param url 请求url
     * @param params 请求参数
     * @return 拼接完参数的完整url
     */
    public static String concatUrlParam(String url, Map<String, Object> params) {
        url += "?";
        StringBuilder urlBuilder = new StringBuilder();
        for (Map.Entry<String, Object> entry: params.entrySet()) {
            Object value = entry.getValue();
            if (params.get("keyword") != null) {
                try {
                    value = URLEncoder.encode(value + "", "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            urlBuilder.append(entry.getKey()).append("=").append(value).append("&");
        }
        return url + urlBuilder.toString();
    }
    /**
     * 证书信任管理器（用于https请求）
     */
    static class MyX509TrustManager implements X509TrustManager {

        @Override
        public void checkClientTrusted(X509Certificate[] x509Certificates, String s) {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] x509Certificates, String s) {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

}
