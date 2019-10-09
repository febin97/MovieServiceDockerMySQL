package com.stackroute.service;

import com.stackroute.domain.Movie;
import com.stackroute.exception.MovieAlreadyExistsException;
import com.stackroute.exception.MovieNotFoundException;
import com.stackroute.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Primary
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> GetAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie AddNewMovie(Movie newMovie) {
        try {
            return (Movie) movieRepository.findById(newMovie.getMovieId())
                    .map(movie -> {
                        throw new MovieAlreadyExistsException("Already Exists");
                    }).orElseGet(() -> {
                        return movieRepository.save(newMovie);
                    });
        }catch (NullPointerException e){
            throw new MovieAlreadyExistsException("");
        }
    }

    @Override
    public Movie GetParticularMovie(int movieId) {
        return movieRepository.findById(movieId).orElseThrow(()->new MovieNotFoundException("Movie Not Found"));
    }

    @Override
    public Movie UpdateMovie(Movie newMovie, int movieId) {
        return movieRepository.findById(movieId)
                .map(movie -> {
                    movie.setImdbId(newMovie.getImdbId());
                    movie.setMovieBudget(newMovie.getMovieBudget());
                    movie.setMovieLanguage(newMovie.getMovieLanguage());
                    movie.setMovieOverview(newMovie.getMovieOverview());
                    movie.setMoviePosterPath(newMovie.getMoviePosterPath());
                    movie.setMovieReleaseDate(newMovie.getMovieReleaseDate());
                    movie.setMovieRevenue(newMovie.getMovieRevenue());
                    movie.setMovieRunTime(newMovie.getMovieRunTime());
                    movie.setMovieTagLine(newMovie.getMovieTagLine());
                    movie.setMovieTitle(newMovie.getMovieTitle());
                    return movieRepository.save(movie);
                })
                .orElseGet(()->{
                    throw new MovieNotFoundException("Movie Not Found For Updation");
                });
    }

    @Override
    public void DeleteMovie(int movieId) {
        try{
            movieRepository.deleteById(movieId);
        }catch (Exception e ){
            throw new MovieNotFoundException("Movie Not Found for Deletion");
        }
    }

   @Override
    public List<Movie> GetMovieByTitle(String movieTitle) {

           if(movieRepository.getMovieWithTitle(movieTitle).isEmpty()){
                throw new MovieNotFoundException("Movie with given Name not Found!");
           }
           return movieRepository.getMovieWithTitle(movieTitle);
    }
}
