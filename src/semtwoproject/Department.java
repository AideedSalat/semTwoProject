
package semtwoproject;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author j.gakunga
 */
public class Department {
    /*method to add data to the database*/
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
        //Asks for user input
        System.out.println("Enter the department name");
        String name = input.next();
        System.out.println("Enter the Employee ID of the department head");
        String head = input.next();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=DriverManager.getConnection(connectionURL);
            
            st=con.createStatement();
           int i = st.executeUpdate("INSERT INTO Departments(dept_name, emp_id) VALUES('"+name+"', '"+head+"')");//sql statement to querry database
            if(i>0){
                System.out.println("Insert successfull");
            }
                
            
        }catch(Exception e){
            System.out.println("Encountered an error while inserting "+e.getMessage());
        }
    }
    /*method to select data from database*/    
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
                String sql =("Select dept_id, dept_name from Departments");//sql statement to querry database
                rs = st.executeQuery(sql);
                while(rs.next()){
                    System.out.println(rs.getString("dept_id")+"|"+ rs.getString("dept_name"));
                    
                }
            }catch(Exception e){
            System.out.println("Encountered an error while inserting "+e.getMessage());
        }
            
        }
        /*method to delete data from the database*/
        public void Delete(){
            Scanner input = new Scanner(System.in);
            //Asks for user input
            System.out.println("Enter the ID of the Department you want to delete");
            int id = input.nextInt();
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
                int i = st.executeUpdate("DELETE FROM Departments WHERE dept_id ="+id);//sql statement to querry database
                if(i>0){
                    System.out.println("You have successfully deleted ");
                }
                
            }catch(Exception e){
                System.out.println("Encountered an error while deleting " +e.getMessage());
            }
        }
        /*method to update the already existing columns of the database*/
        public void Update(){
            Scanner input = new Scanner(System.in);
            //Asks for user input
            System.out.println("Enter the ID of the Department you want to update");
            int id = input.nextInt();
            System.out.println("Enter the new value of Department name");
            String name = input.next();
            System.out.println("Enter the new value of Department head");
            String head = input.next();
            Connection con;
            Statement st;
            //connection string
            String connectionURL = "jdbc:sqlserver://SQLSVR:1433;"+
                "database=Hospital;user=sa;password=Edulink2015";
            /*try and catch block for exception and error handling*/
            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection(connectionURL);
                st = con.createStatement();
                int i = st.executeUpdate("UPDATE Departments SET dept_name ='"+name+"', dept_head ='"+head+"' WHERE dept_id ="+id);//sql statement to querry database
                
                System.out.println("You have successfully updated ");
                
            }catch(Exception e){
                System.out.println("Encountered an error while updating " +e.getMessage());
            }
        }
}
