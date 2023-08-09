package com.bootproject.jesm34.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootproject.jesm34.dto.BuyerDto;
import com.bootproject.jesm34.repository.BuyerRepository;

@Component
public class BuyerDao {
	@Autowired
	BuyerRepository buyerRepository;

	public void createAccount(BuyerDto buyerDto) {
		buyerRepository.save(buyerDto);
		// "account succesfully created";
	}

	public Optional<BuyerDto> removeAccount(long id) {
		Optional<BuyerDto> obo = buyerRepository.findById(id);
		return obo;
	}

	public void removeById(long id) {
		buyerRepository.deleteById(id);
	}

	public Optional<BuyerDto> fetchbyid(long id) {
		// TODO Auto-generated method stub
		Optional<BuyerDto> odo = buyerRepository.findById(id);
		return odo;
	}

	public List<BuyerDto> fetchall() {
		// TODO Auto-generated method stub
		List<BuyerDto> dtos = buyerRepository.findAll();
		return dtos;

	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		buyerRepository.deleteAll();
	}

	public String update(BuyerDto buyerDto) {
		// TODO Auto-generated method stub
		buyerRepository.save(buyerDto);
		return "data updated";
	}

}
