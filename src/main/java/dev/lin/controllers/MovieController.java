package dev.lin.controllers;

import dev.lin.dtos.MovieDTO;
import dev.lin.services.MovieService;

public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    public MovieDTO getMovieByImdbId(String imdbId) {
        return movieService.getMovieInfoAndMapToDTO(imdbId);
    }
}