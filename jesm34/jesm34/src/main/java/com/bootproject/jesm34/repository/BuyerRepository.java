package com.bootproject.jesm34.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootproject.jesm34.dto.BuyerDto;
@Repository
public interface BuyerRepository extends JpaRepository<BuyerDto, Long>{

	
}
