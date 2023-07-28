package com.stackroute.userauthenticationmanagement.repository;

import com.stackroute.userauthenticationmanagement.models.ERole;
import com.stackroute.userauthenticationmanagement.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);
}
