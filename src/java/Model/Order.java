/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import dal.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Order extends DBContext{
    String ordid, hotelid, roomid, checkin, checkout, cusname, roomname;

    public Order() {
        connect();
    }

    public Order(String ordid, String hotelid, String roomid, String checkin, String checkout, String cusname, String roomname) {
        this.ordid = ordid;
        this.hotelid = hotelid;
        this.roomid = roomid;
        this.checkin = checkin;
        this.checkout = checkout;
        this.cusname = cusname;
        this.roomname = roomname;
        connect();
    }
    
    Connection cnn; //Ket noi DB
    Statement stm;//Thuc hien cac cau lenh sql
    ResultSet rs;//Luu tru va xu ly du lieu
    PreparedStatement pstm;
    
    private void connect() {
        try {
            cnn = super.connection;
            System.out.println("Connect success!");
        } catch (Exception e) {
            System.out.println("Connect fail: " + e.getMessage());
        }
    }

    public String getOrdid() {
        return ordid;
    }

    public String getHotelid() {
        return hotelid;
    }

    public String getRoomid() {
        return roomid;
    }

    public String getCheckin() {
        return checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public String getCusname() {
        return cusname;
    }

    public String getRoomname() {
        return roomname;
    }
    
    public void setOrdid(String ordid) {
        this.ordid = ordid;
    }

    public void setHotelid(String hotelid) {
        this.hotelid = hotelid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public void setCusname(String cusname) {
        this.cusname = cusname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }
    public ArrayList<Order> getListOrder() {
        ArrayList<Order> data4 = new ArrayList<Order>();
        try {
            String strSQL = "select * from Orders";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSQL);
            while (rs.next()) {
                String OrderID = String.valueOf(rs.getInt(1));
                String HotelID = String.valueOf(rs.getInt(2));
                String RoomID = String.valueOf(rs.getInt(3));
                String Checkin = String.valueOf(rs.getDate(4));
                String Checkout = String.valueOf(rs.getDate(5));
                String CustomerName = rs.getString(6);
                String RoomTypeName = rs.getString(7);
                Order o = new Order(OrderID, HotelID, RoomID, Checkin, Checkout, CustomerName, RoomTypeName);
                data4.add(o);
            }
        } catch (Exception e) {
            System.out.println("getListOrder:" + e.getMessage());
        }
        return data4;
    }
    public boolean addOrder() {
        try {
            String strSQL
                    = "    insert into Orders (HotelID, RoomID, CheckInDate, CheckOutDate, CustomerName, RoomTypeName)\n"
                    + "    values (?, ?, ?, ?, ?, ?);\n";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setInt(1, Integer.parseInt(hotelid));
            pstm.setInt(2, Integer.parseInt(roomid));
            pstm.setDate(3, Date.valueOf(checkin));
            pstm.setDate(4, Date.valueOf(checkout));
            pstm.setString(5, cusname);
            pstm.setString(6, roomname);
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("addOrder: " + e.getMessage());
        }
        return false;
    }
    
    
}
