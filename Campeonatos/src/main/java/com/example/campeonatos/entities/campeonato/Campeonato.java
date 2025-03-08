package com.example.campeonatos.entities.campeonato;

import com.example.campeonatos.entities.time.Time;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Comparator;
import java.util.Date;
import java.util.Arrays;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Campeonato {

    private String nome;
    private Date DataInicial;
    private Date DataFinal;

    private Time[] times; //ordem alfabética
    private Time[] RankingTimes;

    public Time[] Ranking() {
        Arrays.sort(RankingTimes, Comparator.comparingInt(Time::getPontos));
        return RankingTimes;
    }

    public void setTimes(Time[] novoTime) {
        this.times = Arrays.copyOf(times, times.length + 1);
        times[times.length - 1] = novoTime[0];
    }
}


