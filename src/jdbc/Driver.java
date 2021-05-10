package jdbc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class Driver {

  @SuppressWarnings("null")
public static void main(String[] args) throws SQLException, IOException {
	  String table = ""; 
	  
      try {
        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/records", "root",
          "sairus");

        try {
          Statement myStmt = myConn.createStatement();

          try {
            ResultSet myRs = myStmt.executeQuery("SELECT * FROM records.people");
            Html html = new Html(); 
            table = Html.open("html")+Html.open("head")+Html.getTitle("Generator")+Html.close("head")+Html.open("body")+Html.getLabel("Table")+Html.open("table")+Html.open("tr")+Html.open("th") + "ID" + Html.close("th")+Html.open("th") + "FIRST_NAME" + Html.close("th")+ Html.open("th") + "LAST_NAME" + Html.close("th")+Html.open("th") + "PHONE_NO" + Html.close("th")+Html.open("th") + "CITY" + Html.close("th")+Html.close("tr")+Html.close("body")+Html.close("html");

            while (myRs.next()) {
            	
            table+= Html.open("tr")+Html.open("td")+myRs.getString("ID")+Html.close("td")+Html.open("td")+myRs.getString("FIRST_NAME")+Html.close("td")+Html.open("td")+myRs.getString("LAST_NAME")+Html.close("td")+Html.open("td")+myRs.getString("PHONE_NO")+Html.close("td")+Html.open("td")+myRs.getString("CITY")+Html.close("td")+Html.close("tr"); 
              System.out.println(myRs.getString("ID") + ", " + myRs.getString("FIRST_NAME") + ", " +
                myRs.getString("LAST_NAME") + ", " + myRs.getString("PHONE_NO") + ", " +
                myRs.getString("CITY"));
               
            }table+=Html.close("table"); 
            
          } 
          catch(Exception e1){
          	System.out.print("Exception 1`");
           }
        }
        catch(Exception e2){
          	System.out.print("Exception 2`");
           }
      }
      
          finally {
        	  System.out.println("finally block");
          }

      		File file = new File("table.html"); 
            try {
            BufferedWriter wr = new BufferedWriter (new FileWriter(file));
    		wr.write(table);
    	    wr.close();
            ResultSet myRs = null;
			myRs.close();
			Statement myStmt = null;
			myStmt.close();
            Connection myConn = null;
			myConn.close();
            } 

            catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
            }
            
        
         }
       
     }
   
		


