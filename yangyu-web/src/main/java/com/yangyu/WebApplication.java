package com.yangyu;

import com.yangyu.common.util.A;
import com.yangyu.common.util.LogUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients(basePackages = {"com.yangyu.api"})
public class WebApplication {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(WebApplication.class, args);
		if (LogUtil.ROOT_LOG.isDebugEnabled()) {
			String[] activeProfiles = ctx.getEnvironment().getActiveProfiles();
			if (A.isNotEmpty(activeProfiles)) {
				LogUtil.ROOT_LOG.debug("current profile : ({})", A.toStr(activeProfiles));
			}
		}
	}
}
