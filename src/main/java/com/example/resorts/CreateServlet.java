package com.example.resorts;

import com.example.resorts.db.ResortControl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "CreateServlet", value = "/CreateServlet")
public class CreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name_field");
        String country = request.getParameter("country_field");
        String season = request.getParameter("season_field");
        String price = request.getParameter("price_field");

        String result = ResortControl.createRes(name,country,season,price);
        request.getSession().setAttribute("result",result);
        response.sendRedirect( request.getContextPath()+ "/createPage.jsp");
    }
}
