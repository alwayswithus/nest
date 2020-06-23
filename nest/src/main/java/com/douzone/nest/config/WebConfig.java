package com.douzone.nest.config;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.douzone.security.AuthInterceptor;
import com.douzone.security.AuthUserHandlerMethodArgumentResolver;
import com.douzone.security.LoginInterceptor;
import com.douzone.security.LogoutInterceptor;

@Configuration
@PropertySource("classpath:com/douzone/nest/config/config.properties")
public class WebConfig implements WebMvcConfigurer {
	@Autowired
	private Environment env;

	// Argument Resolver
	@Bean
	public HandlerMethodArgumentResolver authUserHandlerMethodArgumentResolver() {
		return new AuthUserHandlerMethodArgumentResolver();
	}
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		resolvers.add(authUserHandlerMethodArgumentResolver());
	}
	
	// Interceptors
	@Bean
	public HandlerInterceptor loginInterceptor() {
		return new LoginInterceptor();
	}
	@Bean
	public HandlerInterceptor logoutInterceptor() {
		return new LogoutInterceptor();
	}
	@Bean
	public HandlerInterceptor authInterceptor() {
		return new AuthInterceptor();
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry
			.addInterceptor(loginInterceptor())
			.addPathPatterns(env.getProperty("security.auth-url"));

		registry
			.addInterceptor(logoutInterceptor())
			.addPathPatterns(env.getProperty("security.logout-url"));

		registry
			.addInterceptor(authInterceptor())
			.addPathPatterns("/**")
			.excludePathPatterns(env.getProperty("security.auth-url"))
			.excludePathPatterns(env.getProperty("security.logout-url"))
			.excludePathPatterns("/assets/**");
	}

	// Message Converters
	@Bean
	public StringHttpMessageConverter stringHttpMessageConverter() {
		StringHttpMessageConverter messageConverter = new StringHttpMessageConverter();
		messageConverter.setSupportedMediaTypes(
			Arrays.asList(
				new MediaType("text", "html", Charset.forName("UTF-8"))
			)
		);
		return messageConverter;
	}
	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		Jackson2ObjectMapperBuilder builder = 
				new Jackson2ObjectMapperBuilder()
					.indentOutput(true)
					.dateFormat(new SimpleDateFormat("yyyy-mm-dd"));
		
		MappingJackson2HttpMessageConverter converter = 
				new MappingJackson2HttpMessageConverter(builder.build());
		converter.setSupportedMediaTypes(
			Arrays.asList(
				new MediaType("application", "json", Charset.forName("UTF-8"))
			)
		);
		
		return converter;
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(stringHttpMessageConverter());
		converters.add(mappingJackson2HttpMessageConverter());
	}
	
	// Mvc Resources(URL Magic Mapping)
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
			.addResourceHandler(
					env.getProperty("fileupload.resourceMapping"))
			.addResourceLocations(
					"file:" + env.getProperty("fileupload.uploadLocation"));
	}
	
	// email sender
	@Bean
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost("smtp.gmail.com");
		sender.setPort(587);
		sender.setUsername("alwayswithusneat@gmail.com");
		sender.setPassword("nestAWU!");
		
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.debug", true);
		sender.setJavaMailProperties(props);

		return sender;
	}
	
}
