/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entity.Product;
import dao.loadDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(name = "CartPageControl", urlPatterns = {"/cartPage"})
public class CartPageControl extends HttpServlet {

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
        Cookie arrCookie[] = request.getCookies();
        List<Product> listBuy = new ArrayList<>();// đây là list sản phẩm có trong cookies
        for (Cookie o : arrCookie) {
            if (o.getName().equals("id")) {
                String ids = o.getValue();//",6,6,1009"
                String arrID[] = ids.split(",");//6,6,1009,5,12
                for (String i : arrID) {
                    loadDAO dao = new loadDAO();
                    if (dao.getProductById(i) != null) {
                        listBuy.add(dao.getProductById(i));
                    }
                }
                break;
            }
        }
        //xu ly list san pham cua minh
        for (int i = 0; i < listBuy.size(); i++) {
            int count = 1;
            for (int j = i + 1; j < listBuy.size(); j++) {
                if (listBuy.get(i).getId() == listBuy.get(j).getId()) {
                    count++;
                    listBuy.remove(j);
                    j--;
                    listBuy.get(i).setAmount(count);
                }
            }
        }

        // xử lí sau khi ấn nut delte trong phần cartPage
//        if(request.getParameter("idDelete")!=null){
//                    int idDelete=Integer.parseInt(request.getParameter("idDelete"));
//            for (int i = 0; i < listBuy.size(); i++) {
//                if(listBuy.get(i).getId()==idDelete){
//                    listBuy.remove(i);
//                    i--;
//                }
//            }
//        }
//        if (request.getParameter("idDelete") != null) {
//            int idDelete = Integer.parseInt(request.getParameter("idDelete"));
//            for (Product p : listBuy) {
//                if (p.getId() == idDelete) {
//                    listBuy.remove(p);
//                }
//            }
//
//        }
        // xử lí phần tính tiền với 
        double totalPay = 0;// đây là tổng tiền cần thanh toán
        for (Product l : listBuy) {
            totalPay += l.getPrice() * l.getAmount();
        }

        if (totalPay <= 1000 && totalPay > 0) {
            totalPay = totalPay + 30 + 10;//30 là tiền ship còn 10 là phí vat
        }
        if (totalPay > 1000) {
            totalPay = totalPay + 10;// lớn hơn 1000 là được miến phí tiền ship nhưng vẫn cộng 10 tiền vat
        }

        // xử lí phần nhập mã giảm giá
        if (request.getParameter("code") != null) {
            String code = request.getParameter("code");
            if (code.equals("BẠN CỦA ĐẠT")) {
                totalPay = totalPay * 10 / 100;// giảm giá còn 10% tổng giá trị đơn hàng
            }
        }

        request.setAttribute("totalPay", totalPay);

        // list là tất cả sản phẩm đã mua
        request.setAttribute("listBuy", listBuy);
        request.getRequestDispatcher("Cart.jsp").forward(request, response);
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
