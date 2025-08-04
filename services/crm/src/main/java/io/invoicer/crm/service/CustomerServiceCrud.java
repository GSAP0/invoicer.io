package io.invoicer.crm.service;

import io.invoicer.crm.dto.customer.CustomerDTO;
import io.invoicer.crm.mapper.CustomerMapper;
import io.invoicer.crm.model.Customer;
import io.invoicer.crm.repository.CustomerRepository;

import java.util.List;
import java.util.stream.Collectors;

public abstract class CustomerServiceCrud {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceCrud(CustomerRepository customerRepository, CustomerMapper customerMapper){
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public List<CustomerDTO> findAll(){
        return this.customerRepository.findAll().stream().map(customerMapper::toDTO).collect(Collectors.toList());
    }

    public CustomerDTO show(long id){
        Customer c =  customerRepository.findById(id).orElseThrow();
        return customerMapper.toDTO(c);
    }

    public CustomerDTO create(CustomerDTO customerDTO) {
        Customer customer = customerMapper.toEntity(customerDTO);
        return customerMapper.toDTO(customerRepository.save(customer));
    }

    public void delete(CustomerDTO model) {
    }

    public CustomerDTO update(CustomerDTO customerDTO) {
        Customer customer = customerMapper.toEntity(customerDTO);
        return customerMapper.toDTO(customerRepository.save(customer));
    }

}
