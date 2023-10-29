package com.example.todolist;

import com.example.todolist.model.TaskManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "DeleteTaskServlet", value = "/DeleteTaskServlet")
public class DeleteTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/delete-task.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String id = request.getParameter("id");
        boolean checkDelete = TaskManager.deleteTask(id);
        String message;
        if (checkDelete) {
            message = "Delete Successful";
            session.setAttribute("message", message);
            request.getServletContext().getRequestDispatcher("/all-task.jsp").forward(request, response);
        } else {
            message = "Delete not Successful";
            session.setAttribute("message", message);
            request.getServletContext().getRequestDispatcher("/delete-task.jsp").forward(request, response);
        }
    }
}