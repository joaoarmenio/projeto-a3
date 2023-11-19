package com.scs.projetoa3jpa;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.scs.projetoa3jpa.musica.Musica;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
	
	@Value(value="${local.server.port}")
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void returnValidMusic() throws Exception {
		Musica musica = new Musica(1,"Flores","Titãs"); 
		assertThat(this.restTemplate.getForObject("http://localhost:8080/musicas/1", Musica.class)).isEqualTo(musica);
	}
	

}
