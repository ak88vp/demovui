package controller;

import model.Student;
import service.StudentService;
import service.StudentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "StudentServlet", value = "/students")
public class StudentServlet extends HttpServlet {
    StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(request, response);
                break;
            case "delete":
                showDelete(request, response);
                break;
            case "edit":
                showEdit(request,response);
                break;
            case "view":
                showView(request,response);
                break;
            default:
                listStudents(request, response);
        }
    }

    private void showView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findById(id);
        request.setAttribute("student", student);

        RequestDispatcher requestDispatcher=request.getRequestDispatcher("student/view.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findById(id);
        request.setAttribute("student", student);

        RequestDispatcher requestDispatcher=request.getRequestDispatcher("student/edit.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findById(id);
        request.setAttribute("student", student);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/delete.jsp");
        
        requestDispatcher.forward(request, response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Student> students = (ArrayList<Student>) studentService.findAll();

        request.setAttribute("student", students);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/list.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createStudent(request, response);
                break;
            case "delete":
                deleteStudent(request, response);
                break;
            case "edit":
                editStudent(request,response);
                break;
            case "find":
                findStudent(request,response);
                break;
        }
    }

    private void findStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name= request.getParameter("findName");
        Student student = studentService.findById(name);
        request.setAttribute("student",student);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("student/find.jsp");
        requestDispatcher.forward(request,response);
    }

    private void editStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("student/edit.jsp");
        int id= Integer.parseInt(request.getParameter("id"));
        String name= request.getParameter("name");
        String subjects= request.getParameter("subjects");
        double score=Double.parseDouble(request.getParameter("score"));
        Student student=studentService.findById(id);

        Student newStudent = new Student(id,name,subjects,score);
        studentService.edit(id,newStudent);
        request.setAttribute("massage","Sua Thanh Cong");

        request.setAttribute("student",newStudent);

        requestDispatcher.forward(request,response);
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/delete.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findById(id);
        request.setAttribute("student", student);
        studentService.delete(id);
//        request.setAttribute("massage", "Xoa Thanh Cong");
        response.sendRedirect("/students");
        requestDispatcher.forward(request,response);

    }

    private void createStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/create.jsp");
        String name = request.getParameter("name");
        int id = studentService.findAll().size() + 1;
        String subjects = request.getParameter("subjects");
        double score;
        if (request.getParameter("score") == "") {
            score = 0;
        } else {
            score = Double.parseDouble(request.getParameter("score"));
        }

        Student student = new Student(id, name, subjects, score);
        studentService.add(student);
        request.setAttribute("massage", "Them Thanh Cong");
        requestDispatcher.forward(request, response);
    }
}
