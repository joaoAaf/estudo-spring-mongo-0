package com.estudo.estudoSpringMongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.estudo.estudoSpringMongo.domain.Post;
import com.estudo.estudoSpringMongo.domain.User;
import com.estudo.estudoSpringMongo.dto.AuthorDTO;
import com.estudo.estudoSpringMongo.repository.PostRepository;
import com.estudo.estudoSpringMongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PostRepository postRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat fDate = new SimpleDateFormat("dd/MM/yyyy");
		fDate.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepo.deleteAll();
		postRepo.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepo.saveAll(Arrays.asList(maria,alex,bob));
		
		Post post1 = new Post(null, fDate.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, fDate.parse("23/03/2018"), "Bom dia!", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		postRepo.saveAll(Arrays.asList(post1,post2));
	}

}
