package com.example.gagym.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry
				.addMapping("/**")
//				.allowedOrigins("http://localhost:3000", "http://127.0.0.1:5500/",
//						"http://ec2-3-34-241-52.ap-northeast-2.compute.amazonaws.com")
				.allowedOrigins("http://localhost:3000", "http://127.0.0.1:5500",
						"http://ec2-3-34-181-87.ap-northeast-2.compute.amazonaws.com",
						"http://ec2-3-36-96-181.ap-northeast-2.compute.amazonaws.com",
						"http://ec2-13-125-255-75.ap-northeast-2.compute.amazonaws.com", //update
						"http://ec2-52-79-254-140.ap-northeast-2.compute.amazonaws.com",
						"http://ec2-3-36-97-224.ap-northeast-2.compute.amazonaws.com", //효정님front추가1206
						"/v3/api-docs",
                        "/v3/api-docs/**",
                        "/swagger-ui.html",
                        "/swagger-ui/**",
                        "/swagger-ui.index.html/**")
				.allowedMethods("*");
	}
}