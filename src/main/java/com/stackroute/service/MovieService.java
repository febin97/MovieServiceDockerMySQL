package com.stackroute.service;

import com.stackroute.domain.Movie;

import java.util.List;

public interface MovieService {
    public List<Movie> GetAllMovies();
    public Movie AddNewMovie(Movie newMovie);
    public Movie GetParticularMovie(int movieId);
    public Movie UpdateMovie(Movie newMovie, int movieId);
    public void DeleteMovie(int movieId);
    public List<Movie> GetMovieByTitle(String movieTitle);
}
