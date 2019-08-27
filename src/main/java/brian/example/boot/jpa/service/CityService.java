package brian.example.boot.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import brian.example.boot.jpa.domain.mybatis.City;
import brian.example.boot.jpa.repository.mybatis.CityRepository;

@Service
public class CityService {

	@Autowired
	private CityRepository repo;
	
	public City getCity(String cityId) {
		return repo.findByCityId(cityId);
	}
}
