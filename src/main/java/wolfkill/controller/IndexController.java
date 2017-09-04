package wolfkill.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wolfkill.service.RoomService;

@RestController
public class IndexController {

	@Autowired
	private RoomService roomService;
	
	@RequestMapping("/")
	public Map<String, Object> index(){
		Map<String, Object> map = new HashMap<>();
		map.put("message", this.roomService.test());
		return map;
	}
}
