package com.sol1230.study_servlets.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/helloWorldServlets")
public class HelloWorldServlets extends HttpServlet {

  protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
  )
    throws IOException {
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String hiddenParam = request.getParameter("hiddenParam");

    String message = "HelloWorldServlets! with message";
    PrintWriter printWriter = response.getWriter();

    printWriter.println("<html lang='en'>");
    printWriter.println("<head>");
    printWriter.println("<title>" + message + "</title>");
    printWriter.println("</head>");

    printWriter.println("<body>");
    printWriter.println("<div> firstName : " + firstName + "</div>");
    printWriter.println("<div> lastName : " + lastName + "</div>");
    printWriter.println("<form action='/helloWorldServlets' method='get'>");
    printWriter.println(
      "  <input type='text' name='firstName' id='' value='" + firstName + "' />"
    );
    printWriter.println(
      " <input type='text' name='lastName' id='' value='" + lastName + "' />"
    );
    printWriter.println(" <button>recall HelloWorldServlets</button>");
    printWriter.println(" </form>");
    printWriter.println("</body>");
    printWriter.println("</html>");

    printWriter.close();
  }
}
