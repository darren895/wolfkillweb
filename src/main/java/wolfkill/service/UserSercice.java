package wolfkill.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.core.types.Predicate;

import wolfkill.dao.UserDao;
import wolfkill.domain.QUser;
import wolfkill.domain.User;
import wolfkill.util.HttpUtil;

@Service
public class UserSercice {

	@Autowired
	private UserDao userDao;
	
	@Value("${weixin.app.appid}")
	private String appid;
	
	@Value("${weixin.app.secret}")
	private String secret;
	
	public String login(String code){
		String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+ appid +"&secret="
				+ secret +"&js_code=" + code +"&grant_type=authorization_code";
		String body = HttpUtil.get(url);
		ObjectMapper mapper = new ObjectMapper();
		try {
			Map<String, Object> result = mapper.readValue(body, Map.class);
			String openid = (String) result.get("openid");
			if(openid == null){
				return null;
			}
			QUser qUser = QUser.user;
			Predicate predicate = qUser.openId.eq(openid);
			User user = this.userDao.findOne(predicate);
			if(user == null){
				user = new User();
				user.setOpenId(openid);
				this.userDao.saveAndFlush(user);
			}
			return openid;
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
