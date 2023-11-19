package com.scs.projetoa3jpa;

import org.junit.jupiter.api.Test;

import com.scs.projetoa3jpa.musica.Musica;
import com.scs.projetoa3jpa.musica.MusicaDaoService;

import junit.framework.TestCase;

public class TestMusicaDao extends TestCase {
	@Test
	public void testMusicaDao() {
		Integer identifier = 5;
		String nome = "Hey Jude";
		String banda = "Beatles";
		Musica musicaEsperado = new Musica(identifier,nome,banda);
		MusicaDaoService service = new MusicaDaoService();
		
		//test save and find one
		service.save(musicaEsperado);
		Musica musicaEncontrado = new Musica();
		musicaEncontrado = service.findOne(identifier);
		assertEquals(nome, musicaEncontrado.getNome());
		assertEquals(banda, musicaEncontrado.getBanda());
		assertEquals(identifier,musicaEncontrado.getId());		
		
		//test delete 
		musicaEncontrado = service.deleteById(identifier);
		assertEquals(nome, musicaEncontrado.getNome());
		assertEquals(banda, musicaEncontrado.getBanda());
		assertEquals(identifier,musicaEncontrado.getId());				
	}
}
