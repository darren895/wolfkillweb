package wolfkill.dto;

import java.io.Serializable;
import java.util.Date;

public class RoomDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6605376708521301661L;

	private int id;
	
	private String roomData;
	
	private Date updtime;
	
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
