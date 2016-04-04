package io.saltcat.ucm.web.controller;

import com.meidusa.fastjson.JSON;
import io.saltcat.ucm.web.utils.WebConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by huawei on 4/3/16.
 */
public class BaseController {

    private Logger logger = LoggerFactory.getLogger(BaseController.class);

    protected void response(HttpServletResponse response, int code, String contentType, String message) throws IOException {

        response.setStatus(code);
        response.setCharacterEncoding(WebConstants.ENCODING);
        if (contentType != null) {
            response.setContentType(contentType);
        }
        if (message != null) {
            byte[] data;
            try {
                data = message.getBytes(WebConstants.ENCODING);
            } catch (UnsupportedEncodingException e) {
                logger.warn("不支持" + WebConstants.ENCODING + "字符集", e);
                data = message.getBytes();
            }
            response.getOutputStream().write(data);
            response.getOutputStream().flush();
        }

    }

    protected <T> void responseJson(HttpServletResponse response, T obj) throws IOException{
        response(response, HttpStatus.OK.value(), WebConstants.CONTENT_TYPE_JSON, JSON.toJSONString(obj));
    }

    protected void responseError(HttpServletResponse response, int code) throws IOException{
        response(response, HttpStatus.valueOf(code).value(), null, null);
    }
}
