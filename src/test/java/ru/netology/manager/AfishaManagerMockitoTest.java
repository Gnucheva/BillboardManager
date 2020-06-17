package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class AfishaManagerMockitoTest {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
    AfishaManager manager = new AfishaManager();

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
    void setUp() {
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
    void addMovie() {
        Movie[] returned = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(tenth);
        manager.addMovie(tenth);
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        Movie[] actual = manager.getAll();
        assertArrayEquals(expected, actual);


    }


    @Test
    void showAll() {
        Movie[] returned = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(repository).findAll();
        Movie[] expected = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        Movie[] actual = manager.showAll();
        assertArrayEquals(expected, actual);


    }
}