package io.invoicer.crm.controller;

import io.invoicer.crm.dto.customer.CustomerDTO;
import io.invoicer.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(@Autowired CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> findAll(){
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> show(@PathVariable("id") long id){
        return ResponseEntity.ok(customerService.show(id));
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> create(@RequestBody CustomerDTO customerDTO){
        return ResponseEntity.created(null).body(customerService.create(customerDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> update(@PathVariable("id") long id, @RequestBody CustomerDTO customerDTO){
        return ResponseEntity.ok(customerService.update(customerDTO));
    }
}
