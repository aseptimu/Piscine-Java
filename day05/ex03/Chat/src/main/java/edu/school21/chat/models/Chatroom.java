package edu.school21.chat.models;

import java.util.ArrayList;

public class Chatroom {
	private Long id;
	private String name;
	private User owner;
	private ArrayList<Message> messagesList;

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public void setMessagesList(ArrayList<Message> messagesList) {
		this.messagesList = messagesList;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + id.hashCode();
		result = 31 * result + name.hashCode();
		result = 31 * result + owner.hashCode();
		result = 31 * result + messagesList.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Chatroom)) {
			return false;
		}
		Chatroom chat = (Chatroom)obj;
		return id.equals(chat.id);
	}

	@Override
	public String toString() {
		return "{id=" + id +
				",name=\"" + name +
				"\",creator=" + owner +
				",messages=" + messagesList + "}";
	}

	public Chatroom(Long id, String name, User owner, ArrayList<Message> messagesList) {
		this.id = id;
		this.name = name;
		this.owner = owner;
		this.messagesList = messagesList;
	}

	public String getName() {
		return name;
	}

	public User getOwner() {
		return owner;
	}

	public ArrayList<Message> getMessagesList() {
		return messagesList;
	}
}
