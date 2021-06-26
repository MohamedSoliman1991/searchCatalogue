package com.InnohubGroup.mobileHandset.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.InnohubGroup.mobileHandset.models.MobileHandset;
import com.InnohubGroup.mobileHandset.rest.dtos.params;
import com.InnohubGroup.mobileHandset.services.MobileCatalougeService;

@RestController
public class MobileController {

	@Autowired
	private MobileCatalougeService mobileCatalougeService;

	@RequestMapping(value = "/mobile/search", method = RequestMethod.GET)
	public List<MobileHandset> search(params parameters)

	{
		return mobileCatalougeService.findByCriteria(parameters);
	}
}
