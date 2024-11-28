package com.jumong.internshiptaskone.data.repositories;

import com.jumong.internshiptaskone.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
