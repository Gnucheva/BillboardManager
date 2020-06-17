package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    private AfishaRepository repository = new AfishaRepository();
    private Movie movieToAdd = new Movie(11, "NumberFive", "http://", "horrors");

    @BeforeEach
    void setUp() {
        repository.save(movieToAdd);
    }


    @Test
    void mustFindAll() {
        Movie[] actual = repository.findAll();
        Movie[] expected = {new Movie(1, "Bladshot", "http://", "actionMovie"),
                new Movie(2, "Ahead", "http://", "cartoon"),
                new Movie(3, "HotelBelgrad", "http://", "comedy"),
                new Movie(4, "Gentlemen", "http://", "actionMovie"),
                new Movie(5, "InvisibleMan", "http://", "horrors"),
                new Movie(6, "Trolls", "http://", "cartoon"),
                new Movie(7, "NumberOne", "http://", "comedy"),
                new Movie(8, "NumberTwo", "http://", "actionMovie"),
                new Movie(9, "NumberThree", "http://", "actionMovie"),
                new Movie(10, "NumberFour", "http://", "actionMovie"),
                new Movie(11, "NumberFive", "http://", "horrors")

        };
        assertArrayEquals(expected, actual);

    }

    @Test
    void mustSave() {
        Movie movieToAdd = new Movie(12, "NumberSix", "http://", "horrors");
        repository.save(movieToAdd);
        Movie[] actual = repository.findAll();
        Movie[] expected = {new Movie(1, "Bladshot", "http://", "actionMovie"),
                new Movie(2, "Ahead", "http://", "cartoon"),
                new Movie(3, "HotelBelgrad", "http://", "comedy"),
                new Movie(4, "Gentlemen", "http://", "actionMovie"),
                new Movie(5, "InvisibleMan", "http://", "horrors"),
                new Movie(6, "Trolls", "http://", "cartoon"),
                new Movie(7, "NumberOne", "http://", "comedy"),
                new Movie(8, "NumberTwo", "http://", "actionMovie"),
                new Movie(9, "NumberThree", "http://", "actionMovie"),
                new Movie(10, "NumberFour", "http://", "actionMovie"),
                new Movie(11, "NumberFive", "http://", "horrors"),
                new Movie(12, "NumberSix", "http://", "horrors")

        };

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldFindById() {
        Movie actual = repository.findById(5);
        Movie expected = new Movie(5, "InvisibleMan", "http://", "horrors");
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindInvalidId() {
        Movie actual = repository.findById(100);
        Movie expected = null;
        assertEquals(expected, actual);

    }

    @Test
    void shouldRemoveById() {
        repository.removeById(5);
        Movie[] actual = repository.findAll();
        Movie[] expected = {new Movie(1, "Bladshot", "http://", "actionMovie"),
                new Movie(2, "Ahead", "http://", "cartoon"),
                new Movie(3, "HotelBelgrad", "http://", "comedy"),
                new Movie(4, "Gentlemen", "http://", "actionMovie"),
                new Movie(6, "Trolls", "http://", "cartoon"),
                new Movie(7, "NumberOne", "http://", "comedy"),
                new Movie(8, "NumberTwo", "http://", "actionMovie"),
                new Movie(9, "NumberThree", "http://", "actionMovie"),
                new Movie(10, "NumberFour", "http://", "actionMovie"),
                new Movie(11, "NumberFive", "http://", "horrors")

        };
        assertArrayEquals(expected, actual);
    }

}