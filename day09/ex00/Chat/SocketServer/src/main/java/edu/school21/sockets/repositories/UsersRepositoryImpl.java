package edu.school21.sockets.repositories;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.sockets.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component("jdbcTemplate")
public class UsersRepositoryImpl implements UsersRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UsersRepositoryImpl(HikariDataSource ds) {
        jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public User findById(Long id) {
        return jdbcTemplate.query("SELECT * FROM users WHERE id = ?", new Object[]{id},
                new BeanPropertyRowMapper<>(User.class)).stream().findAny().orElse(null);
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM users", new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public void save(User entity) {
        jdbcTemplate.update("INSERT INTO users (name, password) VALUES(?, ?)", entity.getName(),
                entity.getPassword());
    }

    @Override
    public void update(User entity) {
        jdbcTemplate.update("UPDATE users SET name = ?, password = ? WHERE id=?", entity.getName(),
                entity.getPassword());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM users WHERE id=?", id);
    }

    @Override
    public Optional<User> findByName(String name) {
        return jdbcTemplate.query("SELECT * FROM users WHERE name = ?", new Object[]{name},
                new BeanPropertyRowMapper<>(User.class)).stream().findAny();
    }

    @Override
    public void initRepo() {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS users (identifier serial primary key," + "name text not null," +
                "password varchar(100) not null);");
    }
}
