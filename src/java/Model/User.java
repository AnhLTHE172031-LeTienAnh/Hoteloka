/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import dal.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class User extends DBContext{
    String account, password, name, email;

    public User() {
        connect();
    }

    public User(String account, String password, String name, String email) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.email = email;
        connect();
    }
    
    Connection cnn; //Ket noi DB
    Statement stm;//Thuc hien cac cau lenh sql
    ResultSet rs;//Luu tru va xu ly du lieu
    PreparedStatement pstm;

    public User(String account, String password) {
        this.account = account;
        this.password = password;
        connect();
    }

    public User(String account) {
        this.account = account;
        connect();
    }
    
    
    
    private void connect() {
        try {
            cnn = super.connection;
            System.out.println("Connect success!");
        } catch (Exception e) {
            System.out.println("Connect fail: " + e.getMessage());
        }
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }  

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public boolean checkLogin() {
        try {
            String strSQL = "select * from Users where account=? and Password=?";
            pstm=cnn.prepareStatement(strSQL);
            pstm.setString(1, account);
            pstm.setString(2, password);
            rs=pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkLogin:" + e.getMessage());
        }
        return false;
    }

    public String getNamebyAccount() {
        try {
            String strSQL = "select * from Users where account='" + account + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSQL);
            while (rs.next()) {
                String name = rs.getString(3);
                return name;
            }
        } catch (Exception e) {
            System.out.println("checkLogin:" + e.getMessage());
        }
        return "";
    }

    public boolean checkUsername() {
        String sql = "select * from Users where account = ?";
        try {
            //tao khay chua cau lenh
            pstm=cnn.prepareStatement(sql);
            pstm.setString(1, account);
            rs=pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

//    public User checkEmail(String emailIn, String name) {
//        String sql;
//        sql = "select *from Account\n"
//                + "where email=? and username=?";
//        User user = null;
//        try {
//            //tao khay chua cau lenh
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setString(1, emailIn);
//            st.setString(2, name);
//            //chay cau lenh va tao khay chua
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                //get value by column
//                int id = rs.getInt(1);
//                String acc = rs.getString(2);
//                String pass = rs.getString(3);
//                String email = rs.getString(3);
//                String role = rs.getString(3);
//                //create model
//                user = new User(id, acc, pass, email, role);
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return user;
//    }

    public void addUser(User user) {
        String sql;
        sql = "INSERT INTO [dbo].[Users]\n"
                + "           ([account]\n"
                + "           ,[Password]\n"
                + "           ,[name]\n"
                + "           ,[email])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)\n";
        try {
            //tao khay chua cau lenh
            PreparedStatement st = connection.prepareStatement(sql);
            //set gia tri ?
            st.setString(1, user.getAccount());
            st.setString(2, user.getPassword());
            st.setString(3, user.getName());
            st.setString(4, user.getEmail());
            //chay cau lenh va tao khay chua ket qua 
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
}
