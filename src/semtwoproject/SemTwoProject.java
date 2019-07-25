
package semtwoproject;
import java.util.Scanner;

public class SemTwoProject {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int option ;
        
            try{
        do{
            /*main menu selector*/
            System.out.println("***MAIN MENU***");
            System.out.println("1: Enter into Departments");
            System.out.println("2: Enter into Employees");
            System.out.println("3: Enter into Supplies");
            System.out.println("4: Enter into Patients");
            System.out.println("5: Enter into Search");
            System.out.println("6: Enter into Reports");
            option = input.nextInt();
            try{
                if(option ==1){
                    /*menu asking user for what to do*/
                    System.out.println("Choose what you want to do");
                    System.out.println("1: Add to departments");
                    System.out.println("2: Select from departments");
                    System.out.println("3: Delete from departments");
                    System.out.println("4: Update departments");
                    option = input.nextInt();
                    /*calling the methods from departments */
                    try{
                        switch(option){
                            case 1: Department objAdd = new Department();
                                    objAdd.Add();
                                break;
                            case 2:Department objSelect = new Department();
                                    objSelect.Select();
                                break;
                            case 3:Department objDelete = new Department();
                                    objDelete.Delete();
                                break;
                            case 4:Department objUpdate = new Department();
                                    objUpdate.Update();
                                break;
                            default:System.out.println("Enter a value between  1 and 4");
                    }
                }catch(Exception e){
                    System.out.println("Wrong input type"+e.getMessage());
                    }
                }
            }catch(Exception e){
                System.out.println("Wrong input type"+e.getMessage());
                }
            try{
                if(option ==2){
                    /*menu asking user for what to do*/
                    System.out.println("Choose what you want to do");
                    System.out.println("1: Add to Employees");
                    System.out.println("2: Select from Employees");
                    System.out.println("3: Update to Employees");
                    System.out.println("4: Delete from Employees");
                    option = input.nextInt();
                    /*calling the methods from employees */
                    try{
                        switch(option){
                            case 1: employees objAdd = new employees();
                                    objAdd.Add();
                                break;
                            case 2:employees objSelect = new employees();
                                    objSelect.Select();
                                break;
                            case 3: employees objupdate = new employees();
                                    objupdate.Update();
                                break;
                            case 4:employees objdelete = new employees();
                                    objdelete.Delete();
                                break;
                }
                    }catch(Exception e){
                        System.out.println("Wrong input type"+e.getMessage());
                    }
                }
                }catch(Exception e){
                    System.out.println("Wrong input type"+e.getMessage());
                    }
            try{
                if(option ==3){
                    /*menu asking user for what to do*/
                    System.out.println("Choose what you want to do");
                    System.out.println("1: Add to Supplies");
                    System.out.println("2: Select from Supplies");
                    System.out.println("3: Update to Supplies");
                    System.out.println("4: Delete from Supplies");
                    System.out.println("5: To retrieve supply");
                    option = input.nextInt();
                    /*calling the methods from Supplies*/
                    try{
                        switch(option){
                            case 1: suplies objAdd = new suplies();
                                    objAdd.Add();
                                break;
                            case 2:suplies objSelect = new suplies();
                                    objSelect.Select();
                                break;
                            case 3: suplies objupdate = new suplies();
                                    objupdate.Update();
                                break;
                            case 4:suplies objdelete = new suplies();
                                    objdelete.Delete();
                                break;
                            case 5:suplies objUsedUpdate = new suplies();
                                    objUsedUpdate.UsedUpdate();
                                break;
                    }
                    }catch(Exception e){
                        System.out.println("Wrong input type"+e.getMessage());
                }
                }
                }catch(Exception e){
                    System.out.println("Wrong input type"+e.getMessage());
                }
            try{
                if(option ==4){
                    /*menu asking user for what to do*/
                    System.out.println("Choose what you want to do");
                    System.out.println("1: Add to patients");
                    System.out.println("2: Select from patients");
                    System.out.println("3: Update to patients");
                    System.out.println("4: Delete from patients");
                    System.out.println("5: Record patients treatment details");
                    option = input.nextInt();
                    /*calling the methods from patients*/
                    try{
                    switch(option){
                        case 1: patients objAdd = new patients();
                                objAdd.Add();
                            break;
                        case 2:patients objSelect = new patients();
                                objSelect.Select();
                            break;
                        case 3: patients objupdate = new patients();
                                objupdate.Update();
                            break;
                        case 4:patients objdelete = new patients();
                                objdelete.Delete();
                            break;
                        case 5:patients objupdatepts = new patients();
                                objupdatepts.UpdatePts();
                            break;
                }
                }catch(Exception e){
                    System.out.println("Wrong input type"+e.getMessage());
                }
                }
                }catch(Exception e){
                    System.out.println("Wrong input type"+e.getMessage());
                }
            try{
                if(option ==5){
                    /*menu asking user for what to do*/
                    System.out.println("Choose what you want to do");
                    System.out.println("1: Search specific supplies");
                    System.out.println("2: Select all supplies available");
                    System.out.println("3: Select all supplies used and by whom");
                    option = input.nextInt();
                    try{
                        /*calling the methods from search*/
                        switch(option){
                            case 1: search objsearch = new search();
                                    objsearch.suppliesSearch();
                                break;
                            case 2:search objMysearch = new search();
                                    objMysearch.Select();
                                break;
                            case 3: search myused = new search();
                                    myused.suppliesUsed();
                                break;
                    }
                }catch(Exception e){
                    System.out.println("Wrong input type"+e.getMessage());
                }
                }
                }catch(Exception e){
                    System.out.println("Wrong input type"+e.getMessage());
                }
            try{
                if(option ==6){
                    /*menu asking user for what to do*/
                    System.out.println("Choose what you want to do");
                    System.out.println("1: Generate report on sickness trends");
                    System.out.println("2: Generate report on specified patient treatment history");
                    System.out.println("3: Generate report on number of patients treated and by which doctor");
                    System.out.println("4: Generate report on number of Supplies used (by category)");
                    System.out.println("5: Generate report on number of Supplies Available");
                    System.out.println("6: Generate report on number of Staff who have used Supplies");
                    option = input.nextInt();
                    /*calling the methods from report*/
                    try{
                        switch(option){
                            case 1: report objSickness = new report();
                                    objSickness.Sickness();
                                break;
                            case 2:report objtreatmentSelection = new report();
                                    objtreatmentSelection.treatmentSelection();
                                break;
                            case 3: report objtreatedPatients = new report();
                                    objtreatedPatients.treatedPatients();
                                break;
                            case 4: report objsupplyused = new report();
                                    objsupplyused.suppliesUsed();
                                break;
                            case 5: report objsupplyavailable = new report();
                                    objsupplyavailable.SuppliesAvailable();
                                break;
                            case 6: report objsupplyusedby = new report();
                                    objsupplyusedby.SuppliesUsedBy();
                                break;    
                    }
                    }catch(Exception e){
                        System.out.println("Wrong input type"+e.getMessage());
                    }
                }
                }catch(Exception e){
                    System.out.println("Wrong input type"+e.getMessage());
                }
        }while(option!=12);
        
            }catch(Exception e){
                    System.out.println("Wrong input type is not a number");
                }
    }
    
}