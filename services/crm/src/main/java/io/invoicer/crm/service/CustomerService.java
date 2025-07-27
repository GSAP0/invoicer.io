package io.invoicer.crm.service;

import io.invoicer.crm.dto.customer.CustomerDTO;
import io.invoicer.crm.model.Customer;
import io.invoicer.crm.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends CustomerServiceCrud implements IBasicCrud<CustomerDTO, Customer>{

    public CustomerService(@Autowired CustomerRepository customerRepository){
        super(customerRepository);
    }

}
