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
public class Feedback {
    private int orderID;
    private String comment;
    private String time;
    private String evalue;

    public Feedback() {
    }

    public Feedback(int orderID, String comment, String time, String evalue) {
        this.orderID = orderID;
        this.comment = comment;
        this.time = time;
        this.evalue = evalue;
    }
    
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEvalue() {
        return evalue;
    }

    public void setEvalue(String evalue) {
        this.evalue = evalue;
    }

    @Override
    public String toString() {
        return "Feedback{" + "orderID=" + orderID + ", comment=" + comment + ", time=" + time + ", evalue=" + evalue + '}';
    }

    
}
