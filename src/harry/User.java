package harry;

public class User {
	int id;
	
	
	String uname;
	String pwd;
	
	public User() {
		super();
	}
	public User(String uname, String pwd) {
		super();
		this.uname = uname;
		this.pwd = pwd;
	}
	public User(int id, String uname, String pwd) {
		super();
		this.id = id;
		this.uname = uname;
		this.pwd = pwd;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", uname=" + uname + ", pwd=" + pwd + "]";
	}
	
}
