/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intervention.jsf.beans;

import com.intervention.jsf.dao.LoginDAO;
import com.intervention.jsf.util.DataConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author pc_ahmed
 */
@ManagedBean
@SessionScoped
public class chartsintervant {
    private int id_intervenant;
	private String login;
	private String password;
	private String type;
        private PieChartModel model;
       private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
       
	public int getId_intervenant() {
		return id_intervenant;
	}
	boolean editable;
	
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	public void setId_intervenant(int id_intervenant) {
		this.id_intervenant = id_intervenant;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public chartsintervant(int id_intervenant, String login, String password, String type) {
		super();
		this.id_intervenant = id_intervenant;
		this.login = login;
		this.password = password;
		this.type = type;
	}
	public chartsintervant() throws Exception {
		model = new PieChartModel();
                model.set("RECLAMATION",this.countreclamation());
                model.set("INTERVENTION",this.countintervention());
                model.set("INTERVENANT",3);
                 
                
                model.setTitle("Gestion des Intervention");
                model.setLegendPosition("w");
                model.setDiameter(100);
                model.setShowDataLabels(true);
	}
	public String validateUsernamePassword() throws SQLException {
		String test=null;
		String valid = LoginDAO.validate(login, password);
	
		if (valid.equals("admin")) {
			test="admin";
		} else  if (valid.equals("intervenant")) {
			test= "intervenant";
		}
		else if(valid.equals("false")) {
			
			test= "aucun_intervenant";
		}
		return test;
		
		
		
		}
	
	
	
       
	public int countreclamation() throws Exception {
//		Connection con =DataConnect.getConnection();
	PreparedStatement rst;
		int count=0;
		String str="select count(numero_reclamation) from reclamation;";
		Connection con =DataConnect.getConnection();
		rst=con.prepareStatement(str);
		
		ResultSet rs=rst.executeQuery();
		
		if(rs.next()){
			
		count=	rs.getInt(1);
			
		}
                return count;
	}
        
	public int countintervention() throws Exception {
//		Connection con =DataConnect.getConnection();
	PreparedStatement rst;
		int count=0;
		String str="select count(numero_intervention) from intervention;";
		Connection con =DataConnect.getConnection();
		rst=con.prepareStatement(str);
		
		ResultSet rs=rst.executeQuery();
		
		if(rs.next()){
			
		count=	rs.getInt(1);
			
		}
                return count;
	}
	public int countintervenent() throws Exception {
//		Connection con =DataConnect.getConnection();
	PreparedStatement rst;
		int count=0;
		String str="select count(matricule_intervenant) from intervenant;";
		Connection con =DataConnect.getConnection();
		rst=con.prepareStatement(str);
		
		ResultSet rs=rst.executeQuery();
		
		if(rs.next()){
			
		count=	rs.getInt(1);
			
		}
                return count;
	}
        
        	public int countoperateur() throws Exception {
//		Connection con =DataConnect.getConnection();
	PreparedStatement rst;
		int count=0;
		String str="select count(matricule_operateur) from operateur;";
		Connection con =DataConnect.getConnection();
		rst=con.prepareStatement(str);
		
		ResultSet rs=rst.executeQuery();
		
		if(rs.next()){
			
		count=	rs.getInt(1);
			
		}
                return count;
	}

	
	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
	}

	//logout event, invalidate session
	public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
	}

	public String logout() {
		HttpSession session = getSession();
		session.invalidate();
		return "login";
	}

	

    public PieChartModel getModel() {
        return model;
    }

    
}
