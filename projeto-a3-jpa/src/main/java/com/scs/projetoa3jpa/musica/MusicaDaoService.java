package com.scs.projetoa3jpa.musica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class MusicaDaoService {
	private static List<Musica> musicas = new ArrayList<>();
	
	private int musicasCount = 3;
	
	static {
		musicas.add(new Musica(1,"Flores","Titãs"));
		musicas.add(new Musica(2,"All My Life","Foo Fighters"));
		musicas.add(new Musica(3,"The Unforgiven","Metallica"));
	}
	
	public List<Musica> findAll () {
		return musicas;
	}
	
	public Musica save(Musica musica) {
		if (musica.getId() == 0) {
			musica.setId(++musicasCount);
		}
		musicas.add(musica);
		return musica;
	}
	
	public Musica findOne(Integer id) {
		for (Musica musica:musicas) {
			if (musica.getId() == id) {
				return musica;
			}
		}
		return null;
	}
	
	public Musica deleteById(Integer id) {
		Iterator<Musica> iterator = musicas.iterator();
		while (iterator.hasNext()) {
			Musica musica = iterator.next();
			if (musica.getId() == id) {
				iterator.remove();
				return musica;
			}
		}
		return null;		
	}
}
