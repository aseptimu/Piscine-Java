package edu.school21.chat.app;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import java.time.LocalDateTime;

public class Program {
	public static void main(String[] args) {
		User user = new User(1L, "aseptimu", "qwerty", null, null);
		Chatroom room = new Chatroom(1L, "test", user, null);
		Message message = new Message(1L, user, room, "hello", LocalDateTime.now());
		System.out.println(message);

	}
}
