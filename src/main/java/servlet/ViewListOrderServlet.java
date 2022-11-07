/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import DAO.DAO;
import Model.Order;
import Model.OrderDetail;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author This PC
 */
public class ViewListOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        DAO dao = new DAO();
        ArrayList<Order> aAllOrder = dao.getAllOrders();
        
        request.setAttribute("aAllOrder", aAllOrder);
        request.getRequestDispatcher("./Homepage/cusViewOrder.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
