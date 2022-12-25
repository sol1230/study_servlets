package com.sol1230.study_servlets.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/cookies/createServlets")
public class CreateCookieServlets extends HttpServlet {

  @Override
  protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
  )
    throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");

    //Cookie
    Cookie cookie_first = new Cookie("firstName", "Eunsol");
    Cookie cookie_second = new Cookie("secondName", "Lee");
    response.addCookie(cookie_first);
    response.addCookie(cookie_second);
    //Display
    PrintWriter printWriter = response.getWriter();
    printWriter.println("<div>Create Cookie Servlets<div>");

    printWriter.close();
  }
}
