package com.sol1230.study_servlets.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import com.sol1230.study_servlets.dao.PollWithDB;

@WebServlet(urlPatterns = "/polls/PollServlet_us")
public class DetailServlets extends HttpServlet {

  @Override
  protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
  )
    throws ServletException, IOException {
    // input type
    String questions_Uid = request.getParameter("QUESTIONS_UID");

    // biz with DB and Class
    PollWithDB PollWithDB = new PollWithDB();
    HashMap<String, Object> question = null;
    try {
      question = PollWithDB.getQuestion(questions_Uid);
      System.out.println(question.get("QUESTIONS_UID"));
      System.out.println(question.get("QUESTIONS"));
      System.out.println(question.get("ORDERS"));
    } catch (SQLException e) {
      e.printStackTrace();
    }
    // output with html
    request.setAttribute("question", question);

    RequestDispatcher requestDispatcher = request.getRequestDispatcher(
      "/polls/details.jsp"
    );
    requestDispatcher.forward(request, response);
  }
}

