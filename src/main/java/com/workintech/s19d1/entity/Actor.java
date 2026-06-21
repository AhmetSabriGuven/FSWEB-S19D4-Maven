package com.workintech.s19d1.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "actor")
@Getter
@Setter
@NoArgsConstructor
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Gender gender;

    @NotNull
    private LocalDate birthDate;

    @ManyToMany(mappedBy = "actors", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnoreProperties("actors")
    private List<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie) {
        if (movie == null) {
            return;
        }
        if (movies == null) {
            movies = new ArrayList<>();
        }
        if (!movies.contains(movie)) {
            movies.add(movie);
        }
        if (movie.getActors() == null) {
            movie.setActors(new ArrayList<>());
        }
        if (!movie.getActors().contains(this)) {
            movie.getActors().add(this);
        }
    }
}
