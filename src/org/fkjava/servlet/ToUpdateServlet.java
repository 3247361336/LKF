package org.fkjava.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fkjava.bean.Book;
import org.fkjava.dao.BookDao;

/**
 * Servlet implementation class ToUpdateServlet
 */
@WebServlet("/ToUpdate")
public class ToUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.valueOf(request.getParameter("id"));
		BookDao dao=new BookDao();
		Book book = dao.getByid(id);
		request.setAttribute("book", book);
		request.getRequestDispatcher("/WEB-INF/jsp/update.jsp").forward(request, response);
	}

}
