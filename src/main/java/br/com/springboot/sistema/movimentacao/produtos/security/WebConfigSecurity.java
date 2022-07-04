
package br.com.springboot.sistema.movimentacao.produtos.security

-movimentacao-produtos.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebConfigSecurity extends WebSecurityConfigurerAdapter{

	@Override // Configura a solicitação de acesso por Http
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
	}

}
