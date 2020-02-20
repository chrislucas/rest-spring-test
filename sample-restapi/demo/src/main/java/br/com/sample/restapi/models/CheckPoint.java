package br.com.sample.restapi.models;

public class CheckPoint {

	private final long id;
	private final long userId;
	private final long date;
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
