package com.learning.batch;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserRestController 
{
    User user = new User();
 
    @RequestMapping(value = "/{name}", 
    				method = RequestMethod.GET, 
    				produces = "application/json")
    public User getEmployeeInJSON(@PathVariable String name)
    {
       user.setName(name);
       user.setEmail("employee1@genuitec.com");
       return user; 
    }
    
    @RequestMapping(value = "/{name}.xml", 
    				method = RequestMethod.GET, 
    				produces = "application/xml")
    public User getEmployeeInXML(@PathVariable String name) 
    {
       user.setName(name);
       user.setEmail("employee1@genuitec.com");
       return user; 
    }

}
