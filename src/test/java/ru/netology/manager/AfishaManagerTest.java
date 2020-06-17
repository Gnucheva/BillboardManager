package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)

class AfishaManagerTest {
    @Mock
    private AfishaRepository repository ;
    @InjectMocks
    private MovieManager manager ;


    @BeforeEach
    void setUp() {
    }

    @Test
    void addMovie() {
    }

    @Test
    void getLastAdd() {
    }

    @Test
    void getAll() {
    }

    @Test
    void showAll() {
    }
}