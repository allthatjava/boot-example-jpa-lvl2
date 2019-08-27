package brian.example.boot.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = {  DataSourceAutoConfiguration.class })  // FIXME : We exclude DataSourceAutoConfiguration because we have multiple entityManagers.
public class BootExampleJpaLvl2Application {

	public static void main(String[] args) {
		SpringApplication.run(BootExampleJpaLvl2Application.class, args);
	}
	
//	PostRepository repo = context.getBean("postRepository", PostRepository.class);
//
//	List<Post> list = repo.findAll();
//	System.out.println("Lists:====================================="+list);
}
