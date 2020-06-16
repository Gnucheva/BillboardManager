package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {

    MovieManager manager = new MovieManager();

    private Movie first = new Movie(1, "Bladshot", "http://", "actionMovie");
    private Movie second = new Movie(2, "Ahead", "http://", "cartoon");
    private Movie third = new Movie(3, "HotelBelgrad", "http://", "comedy");
    private Movie fourth = new Movie(4, "Gentlemen", "http://", "actionMovie");
    private Movie fifth = new Movie(5, "InvisibleMan", "http://", "horrors");
    private Movie sixth = new Movie(6, "Trolls", "http://", "cartoon");
    private Movie seventh = new Movie(7, "NumberOne", "http://", "comedy");
    private Movie eighth = new Movie(8, "NumberTwo", "http://", "actionMovie");
    private Movie ninth = new Movie(9, "NumberThree", "http://", "actionMovie");
    private Movie tenth = new Movie(10, "NumberFour", "http://", "actionMovie");

    Movie[] expected = {new Movie(10, "NumberFour", "http://", "actionMovie"),
            new Movie(9, "NumberThree", "http://", "actionMovie"),
            new Movie(8, "NumberTwo", "http://", "actionMovie"),
            new Movie(7, "NumberOne", "http://", "comedy"),
            new Movie(6, "Trolls", "http://", "cartoon"),
            new Movie(5, "InvisibleMan", "http://", "horrors"),
            new Movie(4, "Gentlemen", "http://", "actionMovie"),
            new Movie(3, "HotelBelgrad", "http://", "comedy"),
            new Movie(2, "Ahead", "http://", "cartoon"),
            new Movie(1, "Bladshot", "http://", "actionMovie")

    };

    @BeforeEach
    public void setUp() {
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);
        manager.addMovie(tenth);

    }

    @Test
    void mustShowTenMovie() {
        MovieManager manager = new MovieManager(10);
        manager.movies = this.manager.movies;
        Movie[] actual = manager.getLastAdd();
        assertArrayEquals(expected, actual);


    }

    @Test
    void mustShowValid() {
        MovieManager manager = new MovieManager(5);
        manager.movies = this.manager.movies;
        Movie movieToAdd = new Movie(11, "NumberFive", "http://", "horrors");
        manager.addMovie(movieToAdd);
        Movie[] actual = manager.getLastAdd();
        Movie[] expected = {new Movie(11, "NumberFive", "http://", "horrors"),
                new Movie(10, "NumberFour", "http://", "actionMovie"),
                new Movie(9, "NumberThree", "http://", "actionMovie"),
                new Movie(8, "NumberTwo", "http://", "actionMovie"),
                new Movie(7, "NumberOne", "http://", "comedy")

        };
        assertArrayEquals(expected, actual);

    }

    @Test
    void mustShowZero() {
        MovieManager manager = new MovieManager(0);
        manager.movies = this.manager.movies;
        Movie[] actual = manager.getLastAdd();
        assertArrayEquals(expected, actual);
    }

    @Test
    void mustShowOverMax() {
        MovieManager manager = new MovieManager(11);
        manager.movies = this.manager.movies;
        Movie[] actual = manager.getLastAdd();
        assertArrayEquals(expected, actual);

    }


}