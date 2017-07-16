package com.hc.cn;

import com.hc.cn.entity.User;
import com.hc.cn.repository.UserRepository;
import com.hc.cn.storage.StorageProperties;
import com.hc.cn.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class CnApplication {

	public static void main(String[] args) {
		SpringApplication.run(CnApplication.class, args);

	}
	@Bean
	public ViewResolver viewResolver() {
		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
		templateResolver.setTemplateMode("XHTML");
		templateResolver.setPrefix("views/");
		templateResolver.setSuffix("*.html");

		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setTemplateResolver(templateResolver);

		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(engine);
		return viewResolver;
	}
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}

}
