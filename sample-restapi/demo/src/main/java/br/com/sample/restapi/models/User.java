package br.com.sample.restapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class User {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="name")
	private String name;
	@Column(name="document")
	private String document;
	@Column(name="email_address")
	private String emailAddress;
	@Column(name="register_date")
	private long registerDate;
	
	public User() {}
	
	public User(long id, String name, String document, String emailAddress, long registerDate) {
		this(name, document, emailAddress, registerDate);
		this.id = id;
	}
	
	public User(String name, String document, String emailAddress, long registerDate) {
		this.name = name;
		this.document = document;
		this.emailAddress = emailAddress;
		this.registerDate = registerDate;
	}
	
	public String getDocument() {
		return document;
	}
	
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public long getId() {
		return id;
	}
	
	
	public String getName() {
		return name;
	}
	
	public long getRegisterDate() {
		return registerDate;
	}
	
	public static User emptyUser() {
		return new User();
	}
	
	public static boolean isEmpty(User user) {
		return user.getName() == null || user.getName().isEmpty();
	}
}
