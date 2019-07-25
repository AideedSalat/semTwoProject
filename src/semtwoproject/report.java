
package semtwoproject;
import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author J.gakunga
 */
public class report {
    /*method for selecting recurring sicknesses*/
    public void Sickness() {
        Connection  con;
        Statement st;
        ResultSet rs;
        /*connection string*/
        String connectionURL = "jdbc:sqlserver://SQLSVR:1433;"+
                "database=Hospital;user=sa;password=Edulink2015";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=DriverManager.getConnection(connectionURL);
            st=con.createStatement();
            String sql =("SELECT diagnosis FROM Patients WHERE diagnosis IS NOT NULL");//sql statement to choose diagnosis column from patients
            rs = st.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString("diagnosis"));//displays the result of the search
                    
            }
        }
        catch(Exception e){
            System.out.println("Encountered an error while selecting "+e.getMessage());//exception handling
        } 
    }
    /*method to display patient treatment history*/
    public void treatmentSelection(){
       Scanner input = new Scanner(System.in);//for input
            
        System.out.println("Enter the ID of the patient");//asks for patient id
        int id = input.nextInt();
        Connection con;
        Statement st;
        ResultSet rs;
        /*control string*/    
        String connectionURL = "jdbc:sqlserver://SQLSVR:1433;"+
                "database=Hospital;user=sa;password=Edulink2015";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionURL);
            st = con.createStatement();
            String sql=("SELECT treatment, diagnosis FROM Patients WHERE pts_id ="+id);//selects using patient id
            rs = st.executeQuery(sql);
            
                while(rs.next()){
                    System.out.println(rs.getString("diagnosis") + "|" + rs.getString("treatment"));
                    
                }
                
        }catch(Exception e){
            System.out.println("Encountered an error while retrieving " +e.getMessage());
        }
 
    }
    /*method to select supplies from Supplies table*/
    public void Select(){
        Connection  con;
        Statement st;
        ResultSet rs;
        /*control string*/
        String connectionURL = "jdbc:sqlserver://SQLSVR:1433;"+
                "database=Hospital;user=sa;password=Edulink2015";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=DriverManager.getConnection(connectionURL);
            st=con.createStatement();
            String sql =("Select supply_name FROM Supplies");
            rs = st.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString("supply_name"));
                    
            }
        }
        catch(Exception e){
            System.out.println("Encountered an error while selecting "+e.getMessage());//exception handling statement
        }
    }
    /*method to generate report on treated patients*/
    public void treatedPatients(){
        Connection  con;
        Statement st;
        ResultSet rs;
        /*connection string*/
        String connectionURL = "jdbc:sqlserver://SQLSVR:1433;"+
                "database=Hospital;user=sa;password=Edulink2015";
        /*try and catch block for exception handling*/
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=DriverManager.getConnection(connectionURL);
            st=con.createStatement();
            String sql =("SELECT emp_id, COUNT(pts_id) AS count FROM Patients WHERE emp_id IS NOT NULL GROUP BY emp_id");
            rs = st.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString("emp_id")+"|"+  rs.getString("count"));//displays sql search result 
            }
        }
        catch(Exception e){
            System.out.println("Encountered an error while selecting "+e.getMessage());
        }
            
    }
    /*method to display supply used by category*/
    public void suppliesUsed(){
        Connection  con;
        Statement st;
        ResultSet rs;
        //connection string
        String connectionURL = "jdbc:sqlserver://SQLSVR:1433;"+
                "database=Hospital;user=sa;password=Edulink2015";
        /*try and catch block for exception handling*/
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=DriverManager.getConnection(connectionURL);
            st=con.createStatement();
            String sql =("SELECT supply_name, category, supply_used FROM Supplies ");
            rs = st.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString("category")+"|"+  rs.getString("supply_name")+"|"+  rs.getString("supply_used"));
            }
        }
        catch(Exception e){
            System.out.println("Encountered an error while selecting "+e.getMessage());
        }
    }
    
    public void SuppliesAvailable(){
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
            String sql =("SELECT supply_name, category, supply_quantity FROM Supplies ");
            rs = st.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString("category")+"|"+  rs.getString("supply_name")+"|"+  rs.getString("supply_quantity"));
            }
        }
        catch(Exception e){
            System.out.println("Encountered an error while selecting "+e.getMessage());
        }
    }
        
        
        public void SuppliesUsedBy(){
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
            String sql =("SELECT  supply_name, first_name FROM Supplies INNER JOIN Employees ON Supplies.emp_id = Employees.emp_id; ");
            rs = st.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString("supply_name")+"|"+  rs.getString("first_name"));
            }
        }
        catch(Exception e){
            System.out.println("Encountered an error while selecting "+e.getMessage());
        }
    }
}

