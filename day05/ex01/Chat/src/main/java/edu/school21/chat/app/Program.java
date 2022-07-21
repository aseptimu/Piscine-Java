package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessageRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		HikariDataSource dataSource = new HikariDataSource();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a message ID");
		dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");

		try {
			MessageRepository messages = new MessagesRepositoryJdbcImpl(dataSource);
			Optional<Message> out = messages.findById(scanner.nextLong());
			out.ifPresent(System.out::println);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
}
