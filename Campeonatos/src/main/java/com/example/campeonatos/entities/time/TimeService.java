package com.example.campeonatos.entities.time;

import com.example.campeonatos.entities.time.Time;
import com.example.campeonatos.entities.time.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    // Create
    public Time createTime(Time time) {
        return timeRepository.save(time);
    }

    // Read (todos)
    public List<Time> getAllTimes() {
        return timeRepository.findAll();
    }

    // Read (por ID)
    public Optional<Time> getTimeById(Long id) {
        return timeRepository.findById(id);
    }

    // Update
    public Time updateTime(Long id, Time timeDetails) {
        Time time = timeRepository.findById(id).orElseThrow(() -> new RuntimeException("Time não encontrado"));
        time.setNome(timeDetails.getNome());
        time.setPontos(timeDetails.getPontos());
        return timeRepository.save(time);
    }

    // Delete
    public void deleteTime(Long id) {
        timeRepository.deleteById(id);
    }
}