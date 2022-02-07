package net.javaguides.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.registration.dao.EmployeeDao;
import net.javaguides.registration.model.Employee;




@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeDao employeeDao = new EmployeeDao();

    public  EmployeeServlet() {
        super();
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    	res.getWriter().append("Served at: ").append(req.getContextPath());
    	RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/employeeregister.jsp");
    	dispatcher.forward(req,res);
    }

   
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    	String firstName = req.getParameter("firstName");
    	String lastName = req.getParameter("lastName");
    	String username = req.getParameter("username");
    	String password = req.getParameter("password");
    	String address = req.getParameter("address");
    	String contact = req.getParameter("contact");
    	
    	Employee employee = new Employee();
    	employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setUsername(username);
        employee.setPassword(password);
        employee.setContact(contact);
        employee.setAddress(address);

        try {
            employeeDao.registerEmployee(employee);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/employeedetails.jsp");
    	dispatcher.forward(req,res);
    }
}   