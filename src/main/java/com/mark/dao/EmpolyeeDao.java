package com.mark.dao;

import com.mark.pojo.Department;
import com.mark.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmpolyeeDao {

    private  static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;

    static  {
        employees = new HashMap<Integer, Employee>();

        employees.put(1001, new Employee(1001, "Mark", "Asadas@gmail.com", 0, new Department(101,"Math")));
        employees.put(1002, new Employee(1002, "Edward", "Bsadas@gmail.com", 1, new Department(102,"CMPT")));
        employees.put(1003, new Employee(1003, "Miko", "Csadas@gmail.com", 0, new Department(103,"Physics")));
        employees.put(1004, new Employee(1004, "Neil", "Dsadas@gmail.com", 1, new Department(104,"Eco")));
    }


    //add empolyee
    private static Integer initId = 1005;

    public void save(Employee employee){
        if(employee.getId() == null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(),employee);
    }

    public Collection<Employee> getAll(){
        return employees.values();
    }

    public Employee getEmpolyeeById(Integer id){
        return employees.get(id);
    }

    public void  delete(Integer id){
        employees.remove(id);
    }

}
