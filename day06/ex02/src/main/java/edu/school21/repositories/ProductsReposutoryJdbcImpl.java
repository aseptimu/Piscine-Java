package edu.school21.repositories;

import edu.school21.models.Product;
import org.omg.CORBA.CODESET_INCOMPATIBLE;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductsReposutoryJdbcImpl implements ProductsRepository {
    private final DataSource ds;

    public ProductsReposutoryJdbcImpl(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public List<Product> findAll() throws SQLException {
        List<Product> list = new ArrayList<>();
        Connection connection = ds.getConnection();
        Statement statement = connection.createStatement();
        String query = "SELECT  * FROM product;";
        ResultSet result = statement.executeQuery(query);

        while (result.next()) {
            list.add(new Product(result.getInt(1),
                    result.getString(2), result.getInt(3)));
        }
        statement.close();
        connection.close();
        return list;
    }

    @Override
    public Optional<Product> findById(Long id) throws SQLException {
        Connection connection = ds.getConnection();
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM product WHERE identifier = " + id + ";";
        ResultSet result = statement.executeQuery(query);
        if (!result.next()) {
            throw new RuntimeException("No such id");
        }
        Product product = new Product(result.getInt(1),
                result.getString(2), result.getInt(3));
        statement.close();
        connection.close();

        return Optional.of(product);
    }

    @Override
    public void update(Product product) throws SQLException {
        Connection connection = ds.getConnection();
        String state = "UPDATE product SET name = ?, price = ? WHERE identifier = ?;";
        PreparedStatement statement = connection.prepareStatement(state);
        statement.setString(1, product.getName());
        statement.setInt(2, product.getPrice());
        statement.setInt(3, product.getIdentifier());
        statement.execute();
        statement.close();
        connection.close();
    }

    @Override
    public void save(Product product) throws SQLException {
        Connection connection = ds.getConnection();
        String insert = "INSERT INTO product VALUES (?, ?, ?);";
        PreparedStatement statement = connection.prepareStatement(insert);
        statement.setLong(1, product.getIdentifier());
        statement.setString(2, product.getName());
        statement.setInt(3, product.getPrice());
        statement.execute();

        statement.close();
        connection.close();
    }

    @Override
    public void delete(Long id) throws SQLException {
        Connection connection = ds.getConnection();
        String delete = "DELETE FROM product WHERE identifier = ?;";
        PreparedStatement statement = connection.prepareStatement(delete);
        statement.setLong(1, id);
        statement.execute();
        statement.close();
        connection.close();
    }
}
