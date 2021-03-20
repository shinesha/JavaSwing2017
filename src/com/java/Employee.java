/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Viran Gohil 15500582
 * Employee Class extends the Class Person
 */
public class Employee extends Person implements Serializable
{

	Date start;
	double salary;
    String job_title;
    int id;
	
        /**
         *  Default Constructor
         */
        public Employee()
        {
            
            super("",'\0', null, "", "", "");
        }
        /**
         * Constructor with 10 parameters
         */	
	public Employee(int id, String name, char sex, Date dob, String address, String natInsceNo, String phoneNo,
                double salary, String job_title, Date start)
	{
		super(name, sex, dob, address, natInsceNo, phoneNo);
		this.start = start;
		this.salary = salary;
                this.job_title= job_title;
                this.id= id;
	}
        /**
         *  set employee ID
         *  @param id new ID
         */
	public void setID(int id)
	{
		this.id = id;
	}
        /**
         *  get employee ID
         */        
	public int getID()
	{
		return this.id;
	}  
        /**
         *  set employee salary
         *  @param salary new salary
         */        
	public void setSalary(double salary)
	{
		this.salary = salary;
	}
        /**
         *  get employee salary
         *  
         */        
	public double getSalary()
	{
		return salary;
	}   
        /**
         *  set employee job title
         *  @param job_title new title
         */        
	public void setJobTitle(String job_title)
	{
		this.job_title = job_title;
	}
        /**
         *  get employee job title
         *  
         */        
	public String getJob_title()
	{
		return job_title;
	}  
        /**
         *  set employee job start date
         *  @param start new start date
         */        
	public void setStartDate(Date start)
	{
		this.start = start;
	}
        /**
         *  get employee job start date
         *  
         */        
	public Date getStartDate()
	{
		return this.start;
	}   
        /**
         *  get s String representation of Employee
         *  
         */        
	public String toString()
	{
		return "ID " + id + " Name: " + name + " Gender: " + gender +  " Date Of Birth: " + dateOfBirth
		+ "address: " + address + "natInsceNo: "
		+ natInsceNo + " phoneNo: " + phoneNo+ " Start date " + start + " Salary "
		+ salary ;
	}
}
