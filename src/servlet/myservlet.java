package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.SessionTrackingMode;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.DBUtil;
import harry.User;

/**
 * Servlet implementation class myservlet
 */
@WebServlet("/myservlet")
public class myservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public myservlet() {
    }  

	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf8");
		resp.setContentType("text/html;charset=utf-8");
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		System.out.println("welcome");
		try {
			User u = DBUtil.login_chk(uname, pwd);
			System.out.println(u.toString());
			if(u!=null) {
				PrintWriter pw = resp.getWriter();
				pw.write("��½�ɹ�"+"\n");
				pw.write(u.getId()+"");  //��ȡ�û�id
				pw.flush();
				pw.close();
				System.out.println("��½�ɹ�");
				return;
			}else {
				PrintWriter pw = resp.getWriter();
				pw.write("��½ʧ��");
				pw.close();
				
				System.out.println("��½ʧ��,��˶��˺ź�����...");
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
