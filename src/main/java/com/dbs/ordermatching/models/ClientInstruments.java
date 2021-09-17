//package com.dbs.ordermatching.models;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//
//import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.ManyToAny;
//
//import com.dbs.ordermatching.utils.MyGenerator;
//
//@Entity
//public class ClientInstruments {
//	
//	@Id
//	@GeneratedValue(generator = MyGenerator.generatorName)
//    @GenericGenerator(name = MyGenerator.generatorName, strategy = "com.dbs.ordermatching.utils.MyGenerator")
//	private String id;
//	
//	
//	private Client clientid;
//	@OneToMany
//	private Instrument instrumentid;
//	
//	private double quantity;
//	
//	
//
//}
