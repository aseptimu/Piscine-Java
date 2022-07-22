package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessageRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");

		MessageRepository messagesRepository = new MessagesRepositoryJdbcImpl(dataSource);
		Optional<Message> messageOptional = null;
		try {
			messageOptional = messagesRepository.findById(11L);
			if (messageOptional.isPresent()) {
				Message message = messageOptional.get();
				message.setText("Bye");
				message.setMessageDateTime(null);
				messagesRepository.update(message);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
