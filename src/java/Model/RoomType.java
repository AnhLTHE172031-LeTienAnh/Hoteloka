/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import dal.DBContext;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class RoomType extends DBContext{
    String RoomTypeName, Capacity, RoomPrice, RoomAvailable, Image;

    public RoomType() {
        connect();
    }

    public RoomType(String RoomTypeName, String Capacity, String RoomPrice, String RoomAvailable, String Image) {
        this.RoomTypeName = RoomTypeName;
        this.Capacity = Capacity;
        this.RoomPrice = RoomPrice;
        this.RoomAvailable = RoomAvailable;
        this.Image = Image;
        connect();
    }

    public String getRoomTypeName() {
        return RoomTypeName;
    }

    public String getCapacity() {
        return Capacity;
    }

    public String getRoomPrice() {
        return RoomPrice;
    }

    public String getRoomAvailable() {
        return RoomAvailable;
    }

    public String getImage() {
        return Image;
    }

    public void setRoomTypeName(String RoomTypeName) {
        this.RoomTypeName = RoomTypeName;
    }

    public void setCapacity(String Capacity) {
        this.Capacity = Capacity;
    }

    public void setRoomPrice(String RoomPrice) {
        this.RoomPrice = RoomPrice;
    }

    public void setRoomAvailable(String RoomAvailable) {
        this.RoomAvailable = RoomAvailable;
    }

    public void setImage(String Image) {
        this.Image = Image;
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

    public ArrayList<RoomType> getListRoomType(int n) {
        ArrayList<RoomType> data2 = new ArrayList<RoomType>();
        try {
            String strSQL = "SELECT *\n"
                    + "FROM (\n"
                    + "  SELECT *, ROW_NUMBER() OVER (ORDER BY (SELECT NULL)) AS RowNum\n"
                    + "  FROM RoomType\n"
                    + ") AS Result\n"
                    + "WHERE RowNum > ((" + n + " - 1) * 3)\n"
                    + "  AND RowNum <= (" + n + " * 3)";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSQL);
            while (rs.next()) {
                String RoomTypeName = rs.getString(1);
                String Capacity = String.valueOf(rs.getInt(2));
                String RoomPrice = String.valueOf(rs.getInt(3));
                String RoomAvailable = String.valueOf(rs.getInt(4));
                String Image = rs.getString(5);
                RoomType rt = new RoomType(RoomTypeName, Capacity, RoomPrice, RoomAvailable, Image);
                data2.add(rt);
            }
        } catch (Exception e) {
            System.out.println("getListRoomType:" + e.getMessage());
        }
        return data2;
    }
    public ArrayList<RoomType> getAllListRoomType() {
        ArrayList<RoomType> data2 = new ArrayList<RoomType>();
        try {
            String strSQL = "select * from RoomType";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSQL);
            while (rs.next()) {
                String RoomTypeName = rs.getString(1);
                String Capacity = String.valueOf(rs.getInt(2));
                String RoomPrice = String.valueOf(rs.getInt(3));
                String RoomAvailable = String.valueOf(rs.getInt(4));
                String Image = rs.getString(5);
                RoomType rt = new RoomType(RoomTypeName, Capacity, RoomPrice, RoomAvailable, Image);
                data2.add(rt);
            }
        } catch (Exception e) {
            System.out.println("getListRoomType:" + e.getMessage());
        }
        return data2;
    }
    
    public ArrayList<RoomType> SortType(String type, String sort) {
        ArrayList<RoomType> data3 = new ArrayList<>();
        String sql;
        System.out.println(sort);
        System.out.println(type);
        if (sort.equals("asc")) {
            sql = "select * from RoomType \n"
                    + "where RoomTypeName like ? \n"
                    + "order by RoomPrice asc";
        } else {
            sql = "select * from RoomType \n"
                    + "where RoomTypeName like ? \n"
                    + "order by RoomPrice desc";
        }

        type = "%" + type + "%";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, type);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                RoomType rt = new RoomType();
                rt.setRoomTypeName(rs.getString(1));
                rt.setCapacity(String.valueOf(rs.getInt(2)));
                rt.setRoomPrice(String.valueOf(rs.getInt(3)));
                rt.setRoomAvailable(String.valueOf(rs.getInt(4)));
                rt.setImage(rs.getString(5));
                data3.add(rt);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data3;
    }

    @Override
    public String toString() {
        return "RoomType{" + "RoomTypeName=" + RoomTypeName + ", Capacity=" + Capacity + ", RoomPrice=" + RoomPrice + ", RoomAvailable=" + RoomAvailable + ", Image=" + Image + ", cnn=" + cnn + ", stm=" + stm + ", rs=" + rs + ", pstm=" + pstm + '}'+"\n";
    }

    public static void main(String[] args) {
        RoomType rt = new RoomType();
        System.out.println(rt.getAllListRoomType());
    }

}
