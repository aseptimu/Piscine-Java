package edu.school21.chat.models;

import java.time.LocalDateTime;

public class Message {
	private Long id;
	private User author;
	private Chatroom room;
	private String text;
	private LocalDateTime messageDateTime;

	public Message(Long id, User author, Chatroom room, String text, LocalDateTime messageDateTime) {
		this.id = id;
		this.author = author;
		this.room = room;
		this.text = text;
		this.messageDateTime = messageDateTime;
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + id.hashCode();
		result = 31 * result + author.hashCode();
		result = 31 * result + room.hashCode();
		result = 31 * result + text.hashCode();
		result = 31 * result + messageDateTime.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Message)) {
			return false;
		}
		Message msg = (Message)obj;
		return id.equals(msg.id);
	}

	@Override
	public String toString() {
		return ("Message : {\nid=" + id +
				",\nauthor=" + author +
				",\nroom=" + room +
				",\ntext=" + text +
				",\ndate=" + messageDateTime);
	}

	public Long getId() {
		return id;
	}

	public User getAuthor() {
		return author;
	}

	public Chatroom getRoom() {
		return room;
	}

	public String getText() {
		return text;
	}

	public LocalDateTime getMessageDateTime() {
		return messageDateTime;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public void setRoom(Chatroom room) {
		this.room = room;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setMessageDateTime(LocalDateTime messageDateTime) {
		this.messageDateTime = messageDateTime;
	}
}
