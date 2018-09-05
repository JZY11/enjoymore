package com.ipubu.boot.skills.base.rest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * @ClassName HealthController
 * @Description	  
 * @Author jzy
 */
@RequestMapping("/health")
@RestController
public class HealthController {

    /**
     * 健康检查
     * 
     * @param req
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/alive", method = { GET })
    @ResponseBody
    public String alive() {
        return "{\"status\":\"UP\"}";
    }

}
