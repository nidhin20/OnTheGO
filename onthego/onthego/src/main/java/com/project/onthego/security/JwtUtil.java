package com.project.onthego.security;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtil implements Serializable {
	@Value("${onthego.jwt.secretkey}")
	private String Secret_key ;

	public String extractusername(String token) {
		return extractClaims(token, Claims::getSubject);
	}

	public Date extractExpiration(String token) {
		return (Date) extractClaims(token, Claims::getExpiration);
	}

	public <T> T extractClaims(String token, Function<Claims, T> claimResolver) {
		final Claims claims = extractAllClaims(token);
		return claimResolver.apply(claims);
	}

	public Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(Secret_key).parseClaimsJws(token).getBody();
	}

	private Boolean IsTokenexpired(String token) {
		return extractExpiration(token).before(new Date());

	}

	public String GenerateToken(UserDetails userdetails) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, userdetails.getUsername());
	}

	private String createToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
				.signWith(SignatureAlgorithm.HS256, Secret_key).compact();
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = extractusername(token);
		return (username.equals(userDetails.getUsername()) && !IsTokenexpired(token));
	}
}
