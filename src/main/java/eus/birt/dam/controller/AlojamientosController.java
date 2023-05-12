package eus.birt.dam.controller;

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

import eus.birt.dam.domain.Alojamiento;
import eus.birt.dam.repository.AlojamientoRepository;


@RestController
@RequestMapping("/api")
public class AlojamientosController {

	
	@Autowired
	AlojamientoRepository alojamientoRepository;
	
	/**
	 * Endpoint principal de hoteles.
	 * @return
	 */
	@GetMapping("/alojamientos")
	public ResponseEntity<List<Alojamiento>> index() {
	    try {
	        List<Alojamiento> hotels = alojamientoRepository.findAll();
	        return new ResponseEntity<List<Alojamiento>>(hotels, HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<List<Alojamiento>>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@GetMapping("/localidades")
	public ResponseEntity<Set<String>> getLocalidades() {
	    try {
	        List<Alojamiento> alojamientos = alojamientoRepository.findAll();
	        Set<String> localidades = new HashSet<>();
	        for (Alojamiento alojamiento : alojamientos) {
	        	localidades.add(alojamiento.getProperties().getLocality());
	        }
	        //List<String> localidadesOrdenadas = new ArrayList<>(localidades);
	        //Collections.sort(localidadesOrdenadas);
	        return new ResponseEntity<Set<String>>(localidades, HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<Set<String>>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@GetMapping("/capacidades")
	public ResponseEntity<List<String>> getCapacidades() {
	    try {
	        List<Alojamiento> alojamientos = alojamientoRepository.findAll();
	        Set<String> capacidades = new HashSet<>();
	        for (Alojamiento alojamiento : alojamientos) {
	        	capacidades.add(alojamiento.getProperties().getCapacity());
	        }
	        List<String> capacidadesOrdenadas = new ArrayList<>(capacidades);
	        Collections.sort(capacidadesOrdenadas);
	        return new ResponseEntity<List<String>>(capacidadesOrdenadas, HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<List<String>>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
}