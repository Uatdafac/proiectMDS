package message;

import graphicInterfacesServer.Connection;

import com.entities.User;

public class SignUpSuccesfullMessage implements Message {

	private static final long serialVersionUID = 1L;
	private User user = null;
	private Connection connection;
	

	public SignUpSuccesfullMessage() {
	}

	public void interactOnServer() {

	}

	public void interactOnClient() {

	}

	public User getUser() {
		return user;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Connection getConnection() {
		return connection;
	}

}
