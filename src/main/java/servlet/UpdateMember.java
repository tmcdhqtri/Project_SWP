/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import DAO.DAO;
import Model.Customer;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "updatemember", urlPatterns = {"/UpdateMember"})
public class UpdateMember extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer acc = (Customer) session.getAttribute("acc");
        DAO dao = new DAO();
        Customer Customer = dao.getCustomer(acc.getCustomerID());
        request.setAttribute("c", Customer);
        RequestDispatcher rd = request.getRequestDispatcher("./Register/updateInfor.jsp");
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
        response.sendRedirect("./Register/viewInfor.jsp");    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
