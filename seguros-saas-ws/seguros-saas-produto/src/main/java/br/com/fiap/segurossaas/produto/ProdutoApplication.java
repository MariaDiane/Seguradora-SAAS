package br.com.fiap.segurossaas.produto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.segurossaas.repository.ProdutoRepository;

@SpringBootApplication
@Configuration
@ComponentScan(basePackageClasses=ProdutoRepository.class)
public class ProdutoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProdutoApplication.class, args);
	}
}
