package org.mainacad.security.repository;

import org.mainacad.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
