/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entity.Account;
import dao.loadDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
@WebServlet(name = "ChangePass", urlPatterns = {"/changePass"})
public class ChagePass extends HttpServlet {

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
        loadDAO ld =new loadDAO();
        
        //lấy user và account của tài khoản account hiện tại
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        
        String oldPass=request.getParameter("oldPass");
        String newPass=request.getParameter("newPass");
        String reNewPass=request.getParameter("reNewPass");
        //trường hợp 1 người dùng bỏ trống 1 trong các ô
        if(oldPass.isEmpty()||newPass.isEmpty()||reNewPass.isEmpty()){
            request.setAttribute("notice", 1);
             request.getRequestDispatcher("ChangePass.jsp").forward(request, response);
        }
//        trường hợp người dùng nhập sai mật khẩu cũ
        if(ld.login(a.getUser(), oldPass)==null){
            request.setAttribute("notice", 2);
            request.getRequestDispatcher("ChangePass.jsp").forward(request, response);// nhập sai quay về trang changePass.jsp luôn để không bị set lỗi nhập sai repass nếu bị cả 2 lỗi nhập sai pass cũ và nhập sai repass thì chỉ nhận lỗi sai mật khẩu cũ trước rồi set notice=2 trước
        }
//        người dùng nhập repass sai
        if(!newPass.equals(reNewPass)){
            request.setAttribute("notice", 3);
             request.getRequestDispatcher("ChangePass.jsp").forward(request, response);
        }
        ld.changePass(a.getUser(), newPass);
        request.setAttribute("notice", 4);
        request.getRequestDispatcher("ChangePass.jsp").forward(request, response);
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
