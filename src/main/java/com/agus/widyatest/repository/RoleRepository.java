package com.agus.widyatest.repository;

import com.agus.widyatest.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleNameContaining(String roleName);
}
