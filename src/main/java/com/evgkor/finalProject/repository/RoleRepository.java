package com.evgkor.finalProject.repository;

import com.evgkor.finalProject.bean.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role,Long> {

    @Query("SELECT r FROM Role r WHERE r.name = :name")
    Role findByRole(@Param("name") String name);

}
