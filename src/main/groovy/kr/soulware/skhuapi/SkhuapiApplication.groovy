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

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
class SkhuapiApplication extends SpringBootServletInitializer implements ApplicationRunner {

	@Autowired
	BootStrap bootStrap

	static void main(String[] args) {
		SpringApplication.run(SkhuapiApplication, args)
	}

	void run(ApplicationArguments args) throws Exception {
		bootStrap.init()
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SkhuapiApplication.class)
	}
}
