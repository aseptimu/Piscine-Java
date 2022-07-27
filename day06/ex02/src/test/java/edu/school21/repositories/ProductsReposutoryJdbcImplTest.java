package edu.school21.repositories;

import edu.school21.models.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class ProductsReposutoryJdbcImplTest {
    EmbeddedDatabase db;
    ProductsRepository products;

    final List<Product> EXPECTED_FIND_ALL_PRODUCTS = Arrays.asList(
                        new Product(0, "Milk", 100),
                        new Product(1, "Egg", 120),
                        new Product(2, "Cake", 150),
                        new Product(3, "Chocolate", 140),
                        new Product(4, "Bread", 40));
    final Product EXPECTED_FIND_BY_ID_PRODUCT = new Product(1, "Egg", 120);
    final Product EXPECTED_UPDATED_PRODUCT = new Product(3, "spoon", 10);
    final Product EXPECTED_SAVED_PRODUCT = new Product(5, "mars", 70);
    @BeforeEach
    void init() {
        db = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)
                .addScript("schema.sql")
                .addScript("data.sql")
                .build();
        products = new ProductsReposutoryJdbcImpl(db);
    }

    @Test
    void testFindAll() throws SQLException {
        Assertions.assertEquals(EXPECTED_FIND_ALL_PRODUCTS, products.findAll());
    }

    @Test
    void testFindById() throws SQLException {
        Assertions.assertEquals(EXPECTED_FIND_BY_ID_PRODUCT, products.findById(1L).get());
    }

    @Test
    void testUpdate() throws SQLException {
        products.update(EXPECTED_UPDATED_PRODUCT);
        Assertions.assertEquals(products.findById(3L).get(), EXPECTED_UPDATED_PRODUCT);
    }

    @Test
    void testSave() throws SQLException {
        products.save(EXPECTED_SAVED_PRODUCT);
        Assertions.assertEquals(products.findById(5L).get(), EXPECTED_SAVED_PRODUCT);
    }

    @Test
    void testDelete() throws SQLException {
        products.delete(1L);
        Assertions.assertThrows(RuntimeException.class, ()-> products.findById(1L));
    }

    @AfterEach
    void close() {
        db.shutdown();
    }
}
