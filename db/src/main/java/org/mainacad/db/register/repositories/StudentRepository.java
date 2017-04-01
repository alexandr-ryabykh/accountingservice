package org.mainacad.db.register.repositories;

import org.mainacad.db.register.domain.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
