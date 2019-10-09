package com.stackroute.service;

import com.stackroute.domain.Movie;
import com.stackroute.exception.MovieAlreadyExistsException;
import com.stackroute.exception.MovieNotFoundException;
import com.stackroute.repository.MovieRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class MovieServiceTest {
    Movie movie;

    //Create a mock for MovieRepository
    @Mock
    MovieRepository movieRepository;

    //Inject the mocks as dependencies into MovieServiceImpl
    @InjectMocks
    MovieServiceImpl movieService;
    List<Movie> list= null;


    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        movie = new Movie(123,"IMDB id Spidey",234,"Language","Movie Title:Spidey","Movie Posterpath",
                1000,120,"12th September 2019","Movie Overview","Movie TagLine");
        list = new ArrayList<>();
        list.add(movie);


    }

    @Test
    public void addNewMovieTestSuccess() throws MovieAlreadyExistsException {

        when(movieRepository.save((Movie)any())).thenReturn(movie);
        Movie savedMovie = movieService.AddNewMovie(movie);
        Assert.assertEquals(movie,savedMovie);

        //verify here verifies that movieRepository save method is only called once
        verify(movieRepository,times(1)).save(movie);

    }

    @Test(expected = MovieAlreadyExistsException.class)
    public void addNewMovieTestFailure() throws MovieAlreadyExistsException {
        when(movieRepository.save((Movie)any())).thenReturn(null);
        Movie savedMovie = movieService.AddNewMovie(null);
        System.out.println("savedMovie" + savedMovie);
        //Assert.assertEquals(movie,savedMovie);

       /*doThrow(new MovieAlreadyExistException()).when(movieRepository).findById(eq(101));
       movieService.saveMovie(movie);*/


    }
    @Test
    public void getParticularMovie(){
        movieRepository.save(movie);
        when(movieRepository.findById(anyInt())).thenReturn(java.util.Optional.ofNullable(movie));
        Movie partMovie = movieService.GetParticularMovie(123);
        Assert.assertEquals(movie,partMovie);
        verify(movieRepository,times(1)).findById(123);
    }
    @Test(expected = MovieNotFoundException.class)
    public void getParticularMovieFailure(){
        when(movieRepository.findById(anyInt())).thenThrow(MovieNotFoundException.class);
        Movie partMovie = movieService.GetParticularMovie(-10);
        System.out.println(partMovie);
    }
    @Test
    public void deleteMovie(){
        movieService.DeleteMovie(123);
        verify(movieRepository,times(1)).deleteById(123);
    }
    @Test(expected = MovieNotFoundException.class)
    public void deleteMovieFailure(){
        doThrow(MovieNotFoundException.class).when(movieRepository).deleteById(anyInt());
        movieService.DeleteMovie(-10);
    }
    @Test
    public void updateMovie(){
        when(movieRepository.findById(anyInt())).thenReturn(java.util.Optional.ofNullable(movie));
        when(movieRepository.save(any())).thenReturn(movie);
        Movie updatedMovie = movieService.UpdateMovie(movie,123);
        verify(movieRepository,times(1)).findById(123);
        verify(movieRepository,times(1)).save(movie);
    }
    @Test(expected = MovieNotFoundException.class)
    public void updateMovieFailure(){
        when(movieRepository.findById(anyInt())).thenThrow(MovieNotFoundException.class);
        when(movieRepository.save(any())).thenThrow(MovieNotFoundException.class);
        Movie updatedMovie = movieService.UpdateMovie(movie,123);
    }
    @Test
    public void getMovieByTitle(){
        when(movieRepository.getMovieWithTitle(anyString())).thenReturn(list);
        List<Movie> ls = movieService.GetMovieByTitle("Spidey");
        verify(movieRepository,times(2)).getMovieWithTitle("Spidey");
    }
    @Test(expected = MovieNotFoundException.class)
    public void getMovieByTitleFailure(){
        when(movieRepository.getMovieWithTitle(anyString())).thenThrow(MovieNotFoundException.class);
        List<Movie> ls = movieService.GetMovieByTitle("Spidey");
    }
    @Test
    public void getAllMovie(){

        movieRepository.save(movie);
        //stubbing the mock to return specific data
        when(movieRepository.findAll()).thenReturn(list);
        List<Movie> movielist = movieService.GetAllMovies();
        Assert.assertEquals(list,movielist);
    }
}
