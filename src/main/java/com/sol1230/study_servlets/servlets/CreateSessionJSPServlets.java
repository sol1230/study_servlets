package com.sol1230.study_servlets.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

// /session/createJSPServlets?username=eunsol&password=1234
@WebServlet(urlPatterns = "/session/createJSPServlets")
public class CreateSessionJSPServlets extends HttpServlet {

  @Override
  protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
  )
    throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");

    String username = request.getParameter("username");
    String password = request.getParameter("password");

    // display
    // login
    HttpSession httpSession = null;
    HttpSession httpSession_false = null;

    // NOT EXISTS JSEESOINID
    // httpSession_false = request.getSession(false);  // null
    // httpSession = request.getSession(); // 무조건 인스턴스화

    // EXISTS JSEESOINID
    // httpSession_false = request.getSession(false);  // 존재하면 인스턴스화
    // httpSession = request.getSession(); // 무조건 인스턴스화

    String path = null;
    if ("eunsol".equals(username) && "1234".equals(password)) {
      // login
      httpSession = request.getSession(false);
      if (httpSession == null) {
        httpSession = request.getSession();
        httpSession.setAttribute("username", username);
        httpSession.setAttribute("password", password);
      }
      System.out.println(httpSession.getAttribute("username"));
      System.out.println(httpSession.getId());

      path = "/session/checkLogin.jsp";
    } else {
      // logout
      httpSession = request.getSession(false);
      if (httpSession != null) {
        httpSession.invalidate();
      }
      System.out.println(httpSession.getAttribute("username")); //Attribute는 무조건 메모리에서 가져옴
      System.out.println(httpSession.getId());

      path = "/session/checkLogout.jsp";
    }
    RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
    requestDispatcher.forward(request, response);
  }
}
