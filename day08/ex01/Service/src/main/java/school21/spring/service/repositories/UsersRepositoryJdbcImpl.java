package school21.spring.service.repositories;

import com.zaxxer.hikari.HikariDataSource;
import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {

    private DataSource ds;

    public UsersRepositoryJdbcImpl(HikariDataSource ds) {
        this.ds = ds;
    }

    @Override
    public User findById(Long id) {
        try (Connection connection = ds.getConnection()) {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM \"user\" WHERE identifier = " + id;
            ResultSet result = statement.executeQuery(query);
            if (!result.next()) {
                throw new RuntimeException("No such id");
            }
            User user = new User(result.getLong(1), result.getString(2));
            statement.close();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        try (Connection connection = ds.getConnection()) {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM \"user\"";
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                list.add(new User(result.getLong(1), result.getString(2)));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void save(User entity) {
        try (Connection connection = ds.getConnection()) {
            String insert = "INSERT INTO \"user\" (identifier, email) VALUES (" +
                    entity.getIdentifier() + ", \'" + entity.getEmail() + "\');";
            Statement statement = connection.createStatement();
            statement.executeUpdate(insert);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(User entity) {
        try (Connection connection = ds.getConnection()) {
            String sqlQuery = "UPDATE \"user\" SET email=\'" +
                    entity.getEmail() + "\' WHERE identifier=" + entity.getIdentifier() + ";";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlQuery);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try (Connection connection = ds.getConnection()) {
            String delete = "DELETE FROM \"user\" WHERE identifier = ?;";
            PreparedStatement statement = connection.prepareStatement(delete);
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try (Connection connection = ds.getConnection()) {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM \"user\" WHERE email = \'" + email + "\';";
            ResultSet result = statement.executeQuery(query);
            if (!result.next()) {
                throw new RuntimeException("Bad email");
            }
            User user = new User(result.getLong(1), result.getString(2));
            statement.close();
            return Optional.of(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
