package com.example.marksanalytics.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Marks {

    private String task;
    LocalDate day;
    int mark;
    int weight;

    @Override
    public String toString() {
        return day + " " + task + " " + mark;
    }
}
