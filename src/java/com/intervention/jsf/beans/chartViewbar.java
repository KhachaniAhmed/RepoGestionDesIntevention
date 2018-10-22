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
public class chartViewbar {
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
        intervenant.setLabel("INTERVENANT");
        intervenant.set("ahmed",this.countahmed());
        intervenant.set("soufiane", this.countsoufiane());
        intervenant.set("jamal", this.countjamal());
       
 
  
        model.addSeries(intervenant);
      
         
        return model;
    }
     
    private void createBarModels() throws Exception {
        createBarModel();
        createHorizontalBarModel();
    }
     
    private void createBarModel() throws Exception {
        barModel = initBarModel();
         
        barModel.setTitle("LES INTERVENTION FAIT PAR INTERVENANT");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
       
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("INTERVENTION");
        yAxis.setMin(0);
        yAxis.setMax(10);
    }
     
    private void createHorizontalBarModel() {
        horizontalBarModel = new HorizontalBarChartModel();
 
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");
        boys.set("2004", 50);
        boys.set("2005", 96);
        boys.set("2006", 44);
        boys.set("2007", 55);
        boys.set("2008", 25);
 
        ChartSeries girls = new ChartSeries();
        girls.setLabel("Girls");
        girls.set("2004", 52);
        girls.set("2005", 60);
        girls.set("2006", 82);
        girls.set("2007", 35);
        girls.set("2008", 120);
 
        horizontalBarModel.addSeries(boys);
        horizontalBarModel.addSeries(girls);
         
        horizontalBarModel.setTitle("Horizontal and Stacked");
        horizontalBarModel.setLegendPosition("e");
        horizontalBarModel.setStacked(true);
         
        Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
        xAxis.setLabel("Births");
        xAxis.setMin(0);
        xAxis.setMax(200);
         
        Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
        yAxis.setLabel("Gender");        
    }
 public int countahmed() throws Exception {
//		Connection con =DataConnect.getConnection();
	PreparedStatement rst;
		int count=0;
		String str="select count(numero_intervention) from intervention where matricule_intervenant=12233;";
		Connection con =DataConnect.getConnection();
		rst=con.prepareStatement(str);
		
		ResultSet rs=rst.executeQuery();
		
		if(rs.next()){
			
		count=	rs.getInt(1);
			
		}
                return count;
	}
 

   public int countsoufiane() throws Exception {
//		Connection con =DataConnect.getConnection();
	PreparedStatement rst;
		int count=0;
		String str="select count(numero_intervention) from intervention where matricule_intervenant=14444;";
		Connection con =DataConnect.getConnection();
		rst=con.prepareStatement(str);
		
		ResultSet rs=rst.executeQuery();
		
		if(rs.next()){
			
		count=	rs.getInt(1);
			
		}
                return count;
	}
 public int countjamal() throws Exception {
//		Connection con =DataConnect.getConnection();
	PreparedStatement rst;
		int count=0;
		String str="select count(numero_intervention) from intervention where matricule_intervenant=52255;";
		Connection con =DataConnect.getConnection();
		rst=con.prepareStatement(str);
		
		ResultSet rs=rst.executeQuery();
		
		if(rs.next()){
			
		count=	rs.getInt(1);
			
		}
                return count;
	}


}
    

