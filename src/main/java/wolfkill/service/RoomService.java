package wolfkill.service;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import wolfkill.dao.RoomDao;
import wolfkill.domain.Room;
import wolfkill.dto.RoomDto;

@Service
public class RoomService {

	@Autowired
	private RoomDao roomDao;
	
	public Room createRoom(Map<String, Object> roomDate){
		Integer id = this.roomDao.getUnusedMinId();
		Room room = new Room();
		if(id != null && id >0){
			room.setId(id);
		}
		ObjectMapper mapper = new ObjectMapper();
		try {
			room.setRoomData(mapper.writeValueAsString(roomDate));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		room.setStatus(true);
		this.roomDao.saveAndFlush(room);
		return room;
	}
	
	public RoomDto getRoom(int id){
		Room room = this.roomDao.findOne(id);
		if(room == null || !room.getStatus()){
			return null;
		}
		RoomDto roomDto = new RoomDto();
		BeanUtils.copyProperties(room, roomDto);
		return roomDto;
	}
}
