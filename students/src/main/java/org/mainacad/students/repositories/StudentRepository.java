package org.mainacad.students.repositories;

import org.mainacad.students.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Long> {


}
