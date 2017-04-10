package org.mainacad.db.register.repositories;

import org.mainacad.db.register.domain.Payments;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payments, Long> {
}
