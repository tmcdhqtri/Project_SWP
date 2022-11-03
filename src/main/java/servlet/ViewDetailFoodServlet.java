
package servlet;

import java.io.IOException;
import DAO.DAO;
import Model.Food;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewDetailFoodServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        int  foodID = Integer.parseInt(request.getParameter("foodID"));
        DAO dao = new DAO();
        
        Food food = dao.getFood(foodID); 

        request.setAttribute("food", food); 
        request.getRequestDispatcher("./Homepage/viewDetailFood.jsp").forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
    }
    
    
        @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}
