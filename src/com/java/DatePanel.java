/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.*;

/**
 *
 * @author Viran Gohil 15500582
 * The class creates a custom Date Panel to be used in the GUI
 */
public class DatePanel extends JPanel 
{
    JComboBox    cmb_day;
    JComboBox    cmb_month;
    JComboBox    cmb_year;
    
    /**
     *  Default Constructor
     * Create three JComboxbox for day, month and year
     */
    public DatePanel()
    {
        this.setLayout(new FlowLayout());
        /*
         *  Fill day combobox with values from 1 to 31
         */        
        cmb_day=new JComboBox();
        for(int i=1; i<=31; i++)
        {
            cmb_day.addItem(i);
        }
        add(cmb_day);
        /*
         *  Fill month combobox with values from 1 to 12
         */        
        cmb_month=new JComboBox();
        for(int i=1; i<=12; i++)
        {
            cmb_month.addItem(i);
        }
        add(cmb_month);   
        /*
         *  Fill year combobox with values from 1970 to 2030
         */        
        cmb_year=new JComboBox();
        for(int i=1970; i<=2030; i++)
        {
            cmb_year.addItem(i);
        }
        add(cmb_year);
    }
    /**
     *  Get selected Day
     */
    public int get_day() 
    {
        return (Integer)cmb_day.getSelectedItem();
    }
    /**
     *  Get selected Month
     */    
    public int get_month() 
    {
        return (Integer)cmb_month.getSelectedItem();
    }    
    /**
     *  Get selected Year
     */    
    public int get_year() 
    {
        return (Integer)cmb_year.getSelectedItem();
    }    
    
    /**
     *  Get Date
     */    
    public Date getDate()
    {
        GregorianCalendar cal= new GregorianCalendar(get_year(), get_month() - 1, get_day());
        return cal.getTime();
    }
    /**
     * set Date
     * @param date new date to be used
     */
    public void setDate(Date date)
    {
        Calendar cal= new GregorianCalendar();
        cal.setTime(date);
        cmb_day.setSelectedItem(cal.get(Calendar.DAY_OF_MONTH));
        cmb_month.setSelectedItem(cal.get(Calendar.MONTH)+1);
        cmb_year.setSelectedItem(cal.get(Calendar.YEAR));
    }
    /**
     * reset date to default value
     * 
     */    
    public void resetDate()
    {
        cmb_day.setSelectedIndex(0);
        cmb_month.setSelectedIndex(0);
        cmb_year.setSelectedIndex(0);
    }
    /**
     *  Get Date as String
     */      
    public String getGMTDate()
    {
        return cmb_day.getSelectedItem()+"-"+cmb_month.getSelectedItem()+"-"+cmb_year.getSelectedItem();
    }
    
}
