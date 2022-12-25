package com.sol1230.study_servlets.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/DispatcherJSPServlets")
public class DispatcherJSPServlets extends HttpServlet {

  protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
  )
    throws IOException, ServletException {
    String hiddenParam = request.getParameter("hiddenParam");

    // /DispatcherServlets?hiddenParam=searchFormServlet
    request.setAttribute("firstName", "eunsol");
    RequestDispatcher requestDispatcher = request.getRequestDispatcher(
      "/search_form.jsp"
    );
    requestDispatcher.forward(request, response);
  }
}
