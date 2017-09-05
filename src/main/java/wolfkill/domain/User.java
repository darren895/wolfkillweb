package wolfkill.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "t_user", indexes = {@Index(columnList = "openId", unique = true, name = "user_open_index")})
public class User implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1716091512218255718L;

	@Id
    @GeneratedValue
    private int id;

    @Column(unique = true, nullable = false, length = 100)
    private String openId;

    @Column(columnDefinition = "timestamp default now()", nullable = false,insertable=false)
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
