package eus.dam.api.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import eus.dam.api.domain.Hotel;

public interface HotelRepository extends MongoRepository<Hotel, String>{
	
}
