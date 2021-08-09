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
public class Account {
    private int id;
    private String user;
    private String pass;
    private int isBuy;
    private int isAdmin;
    private String fullName;

    public Account() {
    }

    public Account(int id, String user, String pass, int isBuy, int isAdmin, String fullName) {
        this.id = id;
        this.user = user;
        this.pass = pass;
        this.isBuy = isBuy;
        this.isAdmin = isAdmin;
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getIsBuy() {
        return isBuy;
    }

    public void setIsBuy(int isBuy) {
        this.isBuy = isBuy;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", user=" + user + ", pass=" + pass + ", isBuy=" + isBuy + ", isAdmin=" + isAdmin + ", fullName=" + fullName + '}';
    }
    
}
