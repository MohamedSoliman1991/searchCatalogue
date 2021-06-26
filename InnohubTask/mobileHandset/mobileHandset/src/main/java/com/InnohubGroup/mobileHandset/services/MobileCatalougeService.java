package com.InnohubGroup.mobileHandset.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InnohubGroup.mobileHandset.models.MobileHandset;
import com.InnohubGroup.mobileHandset.rest.dtos.params;

public interface MobileCatalougeService{

	public Iterable<MobileHandset> save(List<MobileHandset> MobileHandsetList);
	List<MobileHandset> findByCriteria(params params);
}
