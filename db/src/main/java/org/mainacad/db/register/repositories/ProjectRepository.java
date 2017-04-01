package org.mainacad.db.register.repositories;

import org.mainacad.db.register.domain.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
}
