package lk.EasyCarRental.service;



import lk.EasyCarRental.dto.CustomerDTO;

import java.util.List;


public interface CustomerService {

    void saveCustomer(CustomerDTO customerDTO);

    void updateCustomer(CustomerDTO customerDTO);

    CustomerDTO searchCustomer(String id);

    void deleteCustomer(String id);

    List<CustomerDTO> getAllCustomer();
}