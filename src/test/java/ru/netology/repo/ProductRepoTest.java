package ru.netology.repo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {
    Product product = new Product(5, "product", 100);
    Product product1 = new Product(10, "book", 1000);
    Product product2 = new Product(100, "Smartphone", 10000);

    @Test
    public void shouldRemovedByIdFalse() {
        ProductRepo repo = new ProductRepo();
        repo.save(product);
        repo.save(product1);
        repo.save(product2);
        Assertions.assertThrows(NotFoundException.class, () -> repo.removedById(15));
    }

    @Test
    void shouldRemovedByIdTrue() {
        ProductRepo repo = new ProductRepo();
        repo.save(product);
        repo.save(product1);
        repo.save(product2);
        Product[] expected = {product, product1};
        Product[] actual = repo.removedById(100);
        assertArrayEquals(expected, actual);
    }
}