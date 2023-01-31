package demo7_Spring_REST.springdemo.rest;

import demo7_Spring_REST.springdemo.entity.Customer;
import demo7_Spring_REST.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
    // autowite the CustomerService
    @Autowired
    private CustomerService customerService;

    // add mapping GET /customers
    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/hello2")
    public String sayHello() {
        return "Hello world!";
    }


}
