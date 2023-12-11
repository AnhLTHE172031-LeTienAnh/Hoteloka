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
public class City extends DBContext {
    String cityName, countryName, timeZone, Image;

    public City() {
        connect();
    }

    public City(String cityName, String countryName, String timeZone, String Image) {
        this.cityName = cityName;
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

    public String getCityName() {
        return cityName;
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

    public void setCityName(String cityName) {
        this.cityName = cityName;
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
    
    public ArrayList<City> getListCity() {
        ArrayList<City> data1 = new ArrayList<City>();
        try {
            String strSQL = "select*from Cities";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSQL);
            while (rs.next()) {
                String CityName = rs.getString(1);
                String CountryName = rs.getString(2);
                String TimeZone = String.valueOf(rs.getDate(3)) + " " + String.valueOf(rs.getTime(3));
                String Image = rs.getString(4);
                City ci = new City(CityName, CountryName, TimeZone, Image);
                data1.add(ci);
            }
        } catch (Exception e) {
            System.out.println("getListCountry:" + e.getMessage());
        }
        return data1;
    }
    
    
}
