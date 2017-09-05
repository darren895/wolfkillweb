package wolfkill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import wolfkill.dto.RoomDto;
import wolfkill.service.RoomService;

@RestController
public class RoomController {

	@Autowired
	private RoomService roomService;
	
	@RequestMapping(value="/room/{id}",method=RequestMethod.GET)
	public RoomDto getRoom(@PathVariable("id")int id){
		RoomDto roomDto = this.roomService.getRoom(id);
		return roomDto;
	}
}
