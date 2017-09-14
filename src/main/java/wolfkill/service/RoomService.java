package wolfkill.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import wolfkill.dao.RoomDao;
import wolfkill.domain.Room;
import wolfkill.domain.RoomUser;
import wolfkill.domain.User;
import wolfkill.dto.RoomDto;
import wolfkill.dto.UserDto;

@Service
public class RoomService {

	@Autowired
	private RoomDao roomDao;

	@Autowired
	private UserSercice userSercice;
	
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
	
	public RoomDto joinRoom(int id, String openid){
		Room room = this.roomDao.findOne(id);
		if(room == null || !room.getStatus()){
			return null;
		}
		UserDto userDto = userSercice.getUserDto(openid);
		int count = countPeople(room);
		List<RoomUser> roomUsers = room.getRoomUsers();
		if(roomUsers != null ){
			for (RoomUser roomUser : roomUsers) {
				if(roomUser.getUser().getId() == userDto.getId()){

				}
			}
		}
		return null;
	}

	public int countPeople(Room room){
		Assert.notNull(room, "room is null");
		String roomConfig = room.getRoomData();
		Assert.hasText(roomConfig,"roomData is null");
		ObjectMapper mapper = new ObjectMapper();
		try {
			Map<String, Object> config = mapper.readValue(roomConfig, Map.class);
			int count = 0;
			Integer wolf = (Integer) config.get("wolf");
			if(wolf != null){
				count +=wolf;
			}
			Integer city = (Integer) config.get("city");
			if(city != null){
				count += city;
			}
			List<Object> gods = (List<Object>) config.get("god");
			if (!CollectionUtils.isEmpty(gods)){
				count += gods.size();
			}
			return count;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
