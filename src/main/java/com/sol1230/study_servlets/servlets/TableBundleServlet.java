package com.sol1230.study_servlets.servlets;

import com.sol1230.study_servlets.DatasInfor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(urlPatterns = "/tableBundleServlet")
public class TableBundleServlet extends HttpServlet {

  @Override
  protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
  )
    throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    DatasInfor datasInfo = new DatasInfor();
    HashMap<String, Object> bundlesData = datasInfo.getBundlesData();
    HashMap<String, String> searchForm = (HashMap<String, String>) bundlesData.get(
      "searchForm"
    );
    ArrayList<String> tablesListwithString = (ArrayList<String>) bundlesData.get(
      "tablesListwithString"
    );

    PrintWriter printWriter = response.getWriter();
    printWriter.println("<html lang='en'>");
    printWriter.println("<head>");
    printWriter.println("<title>" + searchForm.get("search_key") + "</title>");
    printWriter.println(
      "<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css' rel='stylesheet'"
    );
    printWriter.println(
      "integrity='sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65' crossorigin='anonymous'>"
    );
    printWriter.println("<link rel='stylesheet' href='./css/common.css'>");
    printWriter.println("</head>");
    printWriter.println("<body>");
    printWriter.println("<div class='container'>");
    printWriter.println(
      "<div class='fs-3'>Tables Normal with Bundle datas</div>"
    );
    printWriter.println("<table class='table'>");
    printWriter.println(" <thead>");
    printWriter.println(" <tr>");
    printWriter.println("  <th scope=>#</th>");
    // printWriter.println(" <th scope=>First</th>");
    // printWriter.println("<th scope=>Last</th>");
    printWriter.println("<th scope=>Handle</th>");
    printWriter.println(" </tr>");
    printWriter.println(" </thead>");
    printWriter.println(" <tbody>");
    for (int i = 0; i < tablesListwithString.size(); i++) {
      printWriter.println(" <tr>");
      printWriter.println("  <th scope=>" + (i + 1) + "</th>");
      String handle = tablesListwithString.get(i);
      printWriter.println("   <td>" + handle + "</td>");
      printWriter.println(" </tr>");
    }

    printWriter.println("</tbody>");
    printWriter.println(" </table>");
    printWriter.println(" </div>");

    printWriter.println(
      " <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js'"
    );
    printWriter.println(
      "integrity='sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4'"
    );
    printWriter.println("crossorigin='anonymous'></script>");

    printWriter.println("</body>");
    printWriter.println("</html>");

    printWriter.close();
  }
}
