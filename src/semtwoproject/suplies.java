/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semtwoproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author j.gakunga
 */
public class suplies {
        /*Adds content to the Supplies */
        public void Add(){
        Connection  con;
        Statement st;
        ResultSet rs;
        Scanner input = new Scanner(System.in);
        //This is the connection string
        String connectionURL = "jdbc:sqlserver://SQLSVR:1433;"+
                "database=Hospital;user=sa;password=Edulink2015";
        
        //Declare jdbc objects
        /*try and catch block for exception and error handling*/
        try{
        /*Asks for user input*/
        System.out.println("Enter the suppilies supply name");
        String name = input.nextLine();
        System.out.println("Enter the supplies supply quantity");
        String quantity = input.nextLine();
        System.out.println("Enter the supplies employee id");
        String employee = input.nextLine();
        System.out.println("Enter the department id");
        String departmemt = input.nextLine();
        System.out.println("Enter the supplies quantity used");
        String used = input.nextLine();
        System.out.println("Enter the category of the supply");
        String category = input.nextLine();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=DriverManager.getConnection(connectionURL);
            
            st=con.createStatement();
            st.executeUpdate("INSERT INTO Supplies(supply_name, supply_quantity, emp_id, dept_id, supply_used, category) VALUES('"+name+"', '"+quantity+"', '"+employee+"', '"+departmemt+"', '"+used+"', '"+category+"')");
            
                
            
        }catch(Exception e){
            System.out.println("Encountered an error while inserting "+e.getMessage());
        }
    }
        /*selects from Supplies table*/
        public void Select(){
            Connection  con;
            Statement st;
            ResultSet rs;
            //This is the connection string
            String connectionURL = "jdbc:sqlserver://SQLSVR:1433;"+
                "database=Hospital;user=sa;password=Edulink2015";
            /*try and catch block for exception and error handling*/
            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con=DriverManager.getConnection(connectionURL);
                st=con.createStatement();
                String sql =("Select * from Supplies");//sql statement to querry database
                rs = st.executeQuery(sql);
                while(rs.next()){
                    System.out.println(rs.getString("supply_name")+"|"+ rs.getInt("supply_quantity")+"|"+rs.getString("emp_id") +"|"+ rs.getString("dept_id")+"|"+ rs.getString("supply_used"));
                    
                }
            }catch(Exception e){
            System.out.println("Encountered an error while selecting"+e.getMessage());
        }
            
        }
        /*deletes content from table*/
        public void Delete(){
            Scanner input = new Scanner(System.in);
            /*Asks for user input*/
            System.out.println("Enter the ID of the Supply you want to delete");
            int id = input.nextInt();
            Connection con;
            Statement st;
            
            String connectionURL = "jdbc:sqlserver://SQLSVR:1433;"+
                "database=Hospital;user=sa;password=Edulink2015";
            /*try and catch block for exception and error handling*/
            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection(connectionURL);
                st = con.createStatement();
                int i = st.executeUpdate("DELETE FROM Supplies WHERE supply_id ="+id);
                if(i>0){
                    System.out.println("You have successfully deleted ");
                }
                
            }catch(Exception e){
                System.out.println("Encountered an error while deleting " +e.getMessage());
            }
        }
        /*updates supplies table*/
        public void Update(){
            Scanner input = new Scanner(System.in);
            /*Asks for user input*/
            System.out.println("Enter the suppilies supply name");
            String name = input.next();
            System.out.println("Enter the supplies supply quantity");
            String quantity = input.next();
            System.out.println("Enter the supplies employee id");
            String employee = input.next();
            System.out.println("Enter the department id");
            String departmemt = input.next();
            System.out.println("Enter the supplies quantity used");
            String used = input.next();
            System.out.println("Enter the supplyes's id you want to update");
            String id = input.next();
            Connection con;
            Statement st;
            //This is the connection string
            String connectionURL = "jdbc:sqlserver://SQLSVR:1433;"+
                "database=Hospital;user=sa;password=Edulink2015";
            /*try and catch block for exception and error handling*/
            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection(connectionURL);
                st = con.createStatement();
                int i = st.executeUpdate("UPDATE Supplies SET supply_name ='"+name+"', supply_quantity ='"+quantity+"', emp_id ='"+employee+"', dept_id ='"+departmemt+"' , supply_used ='"+used+"'WHERE supply_id ="+id);//sql statement to querry database
                
                System.out.println("You have successfully updated ");
                
            }catch(Exception e){
                System.out.println("Encountered an error while updating " +e.getMessage());
            }
            
        }
        /*updates supplies table*/
        public void UsedUpdate(){
            Scanner input = new Scanner(System.in);
            
            
            /*Asks for user input*/
            System.out.println("Enter the your employee id");
            int employee = input.nextInt();
            System.out.println("Enter the supplies you need");
            int used = input.nextInt();
            System.out.println("Enter the supplyes's id you want to take");
            int id = input.nextInt();
            Connection con;
            Statement st;
            ResultSet rs;
            //This is the connection string
            String connectionURL = "jdbc:sqlserver://SQLSVR:1433;"+
                "database=Hospital;user=sa;password=Edulink2015";
            /*try and catch block for exception and error handling*/
            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection(connectionURL);
                st = con.createStatement();
                String SQL =("SELECT * FROM Supplies");
                rs = st.executeQuery(SQL);
                while(rs.next()){
                    System.out.println(rs.getInt("supply_used"));//sql statement to querry database
                    int a = rs.getInt("supply_used");
                    int b = rs.getInt("supply_quantity");
                    
                    Statement qs;
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection(connectionURL);
                    qs = con.createStatement();
                    if(b==0){
                        System.out.println("There are no supplies");
                    }
                    else{
                        int c = a+used;
                        int d = b - used;
                        String sql =("UPDATE Supplies SET emp_id ='"+employee+"', supply_quantity='"+d+"',supply_used ='"+c+"'WHERE supply_id ="+id);//sql statement to querry database
                        qs.executeUpdate(sql);
                    }
                }
                
                System.out.println("You have successfully updated ");
                
            }catch(Exception e){
                System.out.println("Encountered an error while updating " +e.getMessage());
            }
            
        }
}
