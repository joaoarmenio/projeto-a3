package com.scs.projetoa3jpa.musica;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class MusicaJPAResource {
	@Autowired
	private MusicaRepository musicaRepository;

	@GetMapping("/jpa/musicas")
	public List<Musica> retrieveAllMusicas(){
		List<Musica> musicas = musicaRepository.findAll();
		
		return musicas;
	}

	@GetMapping("/jpa/musicas/{id}")
	public EntityModel<Musica> retrieveMusica(@PathVariable int id) {
		Optional<Musica> musica = musicaRepository.findById(id);
		
		//if (!user.isPresent()) {
		//	throw new UserNotFoundException("id-"+ id);
		//}
		
		//"all-users", SERVER_PATH + "/users"
		//retrieveAllUsers
		EntityModel<Musica> resource = EntityModel.of(musica.get());
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllMusicas());
		resource.add(linkTo.withRel("all-musicas"));
		//HATEOAS
			
		return resource;
	}
	
	@DeleteMapping("/jpa/musicas/{id}")
	public void deleteUser(@PathVariable int id) {
		musicaRepository.deleteById(id);
	}
	
	@PostMapping("/jpa/musicas")
	public ResponseEntity<Object> createUser(@Valid @RequestBody Musica musica) {
		Musica savedMusica = musicaRepository.save(musica);
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedMusica.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	

}
