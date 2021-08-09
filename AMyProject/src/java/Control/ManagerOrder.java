/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entity.OrderDetail;
import dao.loadDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(name = "ManagerOrder", urlPatterns = {"/managerOrder"})
public class ManagerOrder extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        List<OrderDetail> listOrder =new loadDAO().getAllOrderDetail();
        
        // set lại trạng thái feedback với trạng thái đơn hàng
        for (OrderDetail o : listOrder) {
            if(new loadDAO().searchFeedbackByOrderID(o.getOrderID())!=null){
                o.setFeedbackStatus(1);
            }else{
                o.setFeedbackStatus(0);
            }
            if(o.getStatus().trim().equalsIgnoreCase("Chờ xác nhận")){
                o.setStatusNum(0);
            }
            if(o.getStatus().trim().equalsIgnoreCase("Xác nhận")){
                o.setStatusNum(1);
            }
            if(o.getStatus().trim().equalsIgnoreCase("Đang giao")){
                o.setStatusNum(2);
            }
            if(o.getStatus().trim().equalsIgnoreCase("Đã giao")){
                o.setStatusNum(3);
            }
        }
        
        request.setAttribute("listOrder", listOrder);
        request.getRequestDispatcher("ManagerOrder.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
