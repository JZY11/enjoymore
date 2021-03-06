package com.inpubu.boot.skills.enjoymore.util;

import java.io.InputStream;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ipubu.boot.skills.base.util.ParamChecker;
import com.ipubu.boot.skills.enjoymore.constant.GlobalConsts;

/**
 * @ClassName HttpUtil
 * @Description		Http访问工具
 * @Author jzy
 */
public class HttpUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpUtil.class);

    private HttpUtil() {}

    public static final String doPost(final String uri, Map<String, String> headerMap,
            String request) throws Exception {
        String result = null;
        HttpClient client = new HttpClient();
        // 使用POST方法
        PostMethod method = new PostMethod(uri);
        try {

            if (ParamChecker.isEmptyMap(headerMap)) {
                throw new IllegalArgumentException("header parameter is null");
            }

            for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                // 设置请求头参数
                if ("appid".equalsIgnoreCase(entry.getKey())) {
                    method.setRequestHeader("appid", entry.getValue());
                } else if ("sign".equalsIgnoreCase(entry.getKey())) {
                    method.setRequestHeader("sign", entry.getValue());
                }
            }

            byte[] encrypt = CryptUtil.me().encrypt(request.getBytes("utf-8"), GlobalConsts.APPKEY);
            String encryptStr = Base64.encodeBase64String(encrypt);

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("post content encryptStr:{}", encryptStr);
            }

            // 设置请求体参数
            RequestEntity entity = new StringRequestEntity(encryptStr, "application/json", "UTF-8");
            method.setRequestEntity(entity);

            // 通过请求对象获取响应对象
            int resp = client.executeMethod(method);
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("response content:{}", resp);
            }

            // 判断网络连接状态码是否正常(0--200都数正常)
            if (resp == HttpStatus.SC_OK) {
                InputStream inputStream = method.getResponseBodyAsStream();
                result = IOUtils.toString(inputStream, "UTF-8");
            }

            return result;
        } finally {
            // 释放连接
            method.releaseConnection();
        }
    }
}
