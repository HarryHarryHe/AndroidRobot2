package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.DBUtil;

/**
 * Servlet implementation class action
 */
@WebServlet("/action")
public class Daka_action extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Daka_action() {
        super();
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf8");
		resp.setContentType("text/html;charset=utf8");
		String id = req.getParameter("uid");
		int uid = Integer.parseInt(id);  //���ַ���idתΪ����id
		String uname = req.getParameter("uname");
		try {
			boolean daka = DBUtil.daka(uid,uname);
			if(daka) {
				PrintWriter pw = resp.getWriter();
				pw.write("�򿨳ɹ�");
				pw.flush();
				pw.close();
				System.out.println("�򿨳ɹ�");
				return;
			}else {
				PrintWriter pw = resp.getWriter();
				pw.write("��ʧ��");
				pw.flush();
				pw.close();
				return;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("����˴�");
	}

}
