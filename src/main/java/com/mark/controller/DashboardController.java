package com.mark.controller;

import com.mark.dao.EmpolyeeDao;
import com.mark.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class DashboardController {

    @RequestMapping("/dashboard")
    public String list(){
        return "dashboard";
    }
}
