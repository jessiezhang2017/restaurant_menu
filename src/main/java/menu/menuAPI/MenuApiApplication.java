package menu.menuAPI;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MenuApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MenuApiApplication.class, args);
	}
	
	//defining a RestTemplate Bean to make it available to the application context
	 @Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	   
	}

}

