package com.scs.projetoa3jpa.musica;

import java.net.URI;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class MusicaResource {
	
	@Autowired
	private MusicaDaoService service;
	
	@GetMapping("/musicas")
	public List<Musica> retrieveAllMusicas() {
		return service.findAll();
	}

	@GetMapping("/musicas/{id}")
	public Musica retrieveOneMusica(@PathVariable Integer id) {
		return service.findOne(id);
	}
	
	@PostMapping("/musicas")
	public ResponseEntity<Object> createMusica(@RequestBody Musica musica) {
		Musica savedMusica = service.save(musica);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id")
				.buildAndExpand(savedMusica.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/musicas/{id}")
	public Musica removeMusica(@PathVariable Integer id) {
		return service.deleteById(id);
	}

}
