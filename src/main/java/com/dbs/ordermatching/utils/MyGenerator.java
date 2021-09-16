package com.dbs.ordermatching.utils;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class MyGenerator implements IdentifierGenerator{
	
	public static final String generatorName = "myGenerator";
	
    @Override
    
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object object) throws HibernateException {
        return UUID.randomUUID().toString().replace("-", "");
        // or any other logic you'd like for generating unique IDs
    }

}
