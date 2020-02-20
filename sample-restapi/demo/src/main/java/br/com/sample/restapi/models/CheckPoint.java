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
	private final long id;
	@Column(name = "fk_user_id")
	private final long userId;
	@Column(name = "date")
	private final long date;
	@Column(name = "entrance")
	private final boolean entrance;
	public CheckPoint(long id, long userId, long date, boolean entrance) {
		this.id = id;
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
