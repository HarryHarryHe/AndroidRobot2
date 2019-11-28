package harry;

public class Daka_list {
	int uid;
	String uname;
	String current_time;
	public Daka_list() {
		super();
	}
	public Daka_list(int uid, String uname, String current_time) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.current_time = current_time;
	}
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getCurrent_time() {
		return current_time;
	}
	public void setCurrent_time(String current_time) {
		this.current_time = current_time;
	}
	
}
