package com.intervention.jsf.beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



import com.intervention.jsf.dao.LoginDAO;
import com.intervention.jsf.util.DataConnect;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.model.chart.PieChartModel;

@ManagedBean
@SessionScoped
public class intervenant implements Serializable {
	private int id_intervenant;
	private String login;
	private String password;
	private String type;
        private PieChartModel model;
       private String email;
       private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
       
       public intervenant()  {
		
	}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
       
	public int getId_intervenant() {
		return id_intervenant;
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
	public intervenant(int id_intervenant, String login, String password, String type,String nom) {
		super();
		this.id_intervenant = id_intervenant;
		this.login = login;
		this.password = password;
		this.type = type;
                this.nom=nom;
	}
	
	public String validateUsernamePassword() throws SQLException {
		String test=null;
		String valid = LoginDAO.validate(this.login, this.password);
	
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

        
         public static ArrayList<intervenant> getMails() throws Exception{
       
           
            ArrayList<intervenant> listemail= new ArrayList<>();
            try {
                PreparedStatement rst;
                
                String str="SELECT email FROM intervenant";
                Connection con =DataConnect.getConnection();
                rst=con.prepareStatement(str);
                ResultSet rs=rst.executeQuery();
                while(rs.next()){
                   intervenant inter = new intervenant();
                    inter.setEmail(rs.getString("email"));
                listemail.add(inter);
                }  
            } catch (Exception ex) {
                Logger.getLogger(IntervanentHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
      
    return listemail;
    }

public String Nomintervenant(String login) throws SQLException{
    String nom_intervenant="";
            try{
      PreparedStatement rstt;
                
                String strr="SELECT nom_intervenant FROM intervenant where login='"+login+"'";
                Connection con =DataConnect.getConnection();
                rstt=con.prepareStatement(strr);
                ResultSet rs=rstt.executeQuery();
            while(rs.next()){
                nom_intervenant=rs.getString("nom_intervenant");
            }
            
            }
            catch(Exception ex){
             Logger.getLogger(IntervanentHelper.class.getName()).log(Level.SEVERE, null, ex);
        
            }
    
    return nom_intervenant;
}
}

