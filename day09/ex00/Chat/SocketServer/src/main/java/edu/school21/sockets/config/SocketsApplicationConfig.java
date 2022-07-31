package edu.school21.sockets.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.Properties;

@Configuration
@ComponentScan("edu.school21.sockets")
public class SocketsApplicationConfig {

    @Bean
    public PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder(10, new SecureRandom());
    }
    @Bean
    public HikariDataSource getHikari() {
        HikariConfig hikariConfig = new HikariConfig();
         try (InputStream input = SocketsApplicationConfig.class.getClassLoader().getResourceAsStream("db.properties")) {
            Properties props = new Properties();
             if (input == null) {
                 System.err.println("Failed to load config");
                 return null;
             }
             props.load(input);
             hikariConfig.setJdbcUrl(props.getProperty("db.url"));
             hikariConfig.setUsername(props.getProperty("db.user"));
             hikariConfig.setPassword(props.getProperty("db.password"));
             hikariConfig.setDriverClassName(props.getProperty("db.driver.name"));
         } catch (IOException e) {
             e.printStackTrace();
         }

        HikariDataSource hikari = new HikariDataSource(hikariConfig);
        return hikari;
    }

}
