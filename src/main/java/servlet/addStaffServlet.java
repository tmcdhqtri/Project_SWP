
package servlet;

import DAO.DAO;
import com.google.common.hash.Hashing;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import jakarta.servlet.http.Part;

@MultipartConfig
public class AddStaffServlet extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        System.out.println("doGet");
        
        request.getRequestDispatcher("AdminPage/addStaff.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        System.out.println("doPost");
        String name = request.getParameter("name");
        String role = "1";
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        password = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
        String image="";
        System.out.println("start getPart");
        Part part = request.getPart("image");
        System.out.println("Part: " + part);
        //Upload Image
        String realPath = request.getServletContext().getRealPath("/images");
        System.out.println("Real path: " + realPath );  //Print real path
        String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();

        if (!fileName.equals(""))
        {
            if (!Files.exists(Paths.get(realPath)))
            {
                Files.createDirectory(Paths.get(realPath));
            }

            part.write(realPath + "/" + fileName);
            image = fileName;
            System.out.println("Image name:" + image);  //print image name
        }
        
        String perStatus = "1";
        
        DAO dao = new DAO();
        dao.addPersonnel(name, role, phone, email, address, dateOfBirth, username, password,"images/" + image, perStatus);
        
         request.getRequestDispatcher("AdminPage/adminPage.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
