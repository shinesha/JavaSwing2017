/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java;

import java.io.*;
import java.util.Date;
/**
 *
 * @author Viran Gohil 15500582
 * Person class
 */
public class Person implements Serializable
{
	protected String name;
	protected char gender;
	protected Date dateOfBirth;
	protected String address;
	protected String natInsceNo;
	protected String phoneNo;
	
        /**
         * Constructor. For invocation by subclass 
         * constructors, typically implicit.
         */
	public Person(String name, char sex, Date dob, String address, String natInsceNo, String phoneNo)
	{
			this.name = name;
			this.gender = sex;
			this.dateOfBirth = dob;
			this.address = address;
			this.natInsceNo = natInsceNo;
			this.phoneNo = phoneNo;
	}
	
        /**
         * set person name
         * @param name new name
         */
        public void set_name(String name)
        {
            this.name=name;
        }
        /**
         *  get person name
         *  @return 
         */
        public String get_name()
        {
            return this.name;
        }
        /**
         *  set person gender
         * @param gender new gender
         */
        public void set_gender(char gender)
        {
            this.gender=gender;
        }
        /**
         * return person sex
         * @return 
         */
        public char get_gender()
        {
            return this.gender;
        }  
        /**
         * set person date of birth
         * @param dateOfBirth new date
         */
        public void set_dateOfBirth(Date dateOfBirth)
        {
            this.dateOfBirth=dateOfBirth;
        }
        /**
         *  get date of birth
         * @return 
         */
        public Date get_dateOfBirth()
        {
            return this.dateOfBirth;
        }        
        /**
         *  set address
         * @param address new address
         */
        public void set_address(String address)
        {
            this.address=address;
        }
        /**
         *  get address
         * @return 
         */
        public String get_address()
        {
            return this.address;
        }
        /**
         *  set natInsceNo
         * @param natInsceNo new natInsceNo
         */        
        public void set_natInsceNo(String natInsceNo)
        {
            this.natInsceNo=natInsceNo;
        }
        /**
         * get natInsceNo
         * @return 
         */
        public String get_natInsceNo()
        {
            return this.natInsceNo;
        }
        /**
         *  set phone number
         * @param phoneNo new phoneNo
         */          
        public void set_phoneNo(String phoneNo)
        {
            this.phoneNo=phoneNo;
        }
        /**
         *  get phone number
         * @return 
         */
        public String get_phoneNo()
        {
            return this.phoneNo;
        }        
	public String toString()
	{
		String output = "";
		
		output = " Name: " + name + " Gender: " + gender +  " Date Of Birth: " + dateOfBirth
		+ "address: " + address + "natInsceNo: "
		+ natInsceNo + " phoneNo: " + phoneNo;
				
		return output;
	}
}
