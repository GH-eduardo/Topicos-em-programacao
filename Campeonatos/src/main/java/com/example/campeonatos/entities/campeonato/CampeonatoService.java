package com.example.campeonatos.entities.campeonato;

import com.example.campeonatos.entities.campeonato.Campeonato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampeonatoService {

    @Autowired
    private CampeonatoRepository campeonatoRepository;

    // Create
    public Campeonato createCampeonato(Campeonato campeonato) {
        return campeonatoRepository.save(campeonato);
    }

    // Read (todos)
    public List<Campeonato> getAllCampeonatos() {
        return campeonatoRepository.findAll();
    }

    // Read (por ID)
    public Optional<Campeonato> getCampeonatoById(Long id) {
        return campeonatoRepository.findById(id);
    }

    // Update
    public Campeonato updateCampeonato(Long id, Campeonato campeonatoDetails) {
        Campeonato campeonato = campeonatoRepository.findById(id).orElseThrow(() -> new RuncampeonatoException("Campeonato não encontrado"));
        campeonato.setNome(campeonatoDetails.getNome());
        campeonato.setDataInicial(campeonatoDetails.getDataInicial());
        campeonato.setDataFinal(campeonatoDetails.getDataFinal());
        campeonato.setTimes(campeonatoDetails.getTimes());
        campeonato.setRankingTimes(campeonatoDetails.getRankingTimes());
        return campeonatoRepository.save(campeonato);
    }

    // Delete
    public void deleteCampeonato(Long id) {
        campeonatoRepository.deleteById(id);
    }
}