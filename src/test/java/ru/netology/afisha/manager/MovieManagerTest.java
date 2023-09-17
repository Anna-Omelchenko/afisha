package ru.netology.afisha.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.afisha.data.Movie;

public class MovieManagerTest {

    @Test
    public void testEmptyAfisha() {
        MovieManager man = new MovieManager();
        Assertions.assertNull(man.findAll());
        Assertions.assertNull(man.findLast());
    }

    @Test
    public void testAddNullMovie() {
        MovieManager man = new MovieManager();
        man.addMovie(null);
        Assertions.assertNull(man.findAll());
    }

    @Test
    public void testFindAllMovies() {
        MovieManager afisha = new MovieManager();
        // Add first
        Movie hobbit = new Movie("Hobbit");
        afisha.addMovie(hobbit);
        Movie[] allMovies = afisha.findAll();
        Assertions.assertNotNull(allMovies);
        Assertions.assertEquals(1, allMovies.length);
        Assertions.assertEquals(hobbit, allMovies[0]);
        // Add second
        Movie harryPotter = new Movie("Harry Potter");
        afisha.addMovie(harryPotter);
        allMovies = afisha.findAll();
        Assertions.assertNotNull(allMovies);
        Movie[] expectedAll = {hobbit, harryPotter};
        Assertions.assertArrayEquals(expectedAll, allMovies);
    }

    @Test
    public void testDefaultFindLast() {
        MovieManager afisha = new MovieManager();
        Movie mv1 = new Movie("Movie 1");
        Movie mv2 = new Movie("Movie 2");
        Movie mv3 = new Movie("Movie 3");
        Movie mv4 = new Movie("Movie 4");
        Movie mv5 = new Movie("Movie 5");
        Movie mv6 = new Movie("Movie 6");
        // Test less than lastMoviesCount
        afisha.addMovie(mv1);
        afisha.addMovie(mv2);
        afisha.addMovie(mv3);
        Movie[] expected = {mv3, mv2, mv1};
        Assertions.assertArrayEquals(expected, afisha.findLast());
        // Test more than lastMoviesCount
        afisha.addMovie(mv4);
        afisha.addMovie(mv5);
        afisha.addMovie(mv6);
        Movie[] expected2 = {mv6, mv5, mv4, mv3, mv2};
        Assertions.assertArrayEquals(expected2, afisha.findLast());
    }

    @Test
    public void testCustomFindLast() {
        int lastCount = 3;
        MovieManager afisha = new MovieManager(lastCount);
        Movie mv1 = new Movie("Movie 1");
        Movie mv2 = new Movie("Movie 2");
        Movie mv3 = new Movie("Movie 3");
        Movie mv4 = new Movie("Movie 4");
        Movie mv5 = new Movie("Movie 5");
        // Test less than lastMoviesCount
        afisha.addMovie(mv1);
        Movie[] expected = {mv1};
        Assertions.assertArrayEquals(expected, afisha.findLast());
        // Test more than lastMoviesCount
        afisha.addMovie(mv2);
        afisha.addMovie(mv3);
        afisha.addMovie(mv4);
        afisha.addMovie(mv5);
        Movie[] expected2 = {mv5, mv4, mv3};
        Assertions.assertArrayEquals(expected2, afisha.findLast());
    }
}
