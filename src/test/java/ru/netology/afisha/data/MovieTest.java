package ru.netology.afisha.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieTest {

    @Test
    public void testMovieTitle() {
        String title1 = "Snatch";
        Movie film = new Movie(title1);
        Assertions.assertEquals(title1, film.getTitle());
        // Test setter
        String title2 = "Barbie";
        film.setTitle(title2);
        Assertions.assertEquals(title2, film.getTitle());
        film.setTitle(null);
        Assertions.assertEquals(title2, film.getTitle());
    }
}
