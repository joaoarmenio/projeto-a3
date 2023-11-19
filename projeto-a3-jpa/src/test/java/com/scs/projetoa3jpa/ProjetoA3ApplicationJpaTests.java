package com.scs.projetoa3jpa;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.scs.projetoa3jpa.musica.MusicaResource;

@SpringBootTest
class ProjetoA3ApplicationJpaTests {
	
	@Autowired
	private MusicaResource controller;

	@Test
	void contextLoads() throws Exception {
		assertThat(controller).isNotNull(); 
	}

}
