package wolfkill.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import wolfkill.domain.Room;
import wolfkill.service.RoomService;
import wolfkill.service.UserSercice;

@RestController
public class IndexController {

	@Autowired
	private RoomService roomService;
	
	@Autowired
	private UserSercice userSercice;
	
	@RequestMapping(value="/login/{code}",method=RequestMethod.POST)
	public Object login(@PathVariable("code")String code){
		String openid = userSercice.login(code);
		Map<String, Object> map = new HashMap<>();
		if(openid != null){
			map.put("openid", openid);
		}else {
			map.put("msg", "失败");
		}
		return map;
	}
	
	@RequestMapping(value="/createroom", method = RequestMethod.POST)
	public Object createRoom(@RequestBody Map<String, Object> data){
		Room room = this.roomService.createRoom(data);
		Map<String, Object> result = new HashMap<>();
		if(room != null && room.getId() > 0 ){
			result.put("id", room.getId());
		}else{
			result.put("msg", "创建失败");
		}
		return result;
	}
	
}
