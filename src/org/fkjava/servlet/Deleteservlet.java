package org.fkjava.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fkjava.dao.BookDao;

/**
 * Servlet implementation class Deleteservlet
 */
@WebServlet("/delete")
public class Deleteservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deleteservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//接收id
		Integer id= Integer.valueOf(request.getParameter("id"));
		//调用dao.delete(id)
		BookDao dao=new BookDao();
		dao.delete(id);
		//跳转到主页，客户端跳转
		response.sendRedirect("main");
	}

}
