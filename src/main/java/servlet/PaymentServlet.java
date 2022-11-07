/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import DAO.DAO;
import Model.Order;
import Model.Customer;
import java.io.IOException;
import VNPay.Config;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "paymentservlet", urlPatterns = {"/PaymentServlet"})
public class PaymentServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession(true);
        Order order = null;
        String payment = null;
        DAO dao = new DAO();
        String payment_method = request.getParameter("payment_method");
        //check card
        Object o = session.getAttribute("order");
        if (o != null) {
            order = (Order) o;
        } else {
            order = new Order();
        }
        Customer acc = null;
        Object u = session.getAttribute("acc");
        if (o != null) {
            if (u != null) {
                int orderID = Integer.parseInt(request.getParameter("ORDERID"));
                int ID = Integer.parseInt(request.getParameter("ID"));
                int cusID = Integer.parseInt(request.getParameter("CUSID"));
                float total = Float.parseFloat(request.getParameter("TOTAL"));
                int orderStatus = 0;
                boolean orderIsActive = true;
                if (payment_method.equals("vnpay")) {
                    payment = "VNPAY";
                }
                if (payment_method.equals("cash")) {
                    payment = "CASH";
                }
                acc = (Customer) u;
                dao.addOrder(cusID, ID, orderID, java.time.LocalDate.now(), total, orderStatus, orderIsActive);
                session.removeAttribute("cart");
                session.setAttribute("size", 0);
                if (payment_method.equals("cod")) {
                    response.sendRedirect("home");
                }
                if (payment_method.equals("vnpay")) {
                    String vnp_Version = "2.1.0";
                    String vnp_Command = "pay";
                    String vnp_OrderInfo = "Thanh toan don hang" + orderID;
                    String orderType = "orderpayment";
                    String vnp_TxnRef = orderID + "";
                    String vnp_IpAddr = Config.getIpAddress(request);
                    String vnp_TmnCode = Config.vnp_TmnCode;

                    int amount = Math.round(total) * 100;
                    Map<String, String> vnp_Params = new HashMap<>();
                    vnp_Params.put("vnp_Version", vnp_Version);
                    vnp_Params.put("vnp_Command", vnp_Command);
                    vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
                    vnp_Params.put("vnp_Amount", String.valueOf(amount));
                    vnp_Params.put("vnp_CurrCode", "VND");
                    String bank_code = "";
                    if (bank_code != null && bank_code.isEmpty()) {
                        vnp_Params.put("vnp_BankCode", bank_code);
                    }
                    vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
                    vnp_Params.put("vnp_OrderInfo", vnp_OrderInfo);
                    vnp_Params.put("vnp_OrderType", orderType);

                    String locate = "vi";
                    if (locate != null && !locate.isEmpty()) {
                        vnp_Params.put("vnp_Locale", locate);
                    } else {
                        vnp_Params.put("vnp_Locale", "vn");
                    }
                    vnp_Params.put("vnp_ReturnUrl", Config.vnp_Returnurl);
                    vnp_Params.put("vnp_IpAddr", vnp_IpAddr);

                    Date dt = new Date();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
                    String dateString = formatter.format(dt);
                    String vnp_CreateDate = dateString;
                    String vnp_TransDate = vnp_CreateDate;
                    vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

                    //Build data to hash and querystring
                    List fieldNames = new ArrayList(vnp_Params.keySet());
                    Collections.sort(fieldNames);
                    StringBuilder hashData = new StringBuilder();
                    StringBuilder query = new StringBuilder();
                    Iterator itr = fieldNames.iterator();
                    while (itr.hasNext()) {
                        String fieldName = (String) itr.next();
                        String fieldValue = (String) vnp_Params.get(fieldName);
                        if ((fieldValue != null) && (fieldValue.length() > 0)) {
                            //Build hash data
                            hashData.append(fieldName);
                            hashData.append('=');
                            hashData.append(fieldValue);
                            //Build query
                            query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                            query.append('=');
                            query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                            if (itr.hasNext()) {
                                query.append('&');
                                hashData.append('&');
                            }
                        }
                    }
                    String queryUrl = query.toString();
                    String vnp_SecureHash = Config.Sha256(Config.vnp_HashSecret + hashData.toString());
                    queryUrl += "&vnp_SecureHashType=SHA256&vnp_SecureHash=" + vnp_SecureHash;
                    String paymentUrl = Config.vnp_PayUrl + "?" + queryUrl;
                    request.setAttribute("code", "00");
                    request.setAttribute("message", "success");
                    request.setAttribute("data", paymentUrl);
                    response.sendRedirect(paymentUrl);
                    return;
                }
            } else {
                response.sendRedirect("login");
            }
        } else {
            if (payment_method.equals("cash")) {
                response.sendRedirect("home");
            }
        }
    }
}
