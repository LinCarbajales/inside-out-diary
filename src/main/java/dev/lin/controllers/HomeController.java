package dev.lin.controllers;

import dev.lin.views.HomeView;

public class HomeController {
   
    public HomeController() {
        index();
    }
    
    public void index() {
        HomeView.printMenu();
    }

}