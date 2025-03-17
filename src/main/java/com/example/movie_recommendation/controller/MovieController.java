package com.example.movie_recommendation.controller;

import com.example.movie_recommendation.model.Movie;
import com.example.movie_recommendation.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService)
    {
        this.movieService=movieService;
    }
    @PostMapping
    public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
        return ResponseEntity.ok("Movie added successfully!");
    }

    @GetMapping("/{movie_id}")
    public ResponseEntity<Movie> getMovie(@PathVariable String movie_id) {
        Optional<Movie> movie = movieService.getMovieById(movie_id);
        return movie.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{movie_id}")
    public ResponseEntity<String> deleteMovie(@PathVariable String movie_id) {
        movieService.deleteMovie(movie_id);
        return ResponseEntity.ok("Movie deleted successfully!");
    }


}
