package br.senaisp.edu.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer{
	 @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")  // Aplica CORS a todas as URLs
	                .allowedOrigins("http://localhost:3000")  // Permite somente requisições de http://localhost:3000
	                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Métodos HTTP permitidos
	                .allowedHeaders("*");  // Headers permitidos
	    }
}
