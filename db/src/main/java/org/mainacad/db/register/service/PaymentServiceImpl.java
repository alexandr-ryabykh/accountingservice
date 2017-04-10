package org.mainacad.db.register.service;

import org.mainacad.db.register.domain.Payments;
import org.mainacad.db.register.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    private PaymentRepository paymentRepository;

    @Autowired
    public void setPaymentRepository(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payments addPayment(Payments payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payments getPaymentById(long id) {
        return paymentRepository.findOne(id);
    }

    @Override
    public Iterable<Payments> listAllPayments() {
        return paymentRepository.findAll();
    }
    /*List<Payments> result = users.collect(Collectors.toList());*/
}
