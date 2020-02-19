package br.com.sample.restapi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class User {

	@Id 
	@GeneratedValue
	private long id;
	private String name;
	private String cpf;
	private String emailAddress;
	private long registerDate;
}
