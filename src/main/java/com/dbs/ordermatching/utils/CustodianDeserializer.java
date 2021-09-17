package com.dbs.ordermatching.utils;

import java.io.IOException;
import java.time.LocalDate;

import com.dbs.ordermatching.models.Custodian;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;


public class CustodianDeserializer extends StdDeserializer<Custodian> {
    private static final long serialVersionUID = 1L;
    protected CustodianDeserializer() {
        super(Custodian.class);
    }

    @Override
    public Custodian deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
    	
    	JsonNode custodianNode = jp.getCodec().readTree(jp);
        
        System.out.println(custodianNode.toString().replace("\"", ""));
        
//        System.out.println(custodianNode.get("custodianid").toString());
        return new Custodian(custodianNode.toString().replace("\"", ""));
    }
}

/** SOURCE	
	https://stackoverflow.com/questions/28802544/java-8-localdate-jackson-format
*/