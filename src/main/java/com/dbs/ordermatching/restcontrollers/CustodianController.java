package com.dbs.ordermatching.restcontrollers;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.ordermatching.models.Custodian;
import com.dbs.ordermatching.models.Result;
import com.dbs.ordermatching.repositories.UserRepository;
import com.dbs.ordermatching.utils.JWTUtil;

@RestController
@RequestMapping("/custodian")
@CrossOrigin
public class CustodianController {

	@Autowired
	private JWTUtil jwtutil;
	
	@Autowired
	private UserRepository userrepository;
	
	@GetMapping("/getuser")
	public ResponseEntity<Result> findCustomerid(HttpServletRequest request) throws UsernameNotFoundException {
		
        final String authorizationHeader = request.getHeader("Authorization");
		
		String custodianid = null;
		
		
		String jwt = null;
		
		if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer ")) {
			jwt = authorizationHeader.substring(7);
			System.out.println("JWT: "+jwt);
			custodianid= jwtutil.extractUsername(jwt);
			
		}
		Optional<Custodian> opt = userrepository.findByCustodianid(custodianid);
		
		
		opt.orElseThrow(()->new UsernameNotFoundException("NOT FOUND "));
		
		opt.get().setPassword(null);
				
		return ResponseEntity.status(HttpStatus.OK).body(new Result(true, "Found", opt.get()));
		
		
	}
	
	
}
