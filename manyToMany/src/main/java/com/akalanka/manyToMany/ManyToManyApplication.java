package com.akalanka.manyToMany;

import com.akalanka.manyToMany.entity.Post;
import com.akalanka.manyToMany.entity.Tag;
import com.akalanka.manyToMany.repository.PostRepository;
import com.akalanka.manyToMany.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManyToManyApplication implements CommandLineRunner {
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		Post post = new Post("Spring Data JPA Many to Many Mapping Example with Spring Boot",
				"Learn how to map a many to many relationship using spring data jpa",
				"Content of the post");

		Tag tag1 = new Tag("Spring Boot");
		Tag tag2 = new Tag("JPA");

		post.getTags().add(tag1);
		post.getTags().add(tag2);

		tag1.getPosts().add(post);
		tag2.getPosts().add(post);

		this.postRepository.save(post);
	}

	public static void main(String[] args) {
		SpringApplication.run(ManyToManyApplication.class, args);
	}

}
