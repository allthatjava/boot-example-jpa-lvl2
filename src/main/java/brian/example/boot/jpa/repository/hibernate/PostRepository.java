package brian.example.boot.jpa.repository.hibernate;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import brian.example.boot.jpa.domain.hibernate.Post;

@Repository
@Transactional(value = "mybatisEntityManager")
//@Transactional(value = "entityManager")
public interface PostRepository extends CrudRepository<Post, Integer>{
	
	public Post findByPostId(Integer postId);
}
