package dev.lin.views;

import dev.lin.controllers.MovieController;
import dev.lin.daos.ApiMoviesDAO;
import dev.lin.dtos.MovieDTO;
import dev.lin.services.MovieService;

public class MovieStoreView {
    
    public static void printMovieStoreMenu() {
        System.out.println("Guardando película...");

        ApiMoviesDAO movieDAO = new ApiMoviesDAO();

        MovieService movieService = new MovieService(movieDAO);

        MovieController movieController = new MovieController(movieService);

        MovieDTO movie = movieController.getMovieByImdbId("tt0974977");

        String title =  movie.getShortInfo().getName();
        System.out.println("Título: " + title);
        System.out.println("ID de IMDb: " + movie.getImdbId());
        System.out.println(movie.getShortInfo().getReleaseDate());

        HomeView.printMenu();
    }
}
