package com.example.demo.util.log;

import ch.qos.logback.classic.pattern.MessageConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 10450
 * @description 日志敏感信息脱敏
 * @date 2021/7/16 14:21
 */
public class SensitiveMessageConverter extends MessageConverter {
    private static final Logger logger = LoggerFactory.getLogger(SensitiveMessageConverter.class);


}
