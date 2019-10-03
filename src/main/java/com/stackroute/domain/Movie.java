package com.stackroute.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Movie {

    private @Id Integer movieId;
    private String imdbId;
    private int movieBudget;
    private String movieLanguage;
    private String movieTitle;
    private String moviePosterPath;
    private int movieRevenue;
    private int movieRunTime;
    private String movieReleaseDate;
    private String movieOverview;
    private String movieTagLine;

    public Movie() {
    }

    public Movie(int movieId, String imdbId, int movieBudget, String movieLanguage, String movieTitle, String moviePosterPath, int movieRevenue, int movieRunTime, String movieReleaseDate, String movieOverview, String movieTagLine) {
        this.movieId = movieId;
        this.imdbId = imdbId;
        this.movieBudget = movieBudget;
        this.movieLanguage = movieLanguage;
        this.movieTitle = movieTitle;
        this.moviePosterPath = moviePosterPath;
        this.movieRevenue = movieRevenue;
        this.movieRunTime = movieRunTime;
        this.movieReleaseDate = movieReleaseDate;
        this.movieOverview = movieOverview;
        this.movieTagLine = movieTagLine;
    }
}
