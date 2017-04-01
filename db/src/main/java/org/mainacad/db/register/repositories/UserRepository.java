package org.mainacad.db.register.repositories;

import org.mainacad.db.register.domain.UserTM;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserTM, Long> {
}
