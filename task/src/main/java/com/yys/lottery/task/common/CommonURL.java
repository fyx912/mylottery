package com.yys.lottery.task.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "lottery")
public class CommonURL {

    @Value("${lottery.hf_url}")
    private  String hf_url;//高频彩票地址

}
