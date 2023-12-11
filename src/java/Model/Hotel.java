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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
/**
 *
 * @author FiSH
 */
public class Hotel extends DBContext {
    String HotelID, HotelName, Hotline, Address, CityName, Service, RateNumber, Image;

    public Hotel() {
        connect();
    }

    public Hotel(String HotelID, String HotelName, String Hotline, String Address, String CityName, String Service, String RateNumber, String Image) {
        this.HotelID = HotelID;
        this.HotelName = HotelName;
        this.Hotline = Hotline;
        this.Address = Address;
        this.CityName = CityName;
        this.Service = Service;
        this.RateNumber = RateNumber;
        this.Image = Image;
    }

    public String getHotelID() {
        return HotelID;
    }

    public void setHotelID(String HotelID) {
        this.HotelID = HotelID;
    }

    public String getHotelName() {
        return HotelName;
    }

    public void setHotelName(String HotelName) {
        this.HotelName = HotelName;
    }

    public String getHotline() {
        return Hotline;
    }

    public void setHotline(String Hotline) {
        this.Hotline = Hotline;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String CityName) {
        this.CityName = CityName;
    }

    public String getService() {
        return Service;
    }

    public void setService(String Service) {
        this.Service = Service;
    }

    public String getRateNumber() {
        return RateNumber;
    }

    public void setRateNumber(String RateNumber) {
        this.RateNumber = RateNumber;
    }

    public String getImage() {
        return Image;
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

    public ArrayList<Hotel> getListHotelbyCity(int n, String cityName) {
        ArrayList<Hotel> data = new ArrayList<Hotel>();
        try {
            String strSQL = "SELECT *\n"
                    + "FROM (\n"
                    + "  SELECT *, ROW_NUMBER() OVER (ORDER BY (SELECT NULL)) AS RowNum\n"
                    + "  FROM Hotels\n"
                    + "  WHERE CityName = '" + cityName + "'\n"
                    + ") AS Result\n"
                    + "WHERE RowNum > ((" + n + " - 1) * 3)\n"
                    + "  AND RowNum <= (" + n + " * 3)";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSQL);
          while (rs.next()) {
                String HotelID = String.valueOf(rs.getInt(1));
                String HotelName = rs.getString(2);
                String Hotline = rs.getString(3);
                String Address = rs.getString(4);
                String CityName = rs.getString(5);
                String Service = rs.getString(6);
                String RateNumber = String.valueOf(rs.getInt(7));
                String Image = rs.getString(8);
                Hotel h = new Hotel(HotelID, HotelName, Hotline, Address, CityName, Service, RateNumber, Image);
                data.add(h);
            }
        } catch (Exception e) {
            System.out.println("getListHotel:" + e.getMessage());
        }
        return data;
    }

    public ArrayList<Hotel> getListHotelbyName(int n, String name) {
        ArrayList<Hotel> data = new ArrayList<Hotel>();
        try {
            String strSQL = "SELECT *\n"
                    + "FROM (\n"
                    + "  SELECT *, ROW_NUMBER() OVER (ORDER BY (SELECT NULL)) AS RowNum\n"
                    + "  FROM Hotels\n"
                    + "  WHERE HotelName LIKE '%" + name + "%' "
                    + ") AS Result\n"
                    + "WHERE RowNum > ((" + n + " - 1) * 3)\n"
                    + "  AND RowNum <= (" + n + " * 3)";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSQL);
            while (rs.next()) {
                String HotelID = String.valueOf(rs.getInt(1));
                String HotelName = rs.getString(2);
                String Hotline = rs.getString(3);
                String Address = rs.getString(4);
                String CityName = rs.getString(5);
                String Service = rs.getString(6);
                String RateNumber = String.valueOf(rs.getInt(7));
                String Image = rs.getString(8);
                Hotel h = new Hotel(HotelID, HotelName, Hotline, Address, CityName, Service, RateNumber, Image);
                data.add(h);
            }
        } catch (Exception e) {
            System.out.println("getListHotel:" + e.getMessage());
        }
        return data;
    }

    public ArrayList<Hotel> getListHotel(int n) {
        ArrayList<Hotel> data = new ArrayList<Hotel>();
        try {
            String strSQL = "SELECT *\n"
                    + "FROM (\n"
                    + "  SELECT *, ROW_NUMBER() OVER (ORDER BY (SELECT NULL)) AS RowNum\n"
                    + "  FROM Hotels\n"
                    + ") AS Result\n"
                    + "WHERE RowNum > ((" + n + " - 1) * 3)\n"
                    + "  AND RowNum <= (" + n + " * 3)";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSQL);
            while (rs.next()) {
                String HotelID = String.valueOf(rs.getInt(1));
                String HotelName = rs.getString(2);
                String Hotline = rs.getString(3);
                String Address = rs.getString(4);
                String CityName = rs.getString(5);
                String Service = rs.getString(6);
                String RateNumber = String.valueOf(rs.getInt(7));
                String Image = rs.getString(8);
                Hotel h = new Hotel(HotelID, HotelName, Hotline, Address, CityName, Service, RateNumber, Image);
                data.add(h);
            }
        } catch (Exception e) {
            System.out.println("getListHotel:" + e.getMessage());
        }
        return data;
    }
}
