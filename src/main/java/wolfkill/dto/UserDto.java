package wolfkill.dto;

import java.io.Serializable;
import java.util.Date;

public class UserDto implements Serializable{

    private static final long serialVersionUID = -1905619626194635970L;
    private int id;

    private String openId;

    private Date updtime;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Date getUpdtime() {
        return updtime;
    }

    public void setUpdtime(Date updtime) {
        this.updtime = updtime;
    }
}
