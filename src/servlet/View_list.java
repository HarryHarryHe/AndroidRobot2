package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Dao.DBUtil;
import harry.Daka_list;
import harry.Ez_dklist;


@WebServlet("/View_list")
public class View_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public View_list() {
        super();
        
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf8");
		resp.setContentType("text/json;charset=utf8");
		
		String uname = req.getParameter("uname");
		
		List<Ez_dklist> dkl = DBUtil.showList(uname);
		
		Gson gson = new Gson();
		String list = gson.toJson(dkl);
		
		PrintWriter pw = resp.getWriter();
		pw.write(list);
		pw.flush();
		pw.close();
	}


}
