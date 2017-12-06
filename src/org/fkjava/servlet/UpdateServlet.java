package org.fkjava.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fkjava.dao.BookDao;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * 1.接收从update.jsp传递过来的参数 id ,name,author,price
		 * 2.调用Dao层的update(),进行修改数据
		 * 3.跳转到主页
		 * Servlet implementation class UpdateServlet
		 */
		//编码
		request.setCharacterEncoding("utf-8");
		//接收id，name，author，price
		Integer id=Integer.valueOf(request.getParameter("id"));
		String name=request.getParameter("name");
		String author=request.getParameter("author");
		Double price=Double.valueOf(request.getParameter("price"));
		//
		BookDao dao=new BookDao();
		dao.update(name,author,price,id);
		//跳转客户端跳转
		response.sendRedirect("main");
	}

}
