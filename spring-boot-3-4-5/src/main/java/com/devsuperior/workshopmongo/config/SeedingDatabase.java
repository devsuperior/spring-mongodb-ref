package com.devsuperior.workshopmongo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.devsuperior.workshopmongo.entities.Post;
import com.devsuperior.workshopmongo.entities.User;
import com.devsuperior.workshopmongo.repositories.PostRepository;
import com.devsuperior.workshopmongo.repositories.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Configuration
public class SeedingDatabase implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		Mono<Void> deleteUsers = userRepository.deleteAll();
		deleteUsers.subscribe();

		Mono<Void> deletePosts = postRepository.deleteAll();
		deletePosts.subscribe();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		Flux<User> insertUsers = userRepository.saveAll(Arrays.asList(maria, alex, bob));
		insertUsers.subscribe();

		Post post1 = new Post(null, Instant.parse("2022-11-21T18:35:24.00Z"), "Partiu viagem",
				"Vou viajar para São Paulo. Abraços!", maria.getId(), maria.getName());
		Post post2 = new Post(null, Instant.parse("2022-11-23T17:30:24.00Z"), "Bom dia", "Acordei feliz hoje!",
				maria.getId(), maria.getName());

		post1.addComment("Boa viagem mano!", Instant.parse("2022-11-21T18:52:24.00Z"), alex.getId(), alex.getName());
		post1.addComment("Aproveite!", Instant.parse("2022-11-22T11:35:24.00Z"), bob.getId(), bob.getName());

		post2.addComment("Tenha um ótimo dia!", Instant.parse("2022-11-23T18:35:24.00Z"), alex.getId(), alex.getName());

		Flux<Post> insertPosts = postRepository.saveAll(Arrays.asList(post1, post2));
		insertPosts.subscribe();
	}

}
