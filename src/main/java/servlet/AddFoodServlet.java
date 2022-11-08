/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import DAO.DAO;
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
@WebServlet(name = "addfood", urlPatterns = {"/AddFoodServlet"})
public class AddFoodServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("AdminPage/addFood.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String foodName = request.getParameter("FOODNAME");
        String price = request.getParameter("PRICE");
        String description = request.getParameter("DESCRIPTION");
        System.out.print(foodName);
        System.out.print(price);
        System.out.print(description);

        DAO dao = new DAO();

        Part part = request.getPart("photo");
        String photoPath = request.getServletContext().getRealPath("/images");

        String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
        if (!Files.exists(Path.of(photoPath))) {
            Files.createDirectories(Path.of(photoPath));
        }
        part.write(photoPath + "/" + filename);
        dao.addFood(foodName, description,"images/" + filename, Float.parseFloat(price));
//        request.getRequestDispatcher("AdminPage/listFood.jsp").forward(request, response);
        response.sendRedirect("listFood");
    }

}
