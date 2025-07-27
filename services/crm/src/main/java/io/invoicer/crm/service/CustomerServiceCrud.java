package io.invoicer.crm.service;

import io.invoicer.crm.dto.customer.CustomerDTO;
import io.invoicer.crm.mapper.CustomerMapper;
import io.invoicer.crm.model.Customer;
import io.invoicer.crm.repository.CustomerRepository;

import java.util.List;
import java.util.stream.Collectors;

public abstract class CustomerServiceCrud {

    private final CustomerRepository customerRepository;

    public List<CustomerDTO> findAll(){
        return this.customerRepository.findAll().stream().map(CustomerMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    public CustomerServiceCrud(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public CustomerDTO show(long id){
        Customer c =  customerRepository.findById(id).orElseThrow();
        return CustomerMapper.INSTANCE.toDTO(c);
    }

    public CustomerDTO create(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.INSTANCE.toEntity(customerDTO);
        return CustomerMapper.INSTANCE.toDTO(customerRepository.save(customer));
    }

    public CustomerDTO update(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.INSTANCE.toEntity(customerDTO);
        return CustomerMapper.INSTANCE.toDTO(customerRepository.save(customer));
    }

    public void delete(CustomerDTO model) {
    }


}
