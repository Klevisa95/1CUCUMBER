package utils;

import pages.AddEmployeePage;
import pages.DashboarPage;
import pages.EmployeeSearchPage;
import pages.LoginPage;

public class PageInitializer { //use this class to reuse code to use them in specific classes so you don't have to write long steps

    public static LoginPage loginPage;
    public static DashboarPage dashboardPage;
    public static EmployeeSearchPage employeeSearchPage;
    public static AddEmployeePage addEmployeePage;



    public static void initializePageObjects(){

        loginPage=new LoginPage();
        dashboardPage=new DashboarPage();
        employeeSearchPage=new EmployeeSearchPage();
        addEmployeePage=new AddEmployeePage();




    }

}


