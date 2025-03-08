package com.example.campeonatos.entities.campeonato;

import com.example.campeonatos.entities.time.Time;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampeonatoRepository extends JpaRepository<Time, Long> {
}