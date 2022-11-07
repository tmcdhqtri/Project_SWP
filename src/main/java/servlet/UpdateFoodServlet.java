/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import DAO.DAO;
import Model.Food;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@MultipartConfig

public class UpdateFoodServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String foodID = request.getParameter(("FOODID"));
        DAO dao = new DAO();
        Food food = dao.getFood(Integer.parseInt(foodID));
        request.setAttribute("f", food);
        RequestDispatcher rd = request.getRequestDispatcher("./AdminPage/updateFood.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        int foodID = Integer.parseInt(request.getParameter(("FOODID")));
        String foodName = request.getParameter("FOODNAME");
        String description = request.getParameter("DESCRIPTION");
        Float price = Float.parseFloat(request.getParameter("PRICE"));
        DAO dao = new DAO();
        Part part = request.getPart("photo");
        String photoPath = request.getServletContext().getRealPath("/images");
        String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
        if (!Files.exists(Path.of(photoPath))) {
            Files.createDirectories(Path.of(photoPath));
        }
        part.write(photoPath + "/" + filename);
        dao.updateFood(foodID,foodName, description,"images/" + filename, price);
        response.sendRedirect("listFood");
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
