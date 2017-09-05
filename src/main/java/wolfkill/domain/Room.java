package wolfkill.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_room")
public class Room implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5088602782155083053L;

	@Id
	@GeneratedValue
	private int id;
	
	@Column(length=500)
	private String roomData;
	
	@Column(columnDefinition="timestamp default now() on update now()",updatable= false,insertable = false)
	private Date updtime;
	
	@Column(nullable=false)
	private Boolean status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoomData() {
		return roomData;
	}

	public void setRoomData(String roomData) {
		this.roomData = roomData;
	}

	public Date getUpdtime() {
		return updtime;
	}

	public void setUpdtime(Date updtime) {
		this.updtime = updtime;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}
