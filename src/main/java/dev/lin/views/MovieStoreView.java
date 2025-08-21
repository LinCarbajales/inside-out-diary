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

        // Obtener el año de lanzamiento
        Integer releaseYear = movieService.getReleaseYear("tt0974977");
        if (releaseYear != null) {
            System.out.println("Año de lanzamiento: " + releaseYear);
        } else {
            System.out.println("Año de lanzamiento: No disponible");
        }

        HomeView.printMenu();
    }
}
