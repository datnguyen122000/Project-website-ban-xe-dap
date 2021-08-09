/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entity.Category;
import Entity.Product;
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
@WebServlet(name = "LoadToManagerProduct", urlPatterns = {"/loadToManagerProduct"})
public class LoadToManagerProduct extends HttpServlet {

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
        loadDAO ld = new loadDAO();
        List<Product> listP = ld.getAllProduct();
        
        request.setAttribute("entries", listP.size());
        
        //xu li phan paging
        int numOfPage = listP.size() / 10;
        if (listP.size() %10 != 0) {
            numOfPage++;
        }
        // indexPage la page duoc chon hien tai
        int indexPage = 1;
        if (request.getParameter("indexPage") != null) {
            indexPage = Integer.parseInt(request.getParameter("indexPage"));
        }
        //index la gia tri can truyen vao database
        //indexPage    index
//             1           0=10x(1-1)   đang ở trang 1 thì chạy từ thằng số 0 đến thằng số 9
//             2           10=10x(2-1)
//             3           20=9x(3-1)
//             4           30=9x(4-1)
        int index = 10 * (indexPage - 1);
        List<Product> listProductByPage = ld.getProductByPaging(index,10);
        request.setAttribute("indexPage", indexPage);
        request.setAttribute("numOfPage", numOfPage);
        
        request.setAttribute("listP", listProductByPage);
        List<Category> listC=ld.getAllCategory();// lấy tất cả category
        request.setAttribute("listC", listC);
        
        request.getRequestDispatcher("ManagerProduct.jsp").forward(request, response);
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
