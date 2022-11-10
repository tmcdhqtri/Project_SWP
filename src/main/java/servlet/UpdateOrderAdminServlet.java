/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import DAO.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class UpdateOrderAdminServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

        @Override
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response)
            throws jakarta.servlet.ServletException, IOException {
        String orderID = request.getParameter("ORDERID");
        String action = request.getParameter("action");
        DAO dao = new DAO();
        int orderStatus;
        if (action.equals("success")){
           orderStatus = 1;
           dao.updateOrderStatus(Integer.parseInt(orderID), orderStatus);
        }
        else 
        {            
            orderStatus = 2;
            dao.updateOrderStatus(Integer.parseInt(orderID), orderStatus);
        }
           
        response.sendRedirect("listOrder");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
