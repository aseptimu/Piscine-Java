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
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a message ID");
		dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");

		User creator = new User(7L, "user", "user", new ArrayList(), new ArrayList()); User author = creator;
		Chatroom room = new Chatroom(8L, "room", creator, new ArrayList());
		Message message = new Message(null, author, room, "Hello!", LocalDateTime.now());
		MessageRepository messagesRepository = new MessagesRepositoryJdbcImpl(dataSource);
		messagesRepository.save(message);
		System.out.println(message.getId()); // ex. id == 11
	}
}
