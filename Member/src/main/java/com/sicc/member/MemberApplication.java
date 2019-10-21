package com.sicc.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Member Micro Service
 * 사용자 관련 마이크로서비스
 * @author Woongs
 */
@SpringBootApplication
public class MemberApplication {
	@Bean // 마이크로서비스간 통신을 위한 restTemplate Bean으로 생성하여 컨테이너에 등록
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(MemberApplication.class, args);
	}
}