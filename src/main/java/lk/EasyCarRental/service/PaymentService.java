package lk.EasyCarRental.service;

import lk.EasyCarRental.dto.DriverDTO;
import lk.EasyCarRental.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {

    void savePayment(PaymentDTO paymentDTO);

    void updatePayment(PaymentDTO paymentDTO);

    void deletePayment(String paymentId);

    PaymentDTO  searchPaymentById(String paymentId);

    List<PaymentDTO> getAllPayment();
}
