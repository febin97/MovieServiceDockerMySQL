package com.stackroute.controller;

import com.stackroute.domain.Movie;
import com.stackroute.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    private final MovieService movieService;
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @GetMapping("/movies")
    public List<Movie> GetAllMovies(){
        return movieService.GetAllMovies();
    }
    @PostMapping("/movies")
    public Movie addNewMovie(@RequestBody Movie newMovie){
        return movieService.AddNewMovie(newMovie);
    }
    @GetMapping("/movies/{id}")
    public Movie getParticularMovie(@PathVariable int id){
        return movieService.GetParticularMovie(id);
    }
    @GetMapping("/movies/movieName={movieTitle}")
    public List<Movie> getMoviesByTitle(@PathVariable String movieTitle){
        return movieService.GetMovieByTitle(movieTitle);
    }
    @PutMapping("/movies/{id}")
    public Movie updateMovie(@RequestBody Movie newMovie, @PathVariable int id){
        return movieService.UpdateMovie(newMovie,id);
    }
    @DeleteMapping("/movies/{id}")
    public void deleteMovie(@PathVariable int id){
        movieService.DeleteMovie(id);
    }

    @GetMapping("/")
    public String Hello(Model model){
        model.addAttribute("name","Hello World");
        return "index";
    }

}
