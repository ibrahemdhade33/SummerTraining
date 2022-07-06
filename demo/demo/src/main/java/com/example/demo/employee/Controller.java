package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("aaa")
@RestController
public class Controller {
    @RequestMapping("")
    public String Go(){
        return "index";
    }
    private final com.example.demo.employee.Service service;

    @Autowired
    public Controller(com.example.demo.employee.Service service) {
        this.service = service;
    }

    @GetMapping(path = "allEmployees")
    public List<Employee> getEmployee(){
        return service.getEmployees();
    }
    @PostMapping(path="addNewEmployee")

    public void  registerNewEmployee(@RequestBody Employee employee){

         service.registerNewEmployee(employee);

    }
    @DeleteMapping(path="dlt/{id}")
    public void delete(@PathVariable("id") int id){
        service.deleteEmployee(id) ;
    }
    @PutMapping(path="update/{id}")
    public void update(@PathVariable("id") int id,
                       @RequestParam(required = false) String firstName){
                        service.update(id,firstName);
    }
}
