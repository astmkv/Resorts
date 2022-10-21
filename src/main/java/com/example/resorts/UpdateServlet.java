package com.example.resorts;

import com.example.resorts.db.ResortControl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "UpdateServlet", value = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param = request.getParameter("update_choice");
        String value = request.getParameter("update_field");
        String newParams = ("name = " + "'" + request.getParameter("name_field") + "'" + ", " +
                "country = " + "'" + request.getParameter("country_field") + "'" + ", " +
                "season = " + "'" + request.getParameter("season_field") + "'" + ", " +
                "price = " + "'" + Integer.parseInt(request.getParameter("price_field")) + "'");

        String result = ResortControl.updateRes(param, value, newParams);
        request.getSession().setAttribute("result",result);
        response.sendRedirect( request.getContextPath()+ "/updatePage.jsp");
    }
}
