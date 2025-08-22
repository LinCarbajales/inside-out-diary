package dev.lin.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import dev.lin.dtos.MovieDTO;
import dev.lin.daos.ApiMoviesDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MovieServiceTest {

    private MovieService movieService;

    @BeforeEach
    void setUp() {
     this.movieService = new MovieService(new ApiMoviesDAO());
    }

    @Test
    void testMappingResponseBody_ShouldReturnAMovieDTO() {
        String imdbId = "tt2250912";
        MovieDTO movieInfo = movieService.getMovieInfoAndMapToDTO(imdbId);
        
        assertThat(movieInfo.getImdbId(), is(equalTo(imdbId)));
        assertThat(movieInfo.getShortInfo().getName(), is(equalTo("Spider-Man: Homecoming")));
        assertThat(movieInfo.getShortInfo().getUrl(), is(equalTo("https://www.imdb.com/title/tt2250912/")));
        assertThat(movieInfo.getShortInfo().getImage(), is(equalTo("https://m.media-amazon.com/images/M/MV5BODY2MTAzOTQ4M15BMl5BanBnXkFtZTgwNzg5MTE0MjI@._V1_.jpg")));
        assertThat(movieInfo.getShortInfo().getGenre().length, is(equalTo(3)));
        assertThat(movieInfo.getShortInfo().getGenre()[0], is(equalTo("Action")));
    }

}