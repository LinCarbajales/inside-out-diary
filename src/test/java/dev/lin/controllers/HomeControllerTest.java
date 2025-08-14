package dev.lin.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import dev.lin.views.HomeView;

import static org.mockito.Mockito.*;

class HomeControllerTest {

    private MockedStatic<HomeView> mockedHomeView;

    @BeforeEach
    void setUp() {
        mockedHomeView = Mockito.mockStatic(HomeView.class);
    }

    @AfterEach
    void tearDown() {
        mockedHomeView.close();
    }

    @Test
    void constructorShouldCallIndex() {
        // Given & When
        new HomeController();

        // Then
        mockedHomeView.verify(HomeView::printMenu, times(1));
    }

    @Test
    void indexShouldCallHomeViewPrintMenu() {
        // Given
        HomeController controller = mock(HomeController.class);
        doCallRealMethod().when(controller).index();

        // When
        controller.index();

        // Then
        mockedHomeView.verify(HomeView::printMenu, times(1));
    }

    @Test
    void constructorShouldCallIndexOnlyOnce() {
        // Given & When
        new HomeController();

        // Then
        mockedHomeView.verify(HomeView::printMenu, times(1));
        mockedHomeView.verifyNoMoreInteractions();
    }
}