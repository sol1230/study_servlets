package com.sol1230.study_servlets.servlets;

import com.sol1230.study_servlets.dao.SimpleWithDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/SimpleWithDBServlets")
public class SimpleWithDBServlets extends HttpServlet {

  @Override
  protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
  )
    throws ServletException, IOException {
    // biss with DB
    SimpleWithDB simpleWithDB = new SimpleWithDB();
    simpleWithDB.getList();

    //Display
    PrintWriter printWriter = response.getWriter();
    printWriter.println("<div>SimpleWithDBServlets</div>");

    printWriter.close();
  }
}
