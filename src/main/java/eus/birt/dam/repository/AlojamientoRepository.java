package eus.birt.dam.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import eus.birt.dam.domain.Alojamiento;

public interface AlojamientoRepository extends MongoRepository<Alojamiento, String>{
	
}
