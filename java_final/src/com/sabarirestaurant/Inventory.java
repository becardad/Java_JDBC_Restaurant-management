package com.sabarirestaurant;

import java.util.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class Inventory {
	Statement stmt;
	ResultSet rs;
	String qry=null;
	Dbutil db=new Dbutil();
	Connection con;
    List<restaurant> list = new ArrayList<>();
    int count=0;
    public void add(restaurant r) {
       
    	try
    	{
    		Connection con=db.getDBConnection();
    		stmt=con.createStatement();
    		qry=("insert into orders(table_no,name,food,price) values('"+r.getTable_no()+"','"+r.getName()+"','"+r.getFood()+"','"+r.getPrice()+"')");
    		stmt.executeUpdate(qry);
    	}
    	catch(Exception ex)

      	 {

      		 System.out.println(ex.getMessage());

      	 }
    	
    }

    public void show() {
       
    		try {

       		 Dbutil db =new Dbutil();

       		 con=db.getDBConnection();

       		 stmt=con.createStatement();

       		 rs=stmt.executeQuery("select * from orders");

       		 while(rs.next())

       			 System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));

       		 }

       	 catch(Exception ex)

       	 {

       		 System.out.println(ex.getMessage());

       	 }

    	}
    

    public restaurant search(String table_no) {
        for (restaurant r : list) {
            if (table_no.equals(r.getTable_no())) {
                return r;
            }
        }
        return null;
    }

    public void update(restaurant r) {

    	try
    	{
    		con=db.getDBConnection();
    		stmt=con.createStatement();
    		count=stmt.executeUpdate("update orders set price='"+r.getPrice()+"'where table_no='"+r.getTable_no()+"'");
    		System.out.println("Updated successfully");
    	}
    	catch(Exception ex)

     	 {

     		 System.out.println(ex.getMessage());

     	 }
    }

    public void remove(String table_no)
    {
    	try
    	{
    		con=db.getDBConnection();
    		stmt=con.createStatement();
    		qry="delete from orders where table_no='"+table_no+"'";
    		count=stmt.executeUpdate(qry);
    		if(count==1)
    			System.out.println("Deleted successfully");
    	}
    	catch(Exception ex)

    	 {

    		 System.out.println(ex.getMessage());

    	 }
    }

    
}
