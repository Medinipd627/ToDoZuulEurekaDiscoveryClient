package com.bridgelabz.eureka.zuul;
/************************************************************************************************
 * Created By:Medini P.D
 * Date:- 10/08/2018
 * Purpose: JW token implementation class for the login and registration
 *************************************************************************************************/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;

public class JWToken {
	static Logger logger= LoggerFactory.getLogger(JWToken.class);
	public static Claims verifyToken(String token) {
		try {
			Claims claims = Jwts.parser()
					.setSigningKey("passKey")
					.parseClaimsJws(token)
					.getBody();
			return claims;
		} catch (UnsupportedJwtException | MalformedJwtException | IllegalArgumentException e) {
			throw new JWTException("Error in verifying JW Token");
		} catch (ExpiredJwtException e) {
			throw new JWTException("Token Expired");
		}catch(Exception e) {e.printStackTrace();throw new RuntimeException();}
	}
}