package wolfkill.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_room_user")
public class RoomUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2449522334818956487L;

	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	private User user;
	
	@ManyToOne(cascade=CascadeType.REMOVE,fetch = FetchType.LAZY)
	private Room room;
	
	@Column
	private Integer role;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}
	
	
}
