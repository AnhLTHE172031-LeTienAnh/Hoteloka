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
public class Country extends DBContext {
    String countryName, timeZone, Image;

    public Country() {
        connect();
    }

    public Country(String countryName, String timeZone, String Image) {
        this.countryName = countryName;
        this.timeZone = timeZone;
        this.Image = Image;
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

    public String getCountryName() {
        return countryName;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public String getImage() {
        return Image;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }
    
    public ArrayList<Country> getListCountry() {
        ArrayList<Country> data1 = new ArrayList<Country>();
        try {
            String strSQL = "select*from Countries";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSQL);
            while (rs.next()) {
                String HotelName = rs.getString(1);
                String TimeZone = String.valueOf(rs.getDate(2)) + " " + String.valueOf(rs.getTime(2));
                String Image = rs.getString(3);
                Country co = new Country(countryName, TimeZone, Image);
                data1.add(co);
            }
        } catch (Exception e) {
            System.out.println("getListCountry:" + e.getMessage());
        }
        return data1;
    }
}
