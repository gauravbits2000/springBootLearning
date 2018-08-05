package com.learning.batch;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("employees")
public class EmployeeController 
{
    User employee = new User();
 
    @RequestMapping(value = "/{name}", 
    				method = RequestMethod.GET, 
    				produces = "application/json")
    public @ResponseBody User getEmployeeInJSON(@PathVariable String name)
    {
       employee.setName(name);
       employee.setEmail("employee1@genuitec.com");
       return employee; 
    }
    
    @RequestMapping(value = "/{name}.xml", 
    				method = RequestMethod.GET, 
    				produces = "application/xml")
    public @ResponseBody User getEmployeeInXML(@PathVariable String name) 
    {
       employee.setName(name);
       employee.setEmail("employee1@genuitec.com");
       return employee; 
    }

}
