package com.learning.batch;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

//@RestController  // using @RestController annotation
@Controller
@Api(value="homeController-Helloo", description="Description about the Controller Method") 

@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
        })
public class HomeController 
{
	@RequestMapping("/hello")  
	 //@RequestMapping(value = "/hello", method = "GET" )  
    public String hello(){  
        return"Hello!";  
   }	

    @RequestMapping("/")  
    public String index(){  
        return"index";  
    }  
    
    @RequestMapping(value="/save", method=RequestMethod.POST)  
    public ModelAndView save(@ModelAttribute User user)
    {  
        ModelAndView modelAndView = new ModelAndView();  
        modelAndView.setViewName("user-data");      
        modelAndView.addObject("user", user);    
        return modelAndView;  
    }
	
}
