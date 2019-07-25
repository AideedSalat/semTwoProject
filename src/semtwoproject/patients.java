
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
public class patients {
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
            System.out.println("Enter the Patient's first name");
            String fname = input.next();
            System.out.println("Enter the Patient's second name");
            String sname = input.next();
            System.out.println("Enter the Patient's last name");
            String lname = input.next();
            System.out.println("Enter the Patient's phone number");
            String phone = input.next();
            System.out.println("Enter the Patient's  age");
            String age = input.next();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=DriverManager.getConnection(connectionURL);
            
            st=con.createStatement();
            int i = st.executeUpdate("INSERT INTO Patients(first_name, second_name, last_name, phone_number, age) VALUES('"+fname+"', '"+sname+"', '"+lname+"', '"+phone+"', '"+age+"')");
            
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
            //This is the connection string
            String connectionURL = "jdbc:sqlserver://SQLSVR:1433;"+
                "database=Hospital;user=sa;password=Edulink2015";
            /*try and catch block for exception handling*/
            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con=DriverManager.getConnection(connectionURL);
                st=con.createStatement();
                String sql =("Select * from Patients");
                rs = st.executeQuery(sql);
                while(rs.next()){
                    System.out.println(rs.getString("pts_id")+"|"+rs.getString("first_name")+"|"+ rs.getString("second_name")+"|"+rs.getString("symptoms")+"|"+rs.getString("diagnosis")+"|"+rs.getString("treatment")+"|"+ rs.getString("age")+"|"+rs.getString("emp_id")+"|"+rs.getString("issue_date")+"|"+ rs.getString("return_date"));
                    
                }
            }catch(Exception e){
            System.out.println("Encountered an error while inserting "+e.getMessage());
        }
            
        }
        public void Delete(){
            Scanner input = new Scanner(System.in);
            
            System.out.println("Enter the ID of the patient you want to delete");
            int id = input.nextInt();
            Connection con;
            Statement st;
            //This is the connection string
            String connectionURL = "jdbc:sqlserver://SQLSVR:1433;"+
                "database=Hospital;user=sa;password=Edulink2015";
            /*try and catch block for exception handling*/
            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection(connectionURL);
                st = con.createStatement();
                int i = st.executeUpdate("DELETE FROM Patients WHERE pts_id ="+id);
                if(i>0){
                    System.out.println("You have successfully deleted ");
                }
                
            }catch(Exception e){
                System.out.println("Encountered an error while deleting " +e.getMessage());
            }
        }
        
        public void Update(){
            Scanner input = new Scanner(System.in);
            
            System.out.println("Enter the ID of the patient you want to update");
            int id = input.nextInt();
            
            System.out.println("Enter the Patient's first name");
            String fname = input.next();
            System.out.println("Enter the Patient's second name");
            String sname = input.next();
            System.out.println("Enter the Patient's last name");
            String lname = input.next();
            System.out.println("Enter the Patient's phone number");
            String phone = input.next();
            System.out.println("Enter the Patient's  age");
            String age = input.next();
            Connection con;
            Statement st;
            //This is the connection string
            String connectionURL = "jdbc:sqlserver://SQLSVR:1433;"+
                "database=Hospital;user=sa;password=Edulink2015";
            
            /*try and catch block for exception handling*/
            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection(connectionURL);
                st = con.createStatement();
                int i = st.executeUpdate("UPDATE Patients SET first_name ='"+fname+"', second_name ='"+sname+"', last_name ='"+lname+"', phone_number='"+phone+"', age='"+age+"' WHERE pts_id ="+id);
                
                System.out.println("You have successfully updated ");
                
            }catch(Exception e){
                System.out.println("Encountered an error while updating " +e.getMessage());
            }
        }
        public void UpdatePts(){
            Scanner input = new Scanner(System.in);
            
            System.out.println("Enter the ID of the patient you want to update");
            int id = input.nextInt();
            
            System.out.println("Enter the Patient's  doctor id");
            String docid = input.next();
            System.out.println("Enter the Patient's  symptoms");
            String symptoms = input.next();
            symptoms += input.nextLine();
            System.out.println("Enter the Patient's diagnosis");
            String diagnosis = input.next();
            diagnosis += input.nextLine();
            System.out.println("Enter the Patient's  treatment");
            String treatment = input.next();
            treatment += input.nextLine();
            System.out.println("Enter the Patient's  issue date");
            String isdate = input.next();
            System.out.println("Enter the Patient's  return date");
            String retdate = input.next();
            Connection con;
            Statement st;
            //This is the connection string
            String connectionURL = "jdbc:sqlserver://SQLSVR:1433;"+
                "database=Hospital;user=sa;password=Edulink2015";
            /*try and catch block for exception handling*/
            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection(connectionURL);
                st = con.createStatement();
                int i = st.executeUpdate("UPDATE Patients SET treatment='"+treatment+"', diagnosis='"+diagnosis+"', issue_date='"+isdate+"', return_date='"+retdate+"', symptoms='"+symptoms+"', emp_id='"+docid+"' WHERE pts_id ="+id);
                
                System.out.println("You have successfully updated ");
                
            }catch(Exception e){
                System.out.println("Encountered an error while updating " +e.getMessage());
            }
        }
}
