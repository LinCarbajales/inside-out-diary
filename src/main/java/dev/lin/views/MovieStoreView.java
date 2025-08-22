package dev.lin.views;

import dev.lin.controllers.MovieController;
import dev.lin.daos.ApiMoviesDAO;
import dev.lin.dtos.MovieDTO;
import dev.lin.services.MovieService;

public class MovieStoreView extends View {
    
    public static void printMovieStoreMenu() {

        ApiMoviesDAO movieDAO = new ApiMoviesDAO();

        MovieService movieService = new MovieService(movieDAO);

        MovieController movieController = new MovieController(movieService);

        System.out.println("Escribe la Id de Internet Movie Database de la película:");

        String inputId = SCANNER.nextLine();

        String imdbId = "tt" + inputId;

        System.out.println(imdbId);

        MovieDTO movie = movieController.getMovieByImdbId(imdbId);

        // 0974977 - Bad Biology 

        System.out.println("Guardando película...");

        String title =  movie.getShortInfo().getName();
        System.out.println("Título: " + title);
        System.out.println("ID de IMDb: " + movie.getImdbId());

        // Obtener el año de estreno
        Integer releaseYear = movieService.getReleaseYear(imdbId);
        if (releaseYear != null) {
            System.out.println("Año de estreno: " + releaseYear);
        } else {
            System.out.println("Año de estreno: No disponible");
        }

        // Obtener los géneros
        String[] genres = movieService.getGenres(imdbId);
        if (genres != null && genres.length > 0) {
            System.out.print("Géneros: ");
            for (int i = 0; i < genres.length; i++) {
                System.out.print(genres[i]);
                if (i < genres.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        } else {
            System.out.println("Géneros: No disponibles");
        }


        HomeView.printMenu();
    }
}
