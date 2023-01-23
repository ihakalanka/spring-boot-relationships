package com.akalanka.oneToMany;

import com.akalanka.oneToMany.entity.Comment;
import com.akalanka.oneToMany.entity.Post;
import com.akalanka.oneToMany.repository.CommentRepository;
import com.akalanka.oneToMany.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OneToManyApplication implements CommandLineRunner {
	@Autowired
	private PostRepository postRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Override
	public void run(String... args) throws Exception {
		Post post = new Post("Post One", "Post Description");

		Comment comment = new Comment("Comment One");
		Comment comment2 = new Comment("Comment Two");

		post.getComments().add(comment);
		post.getComments().add(comment2);

		postRepository.save(post);
	}

	public static void main(String[] args) {
		SpringApplication.run(OneToManyApplication.class, args);
	}

}
