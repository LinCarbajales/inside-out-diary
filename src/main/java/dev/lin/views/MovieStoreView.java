package dev.lin.views;

import dev.lin.api.MovieAPI;

public class MovieStoreView {
    
    public static void printMovieStoreMenu() {
        System.out.println("Guardando película...");

        MovieAPI movieApi = new MovieAPI();

        System.out.println(movieApi.getMovieDataByImdbId("0974977"));

        HomeView.printMenu();
    }
}
