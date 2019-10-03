package com.stackroute.repository;

import com.stackroute.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Query("select m from Movie m where m.movieTitle = ?1")
    public List<Movie> getMovieWithTitle(String movieTitle);

}
