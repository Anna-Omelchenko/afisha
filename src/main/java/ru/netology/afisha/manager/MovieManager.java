package ru.netology.afisha.manager;

import ru.netology.afisha.data.Movie;

public class MovieManager {
    private Movie[] afisha;
    private int lastMoviesCount = 5;

    public MovieManager() {
    }

    public MovieManager(int lastMoviesCount) {
        this.lastMoviesCount = lastMoviesCount;
    }

    public void addMovie(Movie movie) {
        if (movie == null) {
            return;
        }
        if (afisha == null) {
            afisha = new Movie[]{movie};
        } else {
            Movie[] newAfisha = new Movie[afisha.length + 1];
            for (int i = 0; i < afisha.length; i++) {
                newAfisha[i] = afisha[i];
            }
            newAfisha[newAfisha.length - 1] = movie;
            afisha = newAfisha;
        }
    }

    public Movie[] findAll() {
        return afisha;
    }

    public Movie[] findLast() {
        if (afisha == null) {
            return null;
        }
        int lastCount = afisha.length > lastMoviesCount ? lastMoviesCount : afisha.length;
        Movie[] result = new Movie[lastCount];
        for (int j = 0; j < lastCount; j++) {
            result[j] = afisha[afisha.length - 1 - j];
        }
        return result;
    }
}
