package dev.lin.views;

import dev.lin.api.ApiMoviesDAO;

public class MovieStoreView {
    
    public static void printMovieStoreMenu() {
        System.out.println("Guardando película...");

        ApiMoviesDAO movieApi = new ApiMoviesDAO();

        System.out.println(movieApi.getMovie("0974977"));

        HomeView.printMenu();
    }
}
