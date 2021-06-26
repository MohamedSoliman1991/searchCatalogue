package com.InnohubGroup.mobileHandset.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.InnohubGroup.mobileHandset.daos.MobileHandsetRepository;
import com.InnohubGroup.mobileHandset.models.Hardware;
import com.InnohubGroup.mobileHandset.models.MobileHandset;
import com.InnohubGroup.mobileHandset.models.Release;
import com.InnohubGroup.mobileHandset.rest.dtos.params;

@Service
public class MobileCatalougeServiceImpl implements MobileCatalougeService{

	@Autowired
	private MobileHandsetRepository mobileHandsetRepository;
	@Override
	public Iterable<MobileHandset> save(List<MobileHandset> MobileHandsetList) {
        return mobileHandsetRepository.saveAll(MobileHandsetList);
    }

	@Override
	public List<MobileHandset> findByCriteria(params params){
		ExampleMatcher customExampleMatcher = ExampleMatcher.matchingAll()
			      .withMatcher("sim", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
			      .withMatcher("release.announceDate", ExampleMatcher.GenericPropertyMatchers.exact().ignoreCase())
			      .withMatcher("release.priceEur", ExampleMatcher.GenericPropertyMatchers.exact().ignoreCase())
			      .withMatcher("hardware.audioJack", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
			      .withMatcher("hardware.battery", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
			      .withMatcher("hardware.gps", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
			      .withMatcher("brand", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
			      .withMatcher("phone", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
			      .withMatcher("resolution", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase()) ;
		
		MobileHandset mobileHandset = new MobileHandset();
		mobileHandset.setSim(params.getSim());
		mobileHandset.setBrand(params.getBrand());
		mobileHandset.setPhone(params.getPhone());
		mobileHandset.setResolution(params.getResolution());
		Release  release = new Release();
		release.setPriceEur(params.getPriceEur());
		release.setAnnounceDate(params.getAnnounceDate());
		mobileHandset.setRelease(release);
		Hardware hardware = new Hardware();
		hardware.setAudioJack(params.getAudioJack());
		hardware.setBattery(params.getBattery());
		hardware.setGps(params.getGps());
		mobileHandset.setHardware(hardware);
		
		 Example<MobileHandset> example = Example.of(mobileHandset, customExampleMatcher);
			return mobileHandsetRepository.findAll(example);
	}
}
