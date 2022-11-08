/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import DAO.DAO;
import Model.Customer;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 *
 * @author Admin
 */

public class UpdateMemberAdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int cusID = Integer.parseInt(request.getParameter("CUSID"));
        DAO dao = new DAO();
        Customer Customer = dao.getCustomer(cusID);
        
        request.setAttribute("c", Customer);
        RequestDispatcher rd = request.getRequestDispatcher("./AdminPage/viewMember.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cusID = Integer.parseInt(request.getParameter(("CUSID")));
        String cusName = request.getParameter("CUSNAME");
        String cusPhone = request.getParameter("CUSPHONE");
        String cusEmail = request.getParameter("CUSEMAIL");
        String cusAddress = request.getParameter("CUSADDRESS");
        String cusDateOfBirth = request.getParameter("CUSDATEOFBIRTH");
        DAO dao = new DAO();
        dao.updateCustomer(cusID, cusName, cusPhone, cusEmail, cusAddress, cusDateOfBirth);
        response.sendRedirect("listMember");
    }

}
