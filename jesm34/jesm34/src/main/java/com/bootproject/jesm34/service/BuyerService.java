package com.bootproject.jesm34.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.bootproject.jesm34.dao.BuyerDao;
import com.bootproject.jesm34.dto.BuyerDto;
import com.bootproject.jesm34.helper.ResponseStructure;

@Component
public class BuyerService {

	@Autowired
	BuyerDao buyerDao;

	public void createAccount(BuyerDto buyerDto) {
		buyerDao.createAccount(buyerDto);

	}

	public String removeAccount(long id) {
//		return buyerDao.removeAccount();
		// TODO Auto-generated method stub
		Optional<BuyerDto> obs = buyerDao.removeAccount(id);
		if (obs.isPresent()) {
			BuyerDto dto = obs.get();
			buyerDao.removeById(id);
			return "account is deleted";
		} else
			return "no data found";

	}

	public BuyerDto fetchbyid(long id) {
		// TODO Auto-generated method stub
		Optional<BuyerDto> odo = buyerDao.fetchbyid(id);
		if (odo.isPresent()) {
			BuyerDto buyerDto = odo.get();
			return buyerDto;
		} else {
			return null;
		}

	}

	public List<BuyerDto> fetchAll() {
		// TODO Auto-generated method stub
		List<BuyerDto> dtos = buyerDao.fetchall();
		if (dtos.isEmpty()) {
			return null;
		} else
			return dtos;
	}

	public String deleteAll() {
		// TODO Auto-generated method stub
		List<BuyerDto> dtos = buyerDao.fetchall();
		if (dtos.isEmpty()) {
			return "no data found";
		} else {
			buyerDao.deleteAll();
			return "data deleted";
		}
	}

	public String update(BuyerDto buyerDto) {
		// TODO Auto-generated method stub
		return buyerDao.update(buyerDto);
	}

}
