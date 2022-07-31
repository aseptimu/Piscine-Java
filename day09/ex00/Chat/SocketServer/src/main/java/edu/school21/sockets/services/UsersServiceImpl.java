package edu.school21.sockets.services;

import edu.school21.sockets.models.User;
import edu.school21.sockets.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component("userService")
public class UsersServiceImpl implements UsersService {

    UsersRepository repository;
    PasswordEncoder passwordEncoder;

    @Autowired
    public UsersServiceImpl(@Qualifier("jdbcTemplate") UsersRepository repository, @Qualifier("getEncoder") PasswordEncoder password) {
        this.repository = repository;
        this.passwordEncoder = password;
    }

    @Override
    public String processData(String name, String password) {
        String pass = passwordEncoder.encode(password);
        repository.initRepo();
        repository.save(new User(null, name, pass));
        return pass;
    }
}
