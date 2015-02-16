/**
 * 
 */
package org.rusl.ethpaura.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 * @author Rumesha
 * 
 */
public class PasswordEncoderGenerator {

	public static String getHash(String password) {
		 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();  
		  String hashedPassword = passwordEncoder.encode(password);  
		  
		  System.out.println(hashedPassword);  
		  return hashedPassword;  

	}

}
