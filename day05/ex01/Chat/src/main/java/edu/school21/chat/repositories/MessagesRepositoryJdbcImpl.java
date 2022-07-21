package edu.school21.chat.repositories;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessageRepository {
	private final DataSource ds;

	public MessagesRepositoryJdbcImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public Optional<Message> findById(Long id) throws SQLException {
		Connection connection = ds.getConnection();
		Statement statement = connection.createStatement();
		String query = "SELECT * FROM message WHERE id = " + id;
		ResultSet resultMessage = statement.executeQuery(query);
		resultMessage.next();
		ResultSet resultUser = statement.executeQuery("SELECT * FROM \"user\" WHERE id = " +
				resultMessage.getInt("author"));
		ResultSet resultRoom = statement.executeQuery("SELECT * FROM message WHERE id = " +
				resultMessage.getInt("room"));

		User user = new User(resultUser.getLong("id"), resultUser.getString("login"),
				resultUser.getString("password"),
				null, null);
		Chatroom chatroom = new Chatroom(resultRoom.getLong("id"), resultRoom.getString("name"),
				null, null);
		Message message = new Message(resultMessage.getLong("id"), user,
				null, resultMessage.getString("text"),
				resultMessage.getTimestamp("time").toLocalDateTime());
		return (Optional.of(message));
	}
}
