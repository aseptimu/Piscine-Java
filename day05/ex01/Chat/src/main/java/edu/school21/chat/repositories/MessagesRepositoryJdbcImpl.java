package edu.school21.chat.repositories;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		ResultSet result = statement.executeQuery(query);
		result.next();
		User user = new User(1, "aseptimu", "qwert", null, null);
		Chatroom chatroom =
		return ();
	}
}
