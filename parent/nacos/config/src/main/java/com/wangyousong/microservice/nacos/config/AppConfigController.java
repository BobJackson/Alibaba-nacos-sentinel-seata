package com.wangyousong.microservice.nacos.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bob
 * @version 1.0
 * @date 2020/6/20 15:58
 */
@RestController
@RequestMapping("/config")
@RefreshScope
public class AppConfigController {

    @Value("${useLocalCache:false}")
    private boolean useLocalCache;

    @Value("${app-version:1.0}")
    private String appVersion;


    @GetMapping("/use-local-cache")
    public boolean useLocalCache() {
        return useLocalCache;
    }

    @GetMapping("/app-version")
    public String version() {
        return appVersion;
    }
}
