package org.ssglobal.revalida.codes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SocmedChatServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocmedChatServiceApplication.class, args);
	}

}
