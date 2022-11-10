package servlet;

import DAO.DAO;
import Model.Order;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author This PC
 */
public class ViewDetailOrderAdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        int orderID = Integer.parseInt(request.getParameter("orderid"));
        DAO dao = new DAO();
        
        Order order = dao.getOrder(orderID); 

        request.setAttribute("o", order); 
        request.getRequestDispatcher("./AdminPage/updateOrder.jsp").forward(request, response);

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
