package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {
    private AfishaRepository repository;
    private int defaultMovieLength = 10;

    AfishaManager() {
    }

    public AfishaManager(AfishaRepository repository, int customMovieLength) {
        this.repository = repository;

        if (customMovieLength > 0 & customMovieLength < 10) {
            defaultMovieLength = customMovieLength;
        }
    }

    public void addMovie(Movie movie) {
        repository.save(movie);
    }

    public Movie[] getLastAdd() {
        Movie[] movies = repository.findAll();
        int moviesLength = movies.length;

        Movie[] customFilm = new Movie[defaultMovieLength];
        for (int i = 0; i < customFilm.length; i++) {
            int result = moviesLength - i - 1;
            customFilm[i] = movies[result];

        }
        return customFilm;
    }

    public Movie[] getAll() {
        Movie[] movies = repository.findAll();
        Movie[] result = new Movie[movies.length];
        for (int i = 0; i < result.length; i++) {
            int tmp = movies.length - i - 1;
            result[i] = movies[tmp];

        }
        return result;
    }

    public Movie[] showAll() {
        return repository.findAll();
    }


}
