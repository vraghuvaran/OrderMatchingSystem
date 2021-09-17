package com.dbs.ordermatching.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.ordermatching.models.Client;

public interface ClientRepository extends JpaRepository<Client, String>{

}
