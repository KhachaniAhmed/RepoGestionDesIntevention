/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intervention.jsf.beans;

import com.intervention.jsf.util.DataConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;

/**
 *
 * @author pc_ahmed
 */
@ManagedBean
public class chartsbarDeparte {
    private BarChartModel barModel;
    private HorizontalBarChartModel horizontalBarModel;
 
    @PostConstruct
    public void init(){
        try {
            createBarModels();
        } catch (Exception ex) {
            Logger.getLogger(chartViewbar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    public BarChartModel getBarModel() {
        return barModel;
    }
     
    public HorizontalBarChartModel getHorizontalBarModel() {
        return horizontalBarModel;
    }
 
    private BarChartModel initBarModel() throws Exception{
        BarChartModel model = new BarChartModel();
 
        ChartSeries intervenant = new ChartSeries();
        intervenant.setLabel("DEPARTEMENT");
        intervenant.set("RH",this.countRessourceHumain());
        intervenant.set("ACHAT",this.countAchat());
        intervenant.set("NISSAN",this.countNissan());
        intervenant.set("FINANCE",this.countfinace());
        intervenant.set("PRODUCTION", this.countproduction());
        intervenant.set("QUALITE",this.countQualiter());
        intervenant.set("LOGISTIQUE", this.countLogistique());
  
        model.addSeries(intervenant);
      
         
        return model;
    }
     
    private void createBarModels() throws Exception {
        createBarModel();
        
    }
     
    private void createBarModel() throws Exception {
        barModel = initBarModel();
         
        barModel.setTitle("LES RECLAMATION FAIT PAR DEPARTEMENT");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("RECLAMATION");
        yAxis.setMin(0);
        yAxis.setMax(10);
    }
     
   

 public int countfinace() throws Exception {
//		Connection con =DataConnect.getConnection();
	PreparedStatement rst;
		int count=0;
		String str="select count(numero_reclamation) from reclamation where id_departement=1;";
		Connection con =DataConnect.getConnection();
		rst=con.prepareStatement(str);
		
		ResultSet rs=rst.executeQuery();
		
		if(rs.next()){
			
		count=	rs.getInt(1);
			
		}
                return count;
	}
  public int countproduction() throws Exception {
//		Connection con =DataConnect.getConnection();
	PreparedStatement rst;
		int count=0;
		String str="select count(numero_reclamation) from reclamation where id_departement=2;";
		Connection con =DataConnect.getConnection();
		rst=con.prepareStatement(str);
		
		ResultSet rs=rst.executeQuery();
		
		if(rs.next()){
			
		count=	rs.getInt(1);
			
		}
                return count;
	}
   public int countQualiter() throws Exception {
//		Connection con =DataConnect.getConnection();
	PreparedStatement rst;
		int count=0;
		String str="select count(numero_reclamation) from reclamation where id_departement=3;";
		Connection con =DataConnect.getConnection();
		rst=con.prepareStatement(str);
		
		ResultSet rs=rst.executeQuery();
		
		if(rs.next()){
			
		count=	rs.getInt(1);
			
		}
                return count;
	}
 public int countLogistique() throws Exception {
//		Connection con =DataConnect.getConnection();
	PreparedStatement rst;
		int count=0;
		String str="select count(numero_reclamation) from reclamation where id_departement=4;";
		Connection con =DataConnect.getConnection();
		rst=con.prepareStatement(str);
		
		ResultSet rs=rst.executeQuery();
		
		if(rs.next()){
			
		count=	rs.getInt(1);
			
		}
                return count;
	}
 public int countQualiterTeam() throws Exception {
//		Connection con =DataConnect.getConnection();
	PreparedStatement rst;
		int count=0;
		String str="select count(numero_reclamation) from reclamation where id_departement=5;";
		Connection con =DataConnect.getConnection();
		rst=con.prepareStatement(str);
		
		ResultSet rs=rst.executeQuery();
		
		if(rs.next()){
			
		count=	rs.getInt(1);
			
		}
                return count;
	}

 public int countQualiterInspection() throws Exception {
//		Connection con =DataConnect.getConnection();
	PreparedStatement rst;
		int count=0;
		String str="select count(numero_reclamation) from reclamation where id_departement=6;";
		Connection con =DataConnect.getConnection();
		rst=con.prepareStatement(str);
		
		ResultSet rs=rst.executeQuery();
		
		if(rs.next()){
			
		count=	rs.getInt(1);
			
		}
                return count;
	}


 public int countLogistiqueMagasinRe() throws Exception {
//		Connection con =DataConnect.getConnection();
	PreparedStatement rst;
		int count=0;
		String str="select count(numero_reclamation) from reclamation where id_departement=7;";
		Connection con =DataConnect.getConnection();
		rst=con.prepareStatement(str);
		
		ResultSet rs=rst.executeQuery();
		
		if(rs.next()){
			
		count=	rs.getInt(1);
			
		}
                return count;
	}


 public int countLogistiqueSupermaché() throws Exception {
//		Connection con =DataConnect.getConnection();
	PreparedStatement rst;
		int count=0;
		String str="select count(numero_reclamation) from reclamation where id_departement=8;";
		Connection con =DataConnect.getConnection();
		rst=con.prepareStatement(str);
		
		ResultSet rs=rst.executeQuery();
		
		if(rs.next()){
			
		count=	rs.getInt(1);
			
		}
                return count;
	}

 public int countLogistiqueExpedition1() throws Exception {
//		Connection con =DataConnect.getConnection();
	PreparedStatement rst;
		int count=0;
		String str="select count(numero_reclamation) from reclamation where id_departement=9;";
		Connection con =DataConnect.getConnection();
		rst=con.prepareStatement(str);
		
		ResultSet rs=rst.executeQuery();
		
		if(rs.next()){
			
		count=	rs.getInt(1);
			
		}
                return count;
	}
public int countLogistiqueExpedition2() throws Exception {
//		Connection con =DataConnect.getConnection();
	PreparedStatement rst;
		int count=0;
		String str="select count(numero_reclamation) from reclamation where id_departement=10;";
		Connection con =DataConnect.getConnection();
		rst=con.prepareStatement(str);
		
		ResultSet rs=rst.executeQuery();
		
		if(rs.next()){
			
		count=	rs.getInt(1);
			
		}
                return count;
	}
public int countAchat() throws Exception {
//		Connection con =DataConnect.getConnection();
	PreparedStatement rst;
		int count=0;
		String str="select count(numero_reclamation) from reclamation where id_departement=11;";
		Connection con =DataConnect.getConnection();
		rst=con.prepareStatement(str);
		
		ResultSet rs=rst.executeQuery();
		
		if(rs.next()){
			
		count=	rs.getInt(1);
			
		}
                return count;
	}

public int countNissan() throws Exception {
//		Connection con =DataConnect.getConnection();
	PreparedStatement rst;
		int count=0;
		String str="select count(numero_reclamation) from reclamation where id_departement=12;";
		Connection con =DataConnect.getConnection();
		rst=con.prepareStatement(str);
		
		ResultSet rs=rst.executeQuery();
		
		if(rs.next()){
			
		count=	rs.getInt(1);
			
		}
                return count;
	}

public int countRessourceHumain() throws Exception {
//		Connection con =DataConnect.getConnection();
	PreparedStatement rst;
		int count=0;
		String str="select count(numero_reclamation) from reclamation where id_departement=13;";
		Connection con =DataConnect.getConnection();
		rst=con.prepareStatement(str);
		
		ResultSet rs=rst.executeQuery();
		
		if(rs.next()){
			
		count=	rs.getInt(1);
			
		}
                return count;
	}


}
    

