package servlet;

import Model.Food;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class AddFoodOrderServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            List<Food> listFoods = new ArrayList<>();    
            int foodID = Integer.parseInt(request.getParameter("FOODID"));
            int orderID = Integer.parseInt(request.getParameter("ORDERID"));
            String image = request.getParameter("IMAGE");
            String foodName = request.getParameter("FOODNAME");
            String description = request.getParameter("DESCRIPTION");
            float price = Float.parseFloat(request.getParameter("PRICE"));
            int quantity = Integer.parseInt(request.getParameter("Quantity"));
            float total = Float.parseFloat(request.getParameter("TOTAL"));
            listFoods.add(new Food(foodID, foodName, description, image, price));
            HttpSession session = request.getSession();
            session.setAttribute("listFoodOrder", listFoods);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

