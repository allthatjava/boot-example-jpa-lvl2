package brian.example.boot.jpa.repository.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import brian.example.boot.jpa.domain.hibernate.TestUser;

@Repository
@Transactional(value = "hibernateEntityManager")
public interface TestUserRepository extends JpaRepository<TestUser, Integer>{


}