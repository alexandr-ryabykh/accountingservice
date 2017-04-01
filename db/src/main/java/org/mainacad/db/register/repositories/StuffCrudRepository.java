package org.mainacad.db.register.repositories;

import org.mainacad.db.register.domain.Stuff;
import org.springframework.data.repository.CrudRepository;

public interface StuffCrudRepository extends CrudRepository<Stuff, Long> {

}
