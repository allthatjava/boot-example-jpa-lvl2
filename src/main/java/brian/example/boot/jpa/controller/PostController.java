package brian.example.boot.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import brian.example.boot.jpa.domain.hibernate.Post;
import brian.example.boot.jpa.service.PostService;

@RestController
public class PostController {

	@Autowired
	private PostService service;
	
	@GetMapping(value="/hello")
	public String hello() {
		return "Hello";
	}
	
	@GetMapping(value="/post/{postId}")
	public Post getPost(@PathVariable("postId") int postId)
	{
		return service.getPost(postId);
	}
}
