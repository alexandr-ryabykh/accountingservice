package org.mainacad.db.register.repositories;

import org.mainacad.db.register.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by genich on 30.03.17.
 */
public interface UserRepository extends CrudRepository<User,Long> {
}
