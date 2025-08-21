package dev.lin.services;

import dev.lin.daos.ApiMoviesDAO;
import dev.lin.dtos.MovieDTO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MovieService {
    
    private ApiMoviesDAO movieDAO;

    public MovieService(ApiMoviesDAO movieDAO) {
        this.movieDAO = movieDAO;
    }

    public MovieDTO getMovieInfoAndMapToDTO(String imdbId) {
        
        Gson gson = new GsonBuilder().create();
        String movieData = movieDAO.getMovie(imdbId);

        MovieDTO movieDTO = gson.fromJson(movieData, MovieDTO.class);

        return movieDTO;
    }

}