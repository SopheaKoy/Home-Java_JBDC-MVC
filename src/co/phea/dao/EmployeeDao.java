package co.phea.dao;

import co.phea.model.Employee;

public interface EmployeeDao {
    void insertSql(Employee employee);
    void updateSql();
    void deleteSql();
    void selectById();
    void selectSql();
    void selectName();
}
