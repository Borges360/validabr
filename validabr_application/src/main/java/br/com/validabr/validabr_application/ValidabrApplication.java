package br.com.validabr.validabr_application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.validabr.buscacep.*", "br.com.validabr.financas.*"})
@EnableJpaRepositories(basePackages = {"br.com.validabr.buscacep.repository", "br.com.validabr.financas.repository"})
@EntityScan(basePackages = {"br.com.validabr.buscacep.gateway.*", "br.com.validabr.financas.gateway*"})
@EnableScheduling
public class ValidabrApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValidabrApplication.class, args);
	}

}
