/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import dal.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Room extends DBContext{
    String RoomID, HotelID, RoomTypeName, UnitsInStock;

    public Room() {
        connect();
    }

    public Room(String RoomID, String HotelID, String RoomTypeName, String UnitsInStock) {
        this.RoomID = RoomID;
        this.HotelID = HotelID;
        this.RoomTypeName = RoomTypeName;
        this.UnitsInStock = UnitsInStock;
        connect();
    }

    public String getRoomID() {
        return RoomID;
    }

    public String getHotelID() {
        return HotelID;
    }

    public String getRoomTypeName() {
        return RoomTypeName;
    }

    public String getUnitsInStock() {
        return UnitsInStock;
    }

    public void setRoomID(String RoomID) {
        this.RoomID = RoomID;
    }

    public void setHotelID(String HotelID) {
        this.HotelID = HotelID;
    }

    public void setRoomTypeName(String RoomTypeName) {
        this.RoomTypeName = RoomTypeName;
    }

    public void setUnitsInStock(String UnitsInStock) {
        this.UnitsInStock = UnitsInStock;
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
    
    public ArrayList<Room> getListRooms(String roomname, String hotelcheck) {
        ArrayList<Room> data2 = new ArrayList<Room>();
        try {
            String strSQL = "SELECT *\n"
                    + "FROM (\n"
                    + "  SELECT *, ROW_NUMBER() OVER (ORDER BY (SELECT NULL)) AS RowNum\n"
                    + "  FROM Rooms\n"
                    + "  WHERE RoomTypeName = '" + roomname + "' AND HotelID = '" + hotelcheck + "'\n"
                    + ") AS Result\n"
                    + "WHERE RowNum > ((1 - 1) * 50)\n"
                    + "  AND RowNum <= (1 * 50)";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSQL);
            while (rs.next()) {        
                String RoomID = String.valueOf(rs.getInt(1));
                String HotelID = String.valueOf(rs.getInt(2));
                String RoomTypeName = rs.getString(3);
                String UnitsInStock = String.valueOf(rs.getInt(4));
                int unit = Integer.parseInt(UnitsInStock);
                if(unit == 1){
                    UnitsInStock = "Available room";
                } else if (unit == 0){
                    UnitsInStock = "Not available room";
                } else {
                    UnitsInStock = "Unknown";
                }
                Room r = new Room(RoomID, HotelID, RoomTypeName, UnitsInStock);
                data2.add(r);
            }
        } catch (Exception e) {
            System.out.println("getListRooms:" + e.getMessage());
        }
        return data2;
    }

    public ArrayList<Room> getListAllRooms(int n) {
        ArrayList<Room> data2 = new ArrayList<Room>();
        try {
            String strSQL = "SELECT *\n"
                    + "FROM (\n"
                    + "  SELECT *, ROW_NUMBER() OVER (ORDER BY (SELECT NULL)) AS RowNum\n"
                    + "  FROM Rooms\n"
                    + ") AS Result\n"
                    + "WHERE RowNum > ((" + n + " - 1) * 50)\n"
                    + "  AND RowNum <= (" + n + " * 50)";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSQL);
            while (rs.next()) {        
                String RoomID = String.valueOf(rs.getInt(1));
                String HotelID = String.valueOf(rs.getInt(2));
                String RoomTypeName = rs.getString(3);
                String UnitsInStock = String.valueOf(rs.getInt(4));
                int unit = Integer.parseInt(UnitsInStock);
                if(unit == 1){
                    UnitsInStock = "Available room";
                } else if (unit == 0){
                    UnitsInStock = "Not available room";
                } else {
                    UnitsInStock = "Unknown";
                }
                Room r = new Room(RoomID, HotelID, RoomTypeName, UnitsInStock);
                data2.add(r);
            }
        } catch (Exception e) {
            System.out.println("getListAllRooms:" + e.getMessage());
        }
        return data2;
    }

    public boolean addRoom() {
        try {
            String strSQL="insert into Rooms (HotelID, RoomTypeName, UnitsInStock) values (?, ?, ?)";
            pstm=cnn.prepareStatement(strSQL);
            pstm.setInt(1, Integer.parseInt(HotelID));
            pstm.setString(2, RoomTypeName);
            pstm.setInt(3, Integer.parseInt(UnitsInStock));
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("addRoom: " + e.getMessage());
        }
        return false;
    }

    public boolean deleteRoom() {
        try {
            String strSQL = "delete from Rooms where RoomID = ?";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setInt(1, Integer.parseInt(RoomID));
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("deleteRoom: " + e.getMessage());
        }
        return false;
    }

    public boolean updateRoom() {
        try {
            String strSQL = "update Rooms set HotelID = ?, RoomTypeName = ?, UnitsInStock = ?\n"
                    + "where RoomID = ?";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setInt(1, Integer.parseInt(HotelID));
            pstm.setString(2, RoomTypeName);
            pstm.setInt(3, Integer.parseInt(UnitsInStock));
            pstm.setInt(4, Integer.parseInt(RoomID));
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("updateRoom: " + e.getMessage());
        }
        return false;
    }

    public Room getRoomByID(String parameter) {
        try {
            String strSQL = "select * from Rooms where RoomID = ?";
            pstm=cnn.prepareStatement(strSQL);
            pstm.setString(1, parameter);
            rs = pstm.executeQuery();
            while (rs.next()) {        
                RoomID = String.valueOf(rs.getInt(1));
                HotelID = String.valueOf(rs.getInt(2));
                RoomTypeName = rs.getString(3);
                UnitsInStock = String.valueOf(rs.getInt(4));
                return new Room(RoomID, HotelID, RoomTypeName, UnitsInStock);
            }
        } catch (Exception e) {
            System.out.println("getRoomByID:" + e.getMessage());
        }
        return null;
    }
    public static void main(String[] args) {
        Room r = new Room();
        System.out.println(r.getRoomByID("1"));
    }
}
