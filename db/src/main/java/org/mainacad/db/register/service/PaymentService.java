package org.mainacad.db.register.service;

import org.mainacad.db.register.domain.Payments;

public interface PaymentService {

    Payments addPayment(Payments payment);

    Payments getPaymentById(long id);

    Iterable<Payments> listAllPayments();
}
