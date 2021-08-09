/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author DELL
 */
public class OrderDetail {
    private int orderID;
    private String customerName;

    public int getFeedbackStatus() {
        return feedbackStatus;
    }

    public void setFeedbackStatus(int feedbackStatus) {
        this.feedbackStatus = feedbackStatus;
    }
    private String detail;
    private double totalPay;
    private String status;
    private String deliveryAddress;
    private String payment;
    private int statusNum=-1;// để 0:chờ xác nhận,1:xác nhận,2:đang giao,3:đã giao
    private int feedbackStatus=-1;//0 là chưa feedback , 1 là người đó đã feedback rồi

    public int getStatusNum() {
        return statusNum;
    }

    public void setStatusNum(int statusNum) {
        this.statusNum = statusNum;
    }

    public OrderDetail() {
    }

    public OrderDetail(int orderID, String customerName, String detail, double totalPay, String status, String deliveryAddress, String payment) {
        this.orderID = orderID;
        this.customerName = customerName;
        this.detail = detail;
        this.totalPay = totalPay;
        this.status = status;
        this.deliveryAddress = deliveryAddress;
        this.payment = payment;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public double getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(double totalPay) {
        this.totalPay = totalPay;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "orderID=" + orderID + ", customerName=" + customerName + ", detail=" + detail + ", totalPay=" + totalPay + ", status=" + status + ", deliveryAddress=" + deliveryAddress + ", payment=" + payment + '}';
    }
    
}
