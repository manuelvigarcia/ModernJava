package com.modernjava.http;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//@Disabled
public class MoviesClientTest {

    MoviesClient moviesClient = new MoviesClient();

    /*
    Must have jwebserver running and serving files from modernjava.
     */


    @Test
    void getMovieById(){
        var movie = moviesClient.getMovieById();

        assertNotNull(movie);
        assertEquals("Batman Begins", movie.name());
    }

    @Test
    void getMovieByIdAsync(){
        var movie = moviesClient.getMovieByIdAsync().join();

        assertNotNull(movie);
        assertEquals("Batman Begins", movie.name());
    }

    @Test
    void getAllMoviesById() {
        var moviesList = moviesClient.getAllMovies();

        assertNotNull(moviesList);
        assert moviesList.size() == 10;
    }
}
