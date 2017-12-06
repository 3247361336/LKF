package org.fkjava.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GameServle
 */
@WebServlet("/game")
public class GameServle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameServle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 超链接是GET请求
		 * 所以在index.html中点击game超链接时数据返回doget方法
		 */
		response.setContentType("text/html");//输出格式
		response.setCharacterEncoding("utf-8");//设置字符编码
		PrintWriter out = response.getWriter();//
		
		//1.画表单
		out.println("<font color='red'>请输入你要猜的数字</font>");
		out.println("<br/>");
		out.println("<form action='game' method='post'>");
		out.println("输入0-100的数字");
		out.println("<input type='text' name='number'/>");
		out.println("<input type='submit' value='提交'/>");
		out.println("</form>");
		
		//2.生成随机值存入Session
		HttpSession session = request.getSession();
		Integer result = (Integer)session.getAttribute("result");
		//判断
		if(result == null){
			//生成随机数
			Random random = new Random();//new随机器生成器对象
			result = random.nextInt(101);
			session.setAttribute("result", result);//存生成的随机数
			System.out.println("result :"+result);
		}
		//
		out.flush();
		out.close();//关注资源 
		
		
		
		//3.输出界面
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 表单请求为post
		 * 点击submit提交返回dopost方法
		 */
		response.setContentType("text/html");//输出格式
		response.setCharacterEncoding("utf-8");//设置字符编码
		PrintWriter out = response.getWriter();//
		
		//接收从页面提交的猜的数字
		Integer number = Integer.valueOf(request.getParameter("number"));
		//从session获取随机结果 
		HttpSession session = request.getSession();
		Integer result = (Integer)session.getAttribute("result");//
		
		//比对结果
		if(number < result){
			out.println("<h3><font color='red'>猜的数字过小,再来一次</font></h3>");
		}else if(number > result){
			out.println("<h3><font color='red'>猜的数字过大,再来一次</font></h3>");
		}else{
			out.println("<font color='red'>恭喜你猜对了,好汉再来！</font>");
			//随机数字要发生改变，以方便客户再猜
			//生成随机数
			Random random = new Random();//new随机器生成器对象
			result = random.nextInt(101);
			session.setAttribute("result", result);//存生成的随机数
			System.out.println("result :"+result);
		}
		
		//画表单
		
		out.println("<br/>");
		out.println("<font color='red'>请输入你要猜的数字</font>");
		out.println("<br/>");
		out.println("<form action='game' method='post'>");
		out.println("输入0-100的数字");
		out.println("<input type='text' name='number'/>");
		out.println("<input type='submit' value='提交'/>");
		out.println("</form>");
		
		//
		out.flush();
		out.close();
		
	}
	

}
