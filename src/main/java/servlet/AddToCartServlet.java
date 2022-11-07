package servlet;

import DAO.DAO;
import Model.Food;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import Model.Item;

public class AddToCartServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8"); 
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        
        int foodId = Integer.parseInt(request.getParameter("foodId"));
        System.out.println("FoodID: " + foodId);
        int sl = Integer.parseInt(request.getParameter("sl"));
        System.out.println("So luong: " + sl);
        DAO dao = new DAO();
        Food food = dao.getFood(foodId);
        
        HttpSession session = request.getSession();
        ArrayList<Item> cart = (ArrayList<Item>) session.getAttribute("cart");
        
        for (int i=0; i<cart.size(); i++)
        {
            if (cart.get(i).getFood().equals(food)) //Neu food da ton tai trong gio
            {
                System.out.println("Food da ton tai trong gio");
                Item item = new Item(food, sl + cart.get(i).getSl());
                cart.set(i, item);
                
                session.removeAttribute("cart");
                session.setAttribute("cart", cart);
                
                request.getRequestDispatcher("viewdetailfood?foodID=" + foodId).forward(request, response);
            }
        }
        
        //Food chua ton tai trong gio
        System.out.println("Food chua ton tai trong gio");
        Item item = new Item(food, sl);
        cart.add(item);
        
        session.removeAttribute("cart");
        session.setAttribute("cart", cart);

        request.getRequestDispatcher("viewdetailfood?foodID=" + foodId).forward(request, response);
          
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
