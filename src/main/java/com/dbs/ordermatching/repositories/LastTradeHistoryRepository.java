package com.dbs.ordermatching.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.dbs.ordermatching.models.LastTradeHistory;

public interface LastTradeHistoryRepository extends JpaRepository<LastTradeHistory, String>{
	
	
}
