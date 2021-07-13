package ru.netology.repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.repository.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class RepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book first = new Book(1, "First book", 750, "First author");
    private Book second = new Book (2, "Second book", 600, "Second author");
    private Book third = new Book (3, "Third book", 1000, "Third author");
    private Book fourth = new Book (4, "Fourth book", 1700, "Fourth author");

    @Test
    public void shouldRemoveById() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);

        repository.removeById(1);

    }
    @Test
    public void shouldThrowException() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);

        assertThrows(NotFoundException.class,() -> repository.removeById(7));
    }
}

