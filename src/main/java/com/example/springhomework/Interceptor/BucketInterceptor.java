package com.example.springhomework.Interceptor;

import com.example.springhomework.Annotation.BucketAnnotation;
import com.example.springhomework.Exception.APIException;
import com.example.springhomework.Util.BucketUtil;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class BucketInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        BucketAnnotation methodAnnotation = method.getAnnotation(BucketAnnotation.class);
        if (methodAnnotation!=null){
            // 在名为：bucket的令牌桶里取令牌 取到即放行 未取到即抛出异常
            if(BucketUtil.buckets.get("bucket").getToken()){
                return true;
            }
            else{
                // 抛出自定义异常
                throw new APIException("同时访问数量过多");
            }
        }else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
