package Chat.src.main.java.edu.school21.chat;

import java.util.ArrayList;

public class User {
	private Integer userId;
	private String login;
	private String password;
	private ArrayList<Chatroom> roomsList;
	private ArrayList<Chatroom> insideRooms;

	@Override //TODO: check all overrides
	public int hashCode() {
		int result = userId;
		result = 31 * result + userId.hashCode();
		result = 31 * result + login.hashCode();
		result = 31 * result + password.hashCode();
		result = 31 * result + roomsList.hashCode();
		result = 31 * result + insideRooms.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof User user)) {
			return false;
		}
		return userId.equals(user.getUserId());
	}

	@Override
	public String toString() {
		return ("User: id = " + userId +
				" login: " + login +
				" password: " + password +
				" List of created rooms: " + roomsList +
				" User invited to rooms: " + insideRooms);
	}

	public User(Integer userId, String login, String password, ArrayList<Chatroom> roomsList, ArrayList<Chatroom> insideRooms) {
		this.userId = userId;
		this.login = login;
		this.password = password;
		this.roomsList = roomsList;
		this.insideRooms = insideRooms;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRoomsList(ArrayList<Chatroom> roomsList) {
		this.roomsList = roomsList;
	}

	public void setInsideRooms(ArrayList<Chatroom> insideRooms) {
		this.insideRooms = insideRooms;
	}

	public Integer getUserId() {
		return userId;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public ArrayList<Chatroom> getRoomsList() {
		return roomsList;
	}

	public ArrayList<Chatroom> getInsideRooms() {
		return insideRooms;
	}
}
