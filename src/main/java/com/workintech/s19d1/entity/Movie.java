package com.workintech.s19d1.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movie")
@Getter
@Setter
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String directorName;

    @Min(0)
    @Max(10)
    private int rating;

    @NotNull
    private LocalDate releaseDate;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "movie_actor",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    @JsonIgnoreProperties("movies")
    private List<Actor> actors = new ArrayList<>();

    public void addActor(Actor actor) {
        if (actor == null) {
            return;
        }
        if (actors == null) {
            actors = new ArrayList<>();
        }
        if (!actors.contains(actor)) {
            actors.add(actor);
        }
        if (actor.getMovies() == null) {
            actor.setMovies(new ArrayList<>());
        }
        if (!actor.getMovies().contains(this)) {
            actor.getMovies().add(this);
        }
    }
}
