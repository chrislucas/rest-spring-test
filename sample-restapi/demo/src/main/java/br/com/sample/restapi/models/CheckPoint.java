package br.com.sample.restapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CheckPoint {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "fk_user_id")
	private long userId;
	@Column(name = "date")
	private long date;
	@Column(name = "entrance")
	private boolean entrance;
	
	public CheckPoint() {}
	
	public CheckPoint(long id, long userId, long date, boolean entrance) {
		this(userId, date, entrance);
		this.id = id;
	}
	
	public CheckPoint(long userId, long date, boolean entrance) {
		this.userId = userId;
		this.date = date;
		this.entrance = entrance;
	}

	public long getId() {
		return id;
	}
	public long getUserId() {
		return userId;
	}
	public long getDate() {
		return date;
	}
	public boolean isEntrance() {
		return entrance;
	}
}
