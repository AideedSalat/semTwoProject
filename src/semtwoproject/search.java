
package semtwoproject;
import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author J.gakunga
 */
public class search {
    /*method to search for a specific supply*/
    public void suppliesSearch(){
       Scanner input = new Scanner(System.in);
        //Asks for user input   
        System.out.println("Enter the name of the Supply you want to search for");
        String keyword = input.next();
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
            String sql=("SELECT supply_name, supply_quantity FROM Supplies WHERE supply_name like '%"+keyword+"%'");//sql statement to querry database
            rs = st.executeQuery(sql);
            
                while(rs.next()){
                    System.out.println(rs.getString("supply_name")+"|"+rs.getString("supply_name"));
                    
                }
                
        }catch(Exception e){
            System.out.println("Encountered an error while retrieving " +e.getMessage());
        }
 
    }
    
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
            String sql =("Select supply_name, supply quantity FROM Supplies");//sql statement to querry database
            rs = st.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString("supply_name")+"|"+rs.getString("supply_quantity"));
                    
            }
        }
        catch(Exception e){
            System.out.println("Encountered an error while selecting "+e.getMessage());
        }
            
    }
    
    public void suppliesUsed(){
        Connection  con;
        Statement st;
        ResultSet rs;
        //connection string
        String connectionURL = "jdbc:sqlserver://SQLSVR:1433;"+
                "database=Hospital;user=sa;password=Edulink2015";
        /*try and catch block for exception and error handling*/
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=DriverManager.getConnection(connectionURL);
            st=con.createStatement();
            String sql =("SELECT supply_name, supply_used, first_name FROM Supplies INNER JOIN Employees ON Supplies.emp_id = Employees.emp_id;");//sql statement to querry database
            rs = st.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString("supply_name")+"|"+ rs.getString("supply_used")+"|"+ rs.getString("first_name"));
                    
            }
        }
        catch(Exception e){
            System.out.println("Encountered an error while selecting "+e.getMessage());
        }
            
    } 
}
