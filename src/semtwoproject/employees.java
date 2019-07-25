
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
public class employees {
        public void Add(){
        Connection  con;
        Statement st;
        ResultSet rs;
        Scanner input = new Scanner(System.in);
        //This is the connection string
        String connectionURL = "jdbc:sqlserver://SQLSVR:1433;"+
                "database=Hospital;user=sa;password=Edulink2015";
        
        //Declare jdbc objects
        /*try and catch block for exception handling*/
        try{
            //Asks for user input
            System.out.println("Enter the employee's first name");
            String fname = input.next();
            System.out.println("Enter the employee's second name");
            String sname = input.next();
            System.out.println("Enter the employee's last name");
            String lname = input.next();
            System.out.println("Enter the employee's salary");
            String salary = input.next();
            System.out.println("Enter the employee's Department Id");
            String deptnament = input.next();
            System.out.println("Enter the employee's phone number");
            String phone = input.next();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=DriverManager.getConnection(connectionURL);
            
            st=con.createStatement();
            int i = st.executeUpdate("INSERT INTO Employees(first_name, second_name, last_name, salary, dept_id, phone_number) VALUES('"+fname+"', '"+sname+"', '"+lname+"', '"+salary+"', '"+deptnament+"', '"+phone+"')");//sql statement to querry the database
            if(i>0){
                System.out.println("Insert successfull");
            }
                
            
        }catch(Exception e){
            System.out.println("Encountered an error while inserting "+e.getMessage());
        }
    }
        public void Select(){
            Connection  con;
            Statement st;
            ResultSet rs;
            String connectionURL = "jdbc:sqlserver://SQLSVR:1433;"+
                "database=Hospital;user=sa;password=Edulink2015";
            /*try and catch block for exception handling*/
            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con=DriverManager.getConnection(connectionURL);
                st=con.createStatement();
                String sql =("Select * from Employees");//sql statement to querry the database
                rs = st.executeQuery(sql);
                while(rs.next()){
                    System.out.println(rs.getString("first_name")+"|"+ rs.getString("second_name")+"|"+rs.getString("last_name")+ "|" + rs.getString("salary")+"|"+ rs.getString("dept_id")+"|"+ rs.getString("phone_number"));//displays result of sql querry
                    
                }
            }catch(Exception e){
            System.out.println("Encountered an error while inserting "+e.getMessage());
        }
            
        }
        public void Delete(){
            Scanner input = new Scanner(System.in);
            //Asks for user input
            System.out.println("Enter the ID of the Department you want to delete");
            int id = input.nextInt();
            Connection con;
            Statement st;
            
            String connectionURL = "jdbc:sqlserver://SQLSVR:1433;"+
                "database=Hospital;user=sa;password=Edulink2015";
            /*try and catch block for exception handling*/
            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection(connectionURL);
                st = con.createStatement();
                int i = st.executeUpdate("DELETE FROM Employees WHERE emp_id ="+id);//sql statement to querry the database
                
                    System.out.println("You have successfully deleted ");
                
                
            }catch(Exception e){
                System.out.println("Encountered an error while deleting " +e.getMessage());
            }
        }
        
        public void Update(){
            Scanner input = new Scanner(System.in);
            /*Asks for input from the user*/
            System.out.println("Enter the Employee's first name");
            String fname = input.next();
            System.out.println("Enter the Employee's second name");
            String sname = input.next();
            System.out.println("Enter the Employee's last name");
            String lname = input.next();
            System.out.println("Enter the Employee's salary");
            String salary = input.next();
            System.out.println("Enter the Employee's Id");
            String deptnament = input.next();
            System.out.println("Enter the Employee's Email");
            String email = input.next();
            System.out.println("Enter the Employee's phone number");
            String phone = input.next();
            System.out.println("Enter the Employee's id you want to update");
            String id = input.next();
            Connection con;
            Statement st;
            
            String connectionURL = "jdbc:sqlserver://SQLSVR:1433;"+
                "database=Hospital;user=sa;password=Edulink2015";
            /*try and catch block for exception handling*/
            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection(connectionURL);
                st = con.createStatement();
                int i = st.executeUpdate("UPDATE Employees SET first_name ='"+fname+"', second_name ='"+sname+"', last_name ='"+lname+"', salary ='"+salary+"' , dept_id ='"+deptnament+"', email ='"+email+"' WHERE emp_id ="+id);//sql statement to querry the database
                
                System.out.println("You have successfully updated ");
                
            }catch(Exception e){
                System.out.println("Encountered an error while updating " +e.getMessage());
            }
        }
}
