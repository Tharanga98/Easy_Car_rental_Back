package lk.EasyCarRental.service.Impl;


import lk.EasyCarRental.dto.PaymentDTO;
import lk.EasyCarRental.entity.Payment;
import lk.EasyCarRental.repository.PaymentRepository;
import lk.EasyCarRental.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public void savePayment(PaymentDTO paymentDTO) {
        if(!paymentRepository.existsById(paymentDTO.getPaymentId())){
            Payment payment=modelMapper.map(paymentDTO, Payment.class);
            paymentRepository.save(payment);
        }else{
            throw new RuntimeException("Payment is all ready exist by id "+paymentDTO.getPaymentId());
        }
    }

    @Override
    public void updatePayment(PaymentDTO paymentDTO) {
        if(paymentRepository.existsById(paymentDTO.getPaymentId())){
            Payment payment=modelMapper.map(paymentDTO, Payment.class);
            paymentRepository.save(payment);
        }else{
            throw new RuntimeException("Payment is not exist by PaymentId "+paymentDTO.getPaymentId());
        }
    }

    @Override
    public void deletePayment(String paymentId) {
        if(paymentRepository.existsById(paymentId)){
            paymentRepository.deleteById(paymentId);
        }else{
            throw new RuntimeException("Payment is not exist by id "+paymentId);
        }
    }

    @Override
    public PaymentDTO searchPaymentById(String paymentId) {
        Optional<Payment> payment= paymentRepository.findById(paymentId);
        if(payment.isPresent()){
            return  modelMapper.map(payment.get(), PaymentDTO.class);
        }else{
            throw new RuntimeException("Can not find Payment for this id ");
        }
    }

    @Override
    public List<PaymentDTO> getAllPayment() {
        List<Payment> payments=paymentRepository.findAll();
        return  modelMapper.map(payments,new TypeToken<List<PaymentDTO>>(){}.getType());
    }
}
