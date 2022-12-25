package com.sol1230.study_servlets.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/DispatcherServlets")
public class DispatcherServlets extends HttpServlet {

  protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
  )
    throws IOException, ServletException {
    String hiddenParam = request.getParameter("hiddenParam");

    // /DispatcherServlets?hiddenParam=searchFormServlet
    if ("searchFormServlet".equals(hiddenParam)) {
      response.sendRedirect("/searchFormServlet");
      // /DispatcherServlets?hiddenParam=CreateCookieServlets
    } else if ("CreateCookieServlets".equals(hiddenParam)) {
      request.setAttribute("firstName", "eunsol");
      RequestDispatcher requestDispatcher = request.getRequestDispatcher(
        "/cookies/createServlets"
      );
      requestDispatcher.forward(request, response);
    } else {
      // nomal display
      String message = "DispatcherServlets with message";
      PrintWriter printWriter = response.getWriter();

      printWriter.println("<html lang='en'>");
      printWriter.println("<head>");
      printWriter.println("<title>" + message + "</title>");
      printWriter.println("</head>");
      printWriter.println("<body>");
      printWriter.println(" <button>call Dispatcher Servlets</button>");
      printWriter.println(" </form>");
      printWriter.println("</body>");
      printWriter.println("</html>");

      printWriter.close();
    }
  }
}
