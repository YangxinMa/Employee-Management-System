package com.mark.controller;

import com.mark.dao.DepartmentDao;
import com.mark.dao.EmpolyeeDao;
import com.mark.pojo.Department;
import com.mark.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmpolyeeDao empolyeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = empolyeeDao.getAll();
        model.addAttribute("emps", employees);
        return "emp/list";
    }


    // got to Import page
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //check department information
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/add";
    }

    //Add employee to list
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //save Employee
        empolyeeDao.save(employee);

        return "redirect:/emps";
    }

    //Go to edit page
    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id")Integer id, Model model){

        Employee empolyee = empolyeeDao.getEmpolyeeById(id);

        model.addAttribute("emp", empolyee);

        //check department information
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);

        return "emp/update";
    }
    //Update information
    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        empolyeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/delemp/{id}")
    public String deleteEmp(@PathVariable("id")Integer id){
        empolyeeDao.delete(id);
        return "redirect:/emps";
    }

}
