package com.example.movie_recommendation.service;

import com.example.movie_recommendation.model.Movie;
import com.example.movie_recommendation.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository)
    {
        this.movieRepository= movieRepository;
    }

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public Optional<Movie> getMovieById(String movie_id) {
        return movieRepository.findById(movie_id);
    }

    public void deleteMovie(String movie_id) {
        movieRepository.delete(movie_id);
    }



}
