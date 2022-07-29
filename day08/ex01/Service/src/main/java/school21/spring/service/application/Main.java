package school21.spring.service.application;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import school21.spring.service.models.User;
import school21.spring.service.repositories.UsersRepository;
import school21.spring.service.repositories.UsersRepositoryJdbcImpl;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {

        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");

        Connection connection = ds.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("DROP TABLE IF EXISTS \"user\";");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS \"user\"(identifier integer not null," +
                "email varchar(100) not null);");
        UsersRepositoryJdbcImpl usersRepository = new UsersRepositoryJdbcImpl(ds);
        User user = new User(1L, "testmail");
        User user2 = new User(2L, "test2@mail.ru");
        usersRepository.save(user);
        usersRepository.save(user2);
        user.setEmail("deletedmail@mail.ru");
        usersRepository.update(user);
        usersRepository.delete(1L);
        User user3 = new User(3L, "lolkekcheburek@gmail.com");
        usersRepository.save(user3);
        System.out.println(usersRepository.findById(3L));
        System.out.println(usersRepository.findByEmail("lolkekcheburek@gmail.com").get().getIdentifier());
        System.out.println(usersRepository.findAll());
        System.out.println();
        statement.close();
        connection.close();

        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        UsersRepository usersRepository1 = context.getBean("usersRepositoryJdbc", UsersRepository.class);
        System.out.println(usersRepository1.findAll () );
        usersRepository1 = context.getBean("usersRepositoryJdbcTemplate", UsersRepository.class);
        System.out.println(usersRepository1.findAll () );
    }
}
