package com.example.resorts;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.resorts.db.ResortControl;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "DBResortServlet", value = "/DBResortServlet")
public class DBResortServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1. получим все курорты
//        List<String> resList = Arrays.stream(ResortControl.getAllResorts()).toList();
//
//        // 2. установим курорты в параметр resorts в контекст сессии
//        request.getSession().setAttribute("resorts",resList);
//
//        // 3. вернем данные на JSP через перенаправление
//        response.sendRedirect(request.getContextPath() + "/readPage.jsp");

        String s = request.getParameter("req");
//        String page = "";
//        String value = "";
        if (s.equals("create")) {
            response.sendRedirect(request.getContextPath() + "/createPage.jsp");
        } else if (s.equals("read")) {
            response.sendRedirect(request.getContextPath() + "/readPage.jsp");
        } else if (s.equals("update")) {
            response.sendRedirect(request.getContextPath() + "/updatePage.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/deletePage.jsp");
        }
    }
    public void destroy() {
    }
}