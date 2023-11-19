package com.scs.projetoa3jpa;


import org.junit.jupiter.api.Test;

import com.scs.projetoa3jpa.musica.Musica;

import junit.framework.TestCase;

public class TestMusica extends TestCase{
	@Test
	public void testMusica() {
		Integer identifier = 5;
		String nome = "Hey Jude";
		String banda = "Beatles";
		Musica musicaEncontrado = new Musica();
		musicaEncontrado.setId(5);
		musicaEncontrado.setNome("Hey Jude");
		musicaEncontrado.setBanda("Beatles");
		assertEquals(nome, musicaEncontrado.getNome());
		assertEquals(banda, musicaEncontrado.getBanda());
		assertEquals(identifier,musicaEncontrado.getId());
		
	}
}
