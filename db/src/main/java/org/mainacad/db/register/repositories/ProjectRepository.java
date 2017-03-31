package org.mainacad.db.register.repositories;

import org.mainacad.db.register.domain.Project;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by genich on 30.03.17.
 */
public interface ProjectRepository extends CrudRepository<Project,Long> {
}
