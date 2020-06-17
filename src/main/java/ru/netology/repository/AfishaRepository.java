package ru.netology.repository;

import ru.netology.domain.Movie;

public class AfishaRepository {
    Movie[] movies = {new Movie(1, "Bladshot", "http://", "actionMovie"),
            new Movie(2, "Ahead", "http://", "cartoon"),
            new Movie(3, "HotelBelgrad", "http://", "comedy"),
            new Movie(4, "Gentlemen", "http://", "actionMovie"),
            new Movie(5, "InvisibleMan", "http://", "horrors"),
            new Movie(6, "Trolls", "http://", "cartoon"),
            new Movie(7, "NumberOne", "http://", "comedy"),
            new Movie(8, "NumberTwo", "http://", "actionMovie"),
            new Movie(9, "NumberThree", "http://", "actionMovie"),
            new Movie(10, "NumberFour", "http://", "actionMovie")
    };

    public Movie[] findAll() {
        return movies;
    }

    public void save(Movie movie) {
        Movie[] tmpArray = new Movie[movies.length + 1];
        System.arraycopy(movies, 0, tmpArray, 0, movies.length);
        int lastMovie = tmpArray.length - 1;
        tmpArray[lastMovie] = movie;
        movies = tmpArray;
    }

    public Movie findById(int id) {
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    void removeById(int id) {
        int length = movies.length - 1;
        Movie[] tmpArray = new Movie[length];
        int i = 0;
        for (Movie movie : movies) {
            if (movie.getId() != id) {
                tmpArray[i] = movie;
                i++;
            }
        }
        movies = tmpArray;
    }

    void removeAll() {
        movies = new Movie[0];
    }

}
