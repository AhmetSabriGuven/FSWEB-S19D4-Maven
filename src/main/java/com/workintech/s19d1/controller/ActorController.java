package com.workintech.s19d1.controller;

import com.workintech.s19d1.dto.ActorRequest;
import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.service.ActorService;
import com.workintech.s19d1.util.HollywoodValidation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/actor", "/actors"})
@RequiredArgsConstructor
@Slf4j
public class ActorController {

    private final ActorService actorService;

    @GetMapping
    public List<Actor> findAll() {
        return actorService.findAll();
    }

    @GetMapping("/{id}")
    public Actor findById(@PathVariable Long id) {
        HollywoodValidation.checkId(id);
        return actorService.findById(id);
    }

    @PostMapping
    public Actor save(@Valid @RequestBody ActorRequest request) {
        Actor actor = request.getActor();
        if (request.getMovies() != null) {
            for (Movie movie : request.getMovies()) {
                actor.addMovie(movie);
            }
        }
        return actorService.save(actor);
    }

    @PutMapping("/{id}")
    public Actor update(@PathVariable Long id, @Valid @RequestBody Actor actor) {
        HollywoodValidation.checkId(id);
        actorService.findById(id);
        actor.setId(id);
        return actorService.save(actor);
    }

    @DeleteMapping("/{id}")
    public Actor delete(@PathVariable Long id) {
        HollywoodValidation.checkId(id);
        Actor actor = actorService.findById(id);
        actorService.delete(actor);
        return actor;
    }
}
