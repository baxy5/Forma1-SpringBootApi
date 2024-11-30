package com.example.forma1restapi.Repositories;

import com.example.forma1restapi.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
    User findByFelhasznalonev(String felhasznalonev);
}
