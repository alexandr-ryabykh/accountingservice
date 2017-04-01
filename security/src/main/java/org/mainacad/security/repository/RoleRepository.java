package org.mainacad.security.repository;

import org.mainacad.security.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("select b from Role b where b.name = :name")
    Role findByName(@Param("name") String name);
}