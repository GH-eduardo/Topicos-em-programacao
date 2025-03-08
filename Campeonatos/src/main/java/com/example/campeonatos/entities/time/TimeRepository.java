package com.example.campeonatos.entities.time;

import com.example.campeonatos.entities.time.Time;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRepository extends JpaRepository<Time, Long> {
}