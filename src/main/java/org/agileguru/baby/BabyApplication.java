package org.agileguru.baby;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.alacritysys.libs.web.filters.CorrelationHeaderRequestFilter;

@SpringBootApplication
public class BabyApplication {
    public static void main(String[] args) {
        SpringApplication.run(BabyApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean<CorrelationHeaderRequestFilter> correlationHeaderRequestFilter() {
        FilterRegistrationBean<CorrelationHeaderRequestFilter> filter = new FilterRegistrationBean<>();
        CorrelationHeaderRequestFilter requestFilter = new CorrelationHeaderRequestFilter();
        filter.setFilter(requestFilter);
        filter.addUrlPatterns("/*");
        filter.setName(requestFilter.getClass().getSimpleName());
        filter.setOrder(1);
        return filter;
    }
}
