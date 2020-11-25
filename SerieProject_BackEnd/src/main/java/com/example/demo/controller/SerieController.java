package com.example.demo.controller;

import com.example.demo.exception.RessourceNotFoundException;
import com.example.demo.model.Serie;
import com.example.demo.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class SerieController {

    @Autowired
    private SerieRepository serieRepository;

    //get all serie
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/series")
    public List<Serie> getAllSerie(){
        return serieRepository.findAll();
    }

    //create serie rest api
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/series")
    public Serie createSerie(@RequestBody Serie serie){
        return serieRepository.save(serie);
    }

    //serie by id
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/series/{id}")
    //On connecte l'id avec le mapping
    public ResponseEntity<Serie> getSerieById(@PathVariable Long id){
        Serie serie = serieRepository.findById(id).orElseThrow(() -> new RessourceNotFoundException("La série n'existe pas"));
        return ResponseEntity.ok(serie);
    }

    //update serie
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/series/{id}")
    public ResponseEntity<Serie> updateSerie(@PathVariable Long id, @RequestBody Serie serieDetails){
        Serie serie = serieRepository.findById(id).orElseThrow(() -> new RessourceNotFoundException("La série n'existe pas"));
        serie.setName(serieDetails.getName());
        serie.setNbepisode(serieDetails.getNbepisode());
        serie.setNbsaison(serieDetails.getNbsaison());

        Serie updatedSerie = serieRepository.save(serie);
        return ResponseEntity.ok(updatedSerie);
    }

    //delete serie
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/series/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteSerie(@PathVariable Long id){
        Serie serie = serieRepository.findById(id).orElseThrow(() -> new RessourceNotFoundException("La série n'existe pas"));
        serieRepository.delete(serie);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
