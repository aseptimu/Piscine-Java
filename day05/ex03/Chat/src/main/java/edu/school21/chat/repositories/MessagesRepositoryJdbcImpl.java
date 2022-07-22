package edu.school21.chat.repositories;

import edu.school21.chat.exceptions.NotSavedSubEntityException;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessageRepository {
	private final DataSource ds;

	public MessagesRepositoryJdbcImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public Optional<Message> findById(Long id) throws SQLException {
		Connection connection = ds.getConnection();
		Statement statement1 = connection.createStatement();
		Statement statement2 = connection.createStatement();
		Statement statement3 = connection.createStatement();
		String query = "SELECT * FROM message WHERE id = " + id;
		ResultSet resultMessage = statement1.executeQuery(query);
		resultMessage.next();
		ResultSet resultUser = statement2.executeQuery("SELECT * FROM \"user\" WHERE id = " +
				resultMessage.getInt("author"));
		resultUser.next();
		ResultSet resultRoom = statement3.executeQuery("SELECT * FROM chatroom WHERE id = " +
				resultMessage.getInt("room"));
		resultRoom.next();

		User user = new User(resultUser.getLong("id"), resultUser.getString("login"),
				resultUser.getString("password"),
				null, null);
		Chatroom chatroom = new Chatroom(resultRoom.getLong("id"), resultRoom.getString("name"),
				null, null);
		Message message = new Message(resultMessage.getLong("id"), user,
				chatroom, resultMessage.getString("text"),
				resultMessage.getTimestamp("time").toLocalDateTime());
		connection.close();
		return (Optional.of(message));
	}

	@Override
	public boolean save(Message message) throws NotSavedSubEntityException {
		String insert = "INSERT INTO message (author, room, text, time) VALUES (" +
				message.getAuthor().getUserId() + ", " +
				message.getRoom().getId() + ", '" +
				message.getText() + "', '" +
				message.getMessageDateTime().toLocalDate() + "');";
		try {
			Connection conn = ds.getConnection();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(insert, Statement.RETURN_GENERATED_KEYS);
			ResultSet result = stmt.getGeneratedKeys();
			result.next();
			message.setId((long)result.getInt(1));
			conn.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new NotSavedSubEntityException("Database exception");
		}
		return true;
	}

	@Override
	public boolean update(Message message) throws SQLException {
		String sqlQuery = "UPDATE message SET author='" + message.getAuthor().getUserId() +
				"', room='" + message.getRoom().getId() +
				"', text='" + message.getText() +
				"', time=" + message.getMessageDateTime() +
				" WHERE id = " + message.getId() + ";";
		System.out.println(sqlQuery);
		try {
			Connection conn = ds.getConnection();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sqlQuery);

			conn.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new NotSavedSubEntityException("Database exception");
		}
		return true;
	}
}
