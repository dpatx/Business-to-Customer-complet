package com.zensar.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.entity.TokenEnity;

@Repository
public interface TokenService extends JpaRepository<TokenEnity, Integer> {

	public List<TokenEnity> findByToken(String token);
}
