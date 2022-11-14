package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookieValue
 */
@WebServlet("/setcookie")
public class SetCookieValue extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetCookieValue() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see Servlet#init(ServletConfig)
    */
   public void init(ServletConfig config) throws ServletException {
      // TODO Auto-generated method stub
   }

   /**
    * @see Servlet#destroy()
    */
   public void destroy() {
      // TODO Auto-generated method stub
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html; charset=utf-8");
      PrintWriter out = response.getWriter();
      
      Date d = new Date();
      
      Cookie c = new Cookie("cookieTest", URLEncoder.encode("JSP프로그래밍입니다.","utf-8"));
      c.setMaxAge(24*60*60);
      response.addCookie(c);
      out.println("현재시간 : "+d);
      out.println("현재시간을 Cookie로 저장합니다.");
   }

}