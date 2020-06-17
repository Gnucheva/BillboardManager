package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;

class AfishaManagerTest {

    AfishaRepository repository = new AfishaRepository();

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

    @Test
    void mustShowTenMovie() {
        AfishaManager manager = new AfishaManager(repository, 10);
        Movie[] actual = manager.getLastAdd();
        assertArrayEquals(expected, actual);


    }

    @Test
    void mustShowValid() {
        AfishaManager manager = new AfishaManager(repository, 5);
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
        AfishaManager manager = new AfishaManager(repository, 0);
        Movie[] actual = manager.getLastAdd();
        assertArrayEquals(expected, actual);

    }

    @Test
    void mustShowOverMax() {
        AfishaManager manager = new AfishaManager(repository, 11);
        Movie[] actual = manager.getLastAdd();
        assertArrayEquals(expected, actual);

    }


}