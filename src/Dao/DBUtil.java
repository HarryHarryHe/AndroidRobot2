package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import harry.Daka_list;
import harry.Ez_dklist;
import harry.User;
import mysql.Get_conn;

public class DBUtil {
	

	public static User login_chk(String uname, String pwd) throws SQLException {
		Connection conn = Get_conn.get_conn();

		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from info where uname=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, uname);
		
		try {
			rs = ps.executeQuery();
			while (rs.next()) {
				String password = rs.getString("pwd");
				if (password.equals(pwd)) {
					int uid = rs.getInt("id");
					User u = new User();
					u.setId(uid);
					u.setUname(uname);
					u.setPwd(password);
					return u;
				}
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			} else if (ps != null) {
				ps.close();
			} else if (rs != null) {
				rs.close();
			}
		}

		return null;

	}
	
	public static boolean daka(int uid,String uname) throws SQLException {
		Connection conn = Get_conn.get_conn();

		PreparedStatement ps = null;
		Date currentTime = new Date();   //截取当前系统时间
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   //改变输出格式（自己想要的格式）
		String daka_time = formatter.format(currentTime);    //得到字符串时间
		
		String dbdaka_time = "";  //最新一次存入数据库时间
		
		String sql1 = "select * from daka_list where uid=? order by lid desc limit 1";
		ps = conn.prepareStatement(sql1);
		ps.setInt(1, uid);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			dbdaka_time = rs.getString("daka_time");
		}
		String a = daka_time.substring(0,10).trim();
		String b="";
		//若为新用户，substring会抛异常
		try {
			if(dbdaka_time.substring(0,10).trim().equals("")) {
				b = "newUser";
			}else {
				b = dbdaka_time.substring(0,10).trim();
			}
		} catch (Exception e) {
			b = "newUser";
		}
		
		
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(a.equals(b));
		
		if(!a.equals(b)) {
			String sql2 = "insert into daka_list(uid,uname,daka_time) values(?,?,?)";
			try {
				ps = conn.prepareStatement(sql2);
				ps.setInt(1, uid);
				ps.setString(2, uname);
				ps.setString(3, daka_time);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (conn != null) {
					conn.close();
				} else if (ps != null) {
					ps.close();
				}
			}
			return true;
		}
		
		return false;
	}
	public static List<Ez_dklist> showList(String uname){
		Connection conn = Get_conn.get_conn();
		
		List<Ez_dklist> dkl = new ArrayList<Ez_dklist>();  //列表

		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from daka_list where uname=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			rs = ps.executeQuery();
			while (rs.next()) {
				Ez_dklist ed = new Ez_dklist();
				String daka_time = rs.getString("daka_time");
				ed.setName(uname);
				ed.setTime(daka_time);
				
				dkl.add(ed);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return dkl!=null ? dkl:null;
		
	}
}
