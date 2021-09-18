package com.dbs.ordermatching.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.ordermatching.models.Client;
import com.dbs.ordermatching.models.Custodian;

public interface ClientRepository extends JpaRepository<Client, String>{

	List<Client> findAllByCustodianid(Custodian custodianid);
	
	 long countByCustodianid(Custodian custodianid);
}
