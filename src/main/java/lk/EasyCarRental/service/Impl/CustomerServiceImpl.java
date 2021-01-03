package lk.EasyCarRental.service.Impl;


import lk.EasyCarRental.dto.CustomerDTO;
import lk.EasyCarRental.entity.Customer;
import lk.EasyCarRental.repository.CustomerRepository;
import lk.EasyCarRental.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        if(!customerRepository.existsById(customerDTO.getId())) {
            Customer customer = modelMapper.map(customerDTO, Customer.class);
            customerRepository.save(customer);
        }else{
            throw new RuntimeException("Customer is Allredy Exist..");
        }
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {

        if(customerRepository.existsById(customerDTO.getId())){
            Customer customer =modelMapper.map(customerDTO, Customer.class);
            customerRepository.save(customer);
        }else{
            throw new RuntimeException("No Such customer for update...");
        }
    }

    @Override
    public CustomerDTO searchCustomer(String id) {
       Optional<Customer> customer = customerRepository.findById(id);
       if(customer.isPresent()){
        return  modelMapper.map(customer.get(), CustomerDTO.class);
       }else{
           throw new RuntimeException("No Customer Found.....");
       }
    }

    @Override
    public void deleteCustomer(String id) {
        if(customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        }else{
            throw new RuntimeException("No Customer Delete by this ID - "+id);
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
       List<Customer> allCustomer = customerRepository.findAll();
      return modelMapper.map(allCustomer,new TypeToken<List<CustomerDTO>>(){}.getType());
    }


}
