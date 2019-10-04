package com.stackroute.service;

import com.stackroute.domain.Movie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Profile("dummy")                           //Set spring.profiles.active=dummy in application.properties to implement dummy service above the other one
public class MovieDummyServiceImpl implements MovieService {
    @Override
    public List<Movie> GetAllMovies() {
        return null;
    }

    @Override
    public Movie AddNewMovie(Movie newMovie) {
        return null;
    }

    @Override
    public Movie GetParticularMovie(int movieId) {
        return null;
    }

    @Override
    public Movie UpdateMovie(Movie newMovie, int movieId) {
        return null;
    }

    @Override
    public void DeleteMovie(int movieId) {

    }

    @Override
    public List<Movie> GetMovieByTitle(String movieTitle) {
        return null;
    }
}
