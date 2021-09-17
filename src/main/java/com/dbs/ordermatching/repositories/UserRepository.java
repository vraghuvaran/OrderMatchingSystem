package com.dbs.ordermatching.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.ordermatching.models.Custodian;

public interface UserRepository extends JpaRepository<Custodian, String>{
     Optional<Custodian> findByCustodianid(String custodianid);
}
