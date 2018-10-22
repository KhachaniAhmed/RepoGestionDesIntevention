package com.intervention.jsf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.intervention.jsf.util.DataConnect;


public class LoginDAO {

	public static String validate(String user, String password) throws SQLException {
		Connection con = null;
        PreparedStatement ps = null;
    	String type="Undefined";
 
      
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Select login, password,type,nom_intervenant from intervenant where login = ? and password = ?");
            ps.setString(1, user);
            ps.setString(2, password);
 
            ResultSet rs = ps.executeQuery();
 
			if (rs.next()) {
				type=rs.getString(3);
			}
			// hna mli makaykonch chi user type tatkon null att nchofo blan
			if(type == "Undefined")
				return "false";
			
			
			return type;
        }        			}
	
	

