package com.stackroute.LoadDatabase;

import com.stackroute.domain.Movie;
import com.stackroute.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("configuration.properties")
@ConfigurationProperties
public class ConfigurationPropertiesClass implements CommandLineRunner {
    private Integer movieId;
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
    private final MovieRepository movieRepository;

    public ConfigurationPropertiesClass(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public String toString() {
        return "ConfigurationPropertiesClass{" +
                "movieId=" + movieId +
                ", imdbId='" + imdbId + '\'' +
                ", movieBudget=" + movieBudget +
                ", movieLanguage='" + movieLanguage + '\'' +
                ", movieTitle='" + movieTitle + '\'' +
                ", moviePosterPath='" + moviePosterPath + '\'' +
                ", movieRevenue=" + movieRevenue +
                ", movieRunTime=" + movieRunTime +
                ", movieReleaseDate='" + movieReleaseDate + '\'' +
                ", movieOverview='" + movieOverview + '\'' +
                ", movieTagLine='" + movieTagLine + '\'' +
                '}';
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public int getMovieBudget() {
        return movieBudget;
    }

    public void setMovieBudget(int movieBudget) {
        this.movieBudget = movieBudget;
    }

    public String getMovieLanguage() {
        return movieLanguage;
    }

    public void setMovieLanguage(String movieLanguage) {
        this.movieLanguage = movieLanguage;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMoviePosterPath() {
        return moviePosterPath;
    }

    public void setMoviePosterPath(String moviePosterPath) {
        this.moviePosterPath = moviePosterPath;
    }

    public int getMovieRevenue() {
        return movieRevenue;
    }

    public void setMovieRevenue(int movieRevenue) {
        this.movieRevenue = movieRevenue;
    }

    public int getMovieRunTime() {
        return movieRunTime;
    }

    public void setMovieRunTime(int movieRunTime) {
        this.movieRunTime = movieRunTime;
    }

    public String getMovieReleaseDate() {
        return movieReleaseDate;
    }

    public void setMovieReleaseDate(String movieReleaseDate) {
        this.movieReleaseDate = movieReleaseDate;
    }

    public String getMovieOverview() {
        return movieOverview;
    }

    public void setMovieOverview(String movieOverview) {
        this.movieOverview = movieOverview;
    }

    public String getMovieTagLine() {
        return movieTagLine;
    }

    public void setMovieTagLine(String movieTagLine) {
        this.movieTagLine = movieTagLine;
    }

    @Override
    public void run(String... args) throws Exception {
        movieRepository.save(new Movie(movieId,imdbId,movieBudget,movieLanguage,movieTitle,moviePosterPath,movieRevenue,movieRunTime,movieReleaseDate,movieOverview,movieTagLine));
    }
}
