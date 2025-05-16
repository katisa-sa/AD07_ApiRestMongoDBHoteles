package eus.dam.api.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eus.dam.api.domain.Hotel;
import eus.dam.api.repository.HotelRepository;

@CrossOrigin (origins= {"http://localhost:4200"})
//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api")
public class HotelesController {

	
	@Autowired
	HotelRepository hotelRepository;
	
	/**
	 * Endpoint principal de hoteles.
	 * @return
	 */
	@GetMapping("/hotels")
	public ResponseEntity<List<Hotel>> index() {
	    try {
	        List<Hotel> hotels = hotelRepository.findAll();
	        System.out.println("Hotels found: " + hotels.size());
	        return new ResponseEntity<List<Hotel>>(hotels, HttpStatus.OK);	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<List<Hotel>>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@GetMapping("/provinces")
	public ResponseEntity<List<String>> getAllTerritories() {
	    try {
	        List<Hotel> hotels = hotelRepository.findAll();
	        Set<String> uniqueTerritories = new HashSet<>();
	        for (Hotel hotel : hotels) {
	            uniqueTerritories.add(hotel.getProperties().getTerritory());
	        }
	        List<String> sortedTerritories = new ArrayList<>(uniqueTerritories);
	        Collections.sort(sortedTerritories);
	        return new ResponseEntity<List<String>>(sortedTerritories, HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<List<String>>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@GetMapping("/categoria")
	public ResponseEntity<List<String>> getAllCategories() {
	    try {
	        List<Hotel> hotels = hotelRepository.findAll();
	        Set<String> uniqueCategories = new HashSet<>();
	        for (Hotel hotel : hotels) {
	            uniqueCategories.add(hotel.getProperties().getCategory());
	        }
	        List<String> sortedCategories = new ArrayList<>(uniqueCategories);
	        Collections.sort(sortedCategories);
	        return new ResponseEntity<List<String>>(sortedCategories, HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<List<String>>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@GetMapping("/capacidad")
	public ResponseEntity<List<String>> getAllCapacity() {
	    try {
	        List<Hotel> hotels = hotelRepository.findAll();
	        Set<String> uniqueCapacity = new HashSet<>();
	        for (Hotel hotel : hotels) {
	            uniqueCapacity.add(hotel.getProperties().getCapacity());
	        }
	        List<String> sortedCapacity = new ArrayList<>(uniqueCapacity);
	        Collections.sort(sortedCapacity);
	        return new ResponseEntity<List<String>>(sortedCapacity, HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<List<String>>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@GetMapping("/tipo")
	public ResponseEntity<List<String>>getAllTipos() {
	    try {
	        List<Hotel> hotels = hotelRepository.findAll();
	        Set<String> uniqueLodgingtype = new HashSet<>();
	        for (Hotel hotel : hotels) {
	            uniqueLodgingtype.add(hotel.getProperties().getLodgingtype());
	        }
	        List<String> sortedLodgingtype = new ArrayList<>(uniqueLodgingtype);
	        Collections.sort(sortedLodgingtype);
	        return new ResponseEntity<List<String>>(sortedLodgingtype, HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<List<String>>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}