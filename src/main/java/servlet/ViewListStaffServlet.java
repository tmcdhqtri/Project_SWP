package servlet;

import DAO.DAO;
import Model.Personnel;
import DAO.DAO;
import Model.Order;
import Model.Personnel;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class ViewListStaffServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("utf-8");

            DAO dao = new DAO();
            List<Personnel> aAllStaff = dao.getAllStaff();

            request.setAttribute("aAllStaff", aAllStaff);
            request.getRequestDispatcher("./AdminPage/listStaff.jsp").forward(request, response);

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
