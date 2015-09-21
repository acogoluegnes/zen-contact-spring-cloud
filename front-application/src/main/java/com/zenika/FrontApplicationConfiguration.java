package com.zenika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerInterceptor;
import org.springframework.cloud.client.loadbalancer.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by acogoluegnes on 02/09/15.
 */
@Configuration
public class FrontApplicationConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(handlerInterceptor());
    }

    @Bean
    public HandlerInterceptor handlerInterceptor() {
        return new HandlerInterceptorAdapter() {
            @Override
            public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
                modelAndView.addObject("contextPath",request.getContextPath());
            }
        };
    }

    @Autowired
    RestTemplate restClient;

    @Autowired
    LoadBalancerInterceptor loadBalancerInterceptor;

    @PostConstruct
    public void init() {
        RestTemplateCustomizer restTemplateCustomizer = new RestTemplateCustomizer() {
            @Override
            public void customize(RestTemplate restTemplate) {
                List<ClientHttpRequestInterceptor> list = new ArrayList<>();
                list.add(loadBalancerInterceptor);
                restTemplate.setInterceptors(list);
            }
        };
        restTemplateCustomizer.customize(restClient);
        restClient.setRequestFactory(new SimpleClientHttpRequestFactory());
    }

}
