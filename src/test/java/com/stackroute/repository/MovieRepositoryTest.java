package com.stackroute.repository;

import com.stackroute.domain.Movie;
import com.stackroute.exception.MovieNotFoundException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.NoSuchElementException;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MovieRepositoryTest {
    @Autowired
    MovieRepository movieRepository;
    Movie movie;

    @Before
    public void setUp()
    {
        movie = new Movie(123,"IMDB id Spidey",234,"Language","Movie Title:Spidey","Movie Posterpath",
                1000,120,"12th September 2019","Movie Overview","Movie TagLine");

    }

    @After
    public void tearDown(){

        movieRepository.deleteAll();
    }


    @Test
    public void testAddNewMovie(){
        movieRepository.save(movie);
        Movie fetchMovie = movieRepository.findById(movie.getMovieId()).get();
        Assert.assertEquals(123,fetchMovie.getMovieId().longValue());
    }

    @Test
    public void testAddNewMovieFailure(){
        Movie testMovie = new Movie(123,"IMDB id Spidey",234,"Language","Movie Title:Spidey","Movie Posterpath",
                1000,120,"12th September 2019","Movie Overview","Movie TagLine");

        movieRepository.save(movie);
        Movie fetchMovie = movieRepository.findById(movie.getMovieId()).get();
        Assert.assertNotSame(testMovie,movie);
    }
    @Test
    public void testGetParticularMovie(){
        movieRepository.save(movie);
        Movie movieTest = movieRepository.findById(movie.getMovieId()).get();
        Assert.assertEquals(movieTest,movie);
    }
    @Test(expected = NoSuchElementException.class)
    public void testGetParticularMovieFailure(){
        movieRepository.save(movie);
        Movie movieTest = movieRepository.findById(1).get();
    }
    @Test
    public void testDeleteMovie(){
        movieRepository.save(movie);
        movieRepository.deleteById(movie.getMovieId());
        Assert.assertEquals(false,movieRepository.existsById(movie.getMovieId()));
    }
    @Test
    public void testDeleteMovieFailure(){
        movieRepository.save(movie);
        movieRepository.deleteById(movie.getMovieId());
        Assert.assertNotEquals(true,movieRepository.existsById(movie.getMovieId()));
    }
    @Test
    public void testFindByName(){
        movieRepository.save(movie);
        List<Movie> fetchMovie = movieRepository.getMovieWithTitle(movie.getMovieTitle());
        Assert.assertEquals(123,fetchMovie.get(0).getMovieId().longValue());
    }
    @Test
    public void testFindByNameFailure(){
        movieRepository.save(movie);
        List<Movie> fetchMovie = movieRepository.getMovieWithTitle(movie.getMovieTitle());
        Assert.assertNotEquals(java.util.Optional.of(2),fetchMovie.get(0).getMovieId().longValue());
    }
    @Test
    public void testGetAllMovie(){
        Movie u = new Movie(123,"IMDB id Spidey",234,"Language","Movie Title:Spidey","Movie Posterpath",
                1000,120,"12th September 2019","Movie Overview","Movie TagLine");

        Movie u1 = new Movie(124,"IMDB id Spidey",234,"Language","Movie Title:Spidey","Movie Posterpath",
                1000,120,"12th September 2019","Movie Overview","Movie TagLine");

        movieRepository.save(u);
        movieRepository.save(u1);

        List<Movie> list = movieRepository.findAll();
        Assert.assertEquals(2,list.size());
    }

}
