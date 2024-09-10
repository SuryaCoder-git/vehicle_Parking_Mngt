package com.project.ParkingManagementSystem.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;


@Configuration
public class Config  implements WebMvcConfigurer{

	@Bean
	public OpenAPI swaggerDocumentAPI() {

		Server developer=new Server();
		developer.setUrl("localhost:7789");
		developer.setDescription("this is localhost server");


		Server testing=new Server();
		testing.setUrl("localhost:7789");
		testing.setDescription("this is localhost server");


		License license=new License();
		license.setUrl("licencse URL");
		license.setName("license");

		Contact contact=new Contact();
		contact.setEmail("suryasurya00765@gmail.com");
		contact.setUrl("www.website.com");
		
		
		Info info=new Info();
		info.setContact(contact);
		info.setLicense(license);
		info.setTitle("parking management system");
		
		OpenAPI api=new OpenAPI();
		api.setInfo(info);
		api.setServers(Arrays.asList(developer,testing));
		
		return api;


	}

}
