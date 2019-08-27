package brian.example.boot.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import brian.example.boot.jpa.domain.mybatis.City;
import brian.example.boot.jpa.service.CityService;

@RestController
public class CityController {

	@Autowired
	private CityService service;
	
	@GetMapping(value="/city/{cityId}")
	public City getPost(@PathVariable("cityId") String cityId)
	{
		return service.getCity(cityId);
	}
}
