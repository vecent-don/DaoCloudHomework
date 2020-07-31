package com.example.springhomework.Config;

import com.example.springhomework.Interceptor.BucketInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 令牌桶拦截器 添加拦截器并选择拦截路径
        registry.addInterceptor(bucketInterceptor()).addPathPatterns("/**");
    }

    @Autowired
    public BucketInterceptor bucketInterceptor() {
        return new BucketInterceptor();
    }

}
