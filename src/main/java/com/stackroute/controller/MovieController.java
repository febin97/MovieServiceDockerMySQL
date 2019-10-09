package com.stackroute.controller;

import com.stackroute.domain.Movie;
import com.stackroute.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private  MovieService movieService;
    private ResponseEntity responseEntity;
    @GetMapping("/")
    public List<Movie> GetAllMovies(){
        return movieService.GetAllMovies();
    }
    @PostMapping("/")
    public ResponseEntity<?> addNewMovie(@RequestBody Movie newMovie){

        try{
            movieService.AddNewMovie(newMovie);
            responseEntity = new ResponseEntity<String>("Successfully Created", HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println(e.getMessage());
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getParticularMovie(@PathVariable int id){
        try{
            responseEntity = new ResponseEntity<Movie>(movieService.GetParticularMovie(id),HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
    @GetMapping("/movieName={movieTitle}")
    public ResponseEntity<?> getMoviesByTitle(@PathVariable String movieTitle){
        try{
            responseEntity = new ResponseEntity<List<Movie>>(movieService.GetMovieByTitle(movieTitle),HttpStatus.FOUND);
        }catch (Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateMovie(@RequestBody Movie newMovie, @PathVariable int id){
        try{
            responseEntity= new ResponseEntity<Movie>(movieService.UpdateMovie(newMovie,id),HttpStatus.FOUND);
        }catch (Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable int id){
        try{
            movieService.DeleteMovie(id);
            responseEntity = new ResponseEntity<String>("Successfully Deleted!!",HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT );
        }
        return responseEntity;
    }

}
