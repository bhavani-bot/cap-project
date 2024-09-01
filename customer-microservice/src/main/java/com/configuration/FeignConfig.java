package com.configuration;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.codec.ErrorDecoder;

@Configuration
public class FeignConfig {
    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL; // Log all details of requests and responses
    }
    @Bean
    public Decoder feignDecoder() {
        return new SpringDecoder(() -> new HttpMessageConverters());
    }
}
