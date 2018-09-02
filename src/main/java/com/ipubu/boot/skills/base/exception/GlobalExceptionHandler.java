package com.ipubu.boot.skills.base.exception;

import static com.ipubu.boot.skills.base.constant.ResponseConsts.RESPONSE_ERROR;
import static com.ipubu.boot.skills.base.constant.ResponseConsts.TYPE;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.lenovo.cui.skiprotocol.SKIResponser;

/**
 * @ClassName GlobalExceptionHandler
 * @Description		全局异常处理
 * @Author jzy
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private String shouldEndSession = "true";
    private String text = RESPONSE_ERROR;

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JSONObject jsonErrorHandler(HttpServletRequest req, Exception e) {
        // 返回错误信息
        LOGGER.error("catch Exception,request url:{}", req.getRequestURL(), e);
        return response(text);
    }

    private JSONObject response(final String text) {
        // 返回错误信息
        JSONObject response = null;
        try {
            response = SKIResponser.getResponseJSON(TYPE, null, null, null, shouldEndSession, text);
        } catch (IOException e) {
            LOGGER.error("build response ", e);
        }
        return response;
    }

}
