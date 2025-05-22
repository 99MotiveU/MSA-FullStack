package com.my.sts.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//<annotation-driven />
@EnableWebMvc
//<context:component-scan base-package="com.my.sts" />
@ComponentScan(basePackages = {"com.my.sts"})
public class ServletConfig implements WebMvcConfigurer{
	/*
	<beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<beans:property name="prefix" value="/WEB-INF/views/" />
		<beans:property name="suffix" value=".jsp" />
	</beans:bean>
	 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry reg) {
		InternalResourceViewResolver viewResolver;
		viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		reg.viewResolver(viewResolver);
	}
//<resources mapping="/resources/**" location="/resources/" />
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry reg) {
		reg.addResourceHandler("/resources/**")
			.addResourceLocations("/resources/");
	}
}







