package com.workintech.s19d1.controller;

import com.workintech.s19d1.dto.MovieRequest;
import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.service.MovieService;
import com.workintech.s19d1.util.HollywoodValidation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/movie", "/movies"})
@RequiredArgsConstructor
@Slf4j
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public List<Movie> findAll() {
        return movieService.findAll();
    }

    @GetMapping("/{id}")
    public Movie findById(@PathVariable Long id) {
        HollywoodValidation.checkId(id);
        return movieService.findById(id);
    }

    @PostMapping
    public Movie save(@Valid @RequestBody MovieRequest request) {
        Movie movie = request.getMovie();
        if (request.getActors() != null) {
            for (Actor actor : request.getActors()) {
                movie.addActor(actor);
            }
        }
        return movieService.save(movie);
    }

    @PutMapping("/{id}")
    public Movie update(@PathVariable Long id, @Valid @RequestBody Movie movie) {
        HollywoodValidation.checkId(id);
        movieService.findById(id);
        movie.setId(id);
        return movieService.save(movie);
    }

    @DeleteMapping("/{id}")
    public Movie delete(@PathVariable Long id) {
        HollywoodValidation.checkId(id);
        Movie movie = movieService.findById(id);
        movieService.delete(movie);
        return movie;
    }
}
