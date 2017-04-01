package org.mainacad.db.register.repositories;

import org.mainacad.db.register.domain.Groups;
import org.springframework.data.repository.CrudRepository;

public interface GroupsRepository extends CrudRepository<Groups, Long> {
}
