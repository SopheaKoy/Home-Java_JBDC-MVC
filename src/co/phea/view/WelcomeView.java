package co.phea.view;

import co.phea.dao.EmployeeImp;
import co.phea.model.Employee;

public class WelcomeView {
    EmployeeImp employeeImp = new EmployeeImp();
    public void viewSelect(){
        employeeImp.selectSql();
    }
    public void viewSelectById(){
        employeeImp.selectById();
    }
    public void viewSelectByName(){
        employeeImp.selectName();
    }
    public void viewDeleteByID(){
        employeeImp.deleteSql();
    }
    public void viewInsert(Employee employee){employeeImp.insertSql(employee);}
    public void viewUpdate(){employeeImp.updateSql();}
}
