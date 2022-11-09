package servlet;

import DAO.DAO;
import Model.Customer;
import Model.Order;
import Model.OrderDetail;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author This PC
 */
public class ViewDetailOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        int orderID = Integer.parseInt(request.getParameter("orderid"));
        DAO dao = new DAO();
        
        Order order = dao.getOrder(orderID);
        List<OrderDetail> aOrderDetail = dao.getOrderDetail(orderID);
        Customer cus = (Customer) dao.getCustomer(order.getCusID());

        request.setAttribute("order", order);
        request.setAttribute("aOrderDetail", aOrderDetail);
        request.setAttribute("cus", cus);
        request.getRequestDispatcher("./Homepage/viewDetailOrder.jsp").forward(request, response);

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
