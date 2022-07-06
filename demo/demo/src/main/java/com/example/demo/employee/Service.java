package com.example.demo.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@org.springframework.stereotype.Service
public class Service {

    private EmployeeRepo employeeRepo ;
    @Autowired
    public Service(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public List<Employee> getEmployees(){
        return employeeRepo.findAll();
    }

    public void registerNewEmployee(Employee employee) {
        Optional<Employee> checkifemail = employeeRepo.checkifemail(employee.getEmail()) ;
        if(checkifemail.isPresent())
                    throw new IllegalStateException("the user is already register") ;
           employeeRepo.save(employee);


    }

    public void deleteEmployee(int id) {
        boolean in = employeeRepo.existsById(id) ;
        if(!in)
            throw new IllegalStateException("the student doesnot exsist") ;
        employeeRepo.deleteById(id);
    }
    @Transactional
    public void update(int id,String firstName) {
        Employee employee = employeeRepo.findById(id).orElseThrow(
                ()->new IllegalStateException("the Employee doesnt exist"));
        if(firstName!=null && !firstName.equals(""))
            employee.setFirstName(firstName);
    }
}
