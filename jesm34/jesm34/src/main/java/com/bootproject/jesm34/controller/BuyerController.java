package com.bootproject.jesm34.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootproject.jesm34.dao.BuyerDao;
import com.bootproject.jesm34.dto.BuyerDto;
import com.bootproject.jesm34.helper.ResponseStructure;
import com.bootproject.jesm34.service.BuyerService;

@RestController
@RequestMapping("/buyers")
public class BuyerController {

	@Autowired
	BuyerDao buyerDao;

	@Autowired
	BuyerService buyerService;

	@PostMapping("/signin")
	public ResponseStructure<BuyerDto> createAccount(@RequestBody BuyerDto buyerDto) {
//		System.out.println(buyerDto);
		// return buyerDao.createAccount(buyerDto);
		buyerService.createAccount(buyerDto);
		ResponseStructure<BuyerDto> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("account created");
		responseStructure.setData(buyerDto);
		return responseStructure;
	}

	@DeleteMapping("/delete")
	public String removeAccount(@RequestBody BuyerDto buyerDto) {
		buyerService.removeAccount(buyerDto.getId());
		return "account remooved...";
	}

	@GetMapping("/fetchbyid/{id}")
	public BuyerDto fetchbyid(@PathVariable long id) {
//		System.out.println(id);
		return buyerService.fetchbyid(id);
	}

	@GetMapping("fetchall")
	public List<BuyerDto> fetchAll() {
		return buyerService.fetchAll();
	}

	@PutMapping("/update")
	public String update(@RequestBody BuyerDto buyerDto) {
		return buyerService.update(buyerDto);
	}

	@DeleteMapping("/deleteall")
	public String deleteAll() {
		return buyerService.deleteAll();
	}
}
