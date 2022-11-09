/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import DAO.DAO;
import Model.Customer;
import Model.Item;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AddOrderServlet", urlPatterns = {"/addOrder"})
public class AddOrderServlet extends HttpServlet {

  

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    DAO dao = new DAO();
    HttpSession session = request.getSession();
    Customer customer = null;
    Object o = session.getAttribute("acc");
    customer = (Customer) o;
    float total = 0;
    int orderStatus = 0;
    boolean pay;
    ArrayList<Item> cart = (ArrayList<Item>) session.getAttribute("cart");
    int cusID = customer.getCustomerID();
    String payment = request.getParameter("payment");
    if (payment.equals("VNPAY")) 
        pay = true;
    else pay = false;
    for(Item item : cart){
        total += item.getSl() * item.getFood().getFoodPrice();
    }
    dao.addOrder(cusID, 1, total, pay, orderStatus);
    request.getRequestDispatcher("./Homepage/payForOrder.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
