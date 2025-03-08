package com.example.campeonatos.entities.campeonato;

import com.example.campeonatos.entities.campeonato.Campeonato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campeonatos")
public class CampeonatoController {

    @Autowired
    private CampeonatoService campeonatoService;

    // Create
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Campeonato createCampeonato(@RequestBody Campeonato campeonato) {
        return campeonatoService.createCampeonato(campeonato);
    }

    // Read (todos)
    @GetMapping
    public List<Campeonato> getAllCampeonatos() {
        return campeonatoService.getAllCampeonatos();
    }

    // Read (por ID)
    @GetMapping("/{id}")
    public ResponseEntity<Campeonato> getCampeonatoById(@PathVariable Long id) {
        return campeonatoService.getCampeonatoById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Campeonato> updateCampeonato(@PathVariable Long id, @RequestBody Campeonato campeonatoDetails) {
        Campeonato updatedCampeonato = campeonatoService.updateCampeonato(id, campeonatoDetails);
        return ResponseEntity.ok(updatedCampeonato);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCampeonato(@PathVariable Long id) {
        campeonatoService.deleteCampeonato(id);
        return ResponseEntity.noContent().build();
    }
}