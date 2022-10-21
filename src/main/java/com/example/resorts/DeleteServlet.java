package com.example.resorts;

import com.example.resorts.db.ResortControl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteServlet", value = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param = request.getParameter("delete_choice");
        String value = request.getParameter("delete_field");

        String result = ResortControl.deleteRes(param, value);
        request.getSession().setAttribute("result",result);
        response.sendRedirect( request.getContextPath()+ "/deletePage.jsp");
    }
}
