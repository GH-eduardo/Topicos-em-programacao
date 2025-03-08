package com.example.campeonatos.entities.time;

import com.example.campeonatos.entities.time.Time;
import com.example.campeonatos.entities.time.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/times")
public class TimeController {

    @Autowired
    private TimeService timeService;

    // Create
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Time createTime(@RequestBody Time time) {
        return timeService.createTime(time);
    }

    // Read (todos)
    @GetMapping
    public List<Time> getAllTimes() {
        return timeService.getAllTimes();
    }

    // Read (por ID)
    @GetMapping("/{id}")
    public ResponseEntity<Time> getTimeById(@PathVariable Long id) {
        return timeService.getTimeById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Time> updateTime(@PathVariable Long id, @RequestBody Time timeDetails) {
        Time updatedTime = timeService.updateTime(id, timeDetails);
        return ResponseEntity.ok(updatedTime);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTime(@PathVariable Long id) {
        timeService.deleteTime(id);
        return ResponseEntity.noContent().build();
    }
}