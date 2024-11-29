package com.example.forma1restapi.Repositories;

import com.example.forma1restapi.Models.Gp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GpRepository extends JpaRepository<Gp, Long> {
}
