package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDAO;

public class StudentListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            StudentDAO dao = new StudentDAO();
            List<Student> list = dao.findAll();

            request.setAttribute("students", list);
            RequestDispatcher rd = request.getRequestDispatcher("/studentlist.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "エラーが発生しました");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
