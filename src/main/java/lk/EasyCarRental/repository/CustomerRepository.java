package lk.EasyCarRental.repository;

import lk.EasyCarRental.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
