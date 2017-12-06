package org.fkjava.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fkjava.bean.User;
import org.fkjava.dao.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
//右击HttpServlet点击show in project explorer可查看相关文件
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置编码	
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//1.接收页面参数
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		//2.通过userDao.login(name,password);
		UserDao dao = new UserDao();
		User user;
		try {
			user = dao.login(name,password);
			if(user==null){
				//获得转发器
				request.getRequestDispatcher("/index.jsp").forward(request, response);	
				
			}else{
				//response.getWriter().println("欢迎"+user.getName()+"光临");
					//将用户信息存储到session
				request.getSession().setAttribute("user", user);
				//跳转到主页 书籍的列表
				//request.getRequestDispatcher("main").forward(request, response);
				response.sendRedirect("frame.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
