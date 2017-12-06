package org.fkjava.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fkjava.bean.Book;
import org.fkjava.dao.BookDao;



/**
 * Servlet implementation class MainServlet
 * @param <Book>
 */
@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//User user= (User) request.getSession().getAttribute("user");
		
		//2.调用BookDao.getAll()查询所有书籍
		BookDao dao= new BookDao();
		List<Book> list =  dao.getAll();
		request.setAttribute("list", list);
		//3跳转到list.jsp
		request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
		
		//BookDao dao = new BookDao();
		//List<Book> list = dao.getAll();
		//request.setAttribute("list", list);
		//3跳转到list.jsp
		//request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
		
	}

}
