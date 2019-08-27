package brian.example.boot.jpa.repository.mybatis;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import brian.example.boot.jpa.domain.mybatis.City;

@Repository
@Transactional(value = "hibernateEntityManager")
public interface CityRepository extends CrudRepository<City, String> {
	
	public City findByCityId(String cityId);
}
