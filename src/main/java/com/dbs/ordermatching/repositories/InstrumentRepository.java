package com.dbs.ordermatching.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.ordermatching.models.Instrument;


public interface InstrumentRepository extends JpaRepository<Instrument, String>{

}
