package servlet;

import DAO.DAO;
import Model.Food;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "ViewInfoServlet", urlPatterns = {"/viewinfo"})
public class ViewInfoServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
//        
//        int  foodID = Integer.parseInt(request.getParameter("foodID"));
//        DAO dao = new DAO();
//        
//        Food food = dao.getFood(foodID); 
// 
//        request.setAttribute("food", food); 
        
        request.getRequestDispatcher("./Register/viewInfor.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }



}
