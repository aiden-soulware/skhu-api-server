package kr.soulware.skhuapi

import kr.soulware.skhuapi.init.BootStrap
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
class SkhuapiApplication extends SpringBootServletInitializer implements ApplicationRunner {

	@Autowired
	BootStrap bootStrap

	static void main(String[] args) {
		SpringApplication.run(SkhuapiApplication, args)
	}
//	@Bean
//	WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**").allowedOrigins("http://localhost:8080").allowedMethods("GET", "POST","PUT", "DELETE");
//
//			}
//		};
//	}

	void run(ApplicationArguments args) throws Exception {
		bootStrap.init()
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SkhuapiApplication.class)
	}

}
