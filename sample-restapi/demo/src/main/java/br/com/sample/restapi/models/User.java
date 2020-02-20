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
	private final long id;
	@Column(name="name")
	private final String name;
	@Column(name="document")
	private final String document;
	@Column(name="email_address")
	private final String emailAddress;
	@Column(name="register_date")
	private final long registerDate;
	
	public User(long id, String name, String document, String emailAddress, long registerDate) {
		this.id = id;
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
	
}
