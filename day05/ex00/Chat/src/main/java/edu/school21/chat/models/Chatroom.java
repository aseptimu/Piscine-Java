package Chat.src.main.java.edu.school21.chat.models;

import java.util.ArrayList;

public class Chatroom {
	private Integer id;
	private String name;
	private String owner;
	private ArrayList<Message> messagesList;

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setMessagesList(ArrayList<Message> messagesList) {
		this.messagesList = messagesList;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public int hashCode() {
		int result = id;
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
		return "Chatroom id: " + id +
				" chatroom name: " + name +
				" chatroom owner: " + owner +
				" messages: " + messagesList;
	}

	public Chatroom(Integer id, String name, String owner, ArrayList<Message> messagesList) {
		this.id = id;
		this.name = name;
		this.owner = owner;
		this.messagesList = messagesList;
	}

	public String getName() {
		return name;
	}

	public String getOwner() {
		return owner;
	}

	public ArrayList<Message> getMessagesList() {
		return messagesList;
	}
}
