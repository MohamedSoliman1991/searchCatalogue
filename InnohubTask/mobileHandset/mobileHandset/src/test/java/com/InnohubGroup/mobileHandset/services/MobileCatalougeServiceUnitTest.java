package com.InnohubGroup.mobileHandset.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.InnohubGroup.mobileHandset.daos.MobileHandsetRepository;
import com.InnohubGroup.mobileHandset.models.MobileHandset;
import com.InnohubGroup.mobileHandset.rest.dtos.params;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MobileCatalougeServiceUnitTest {

	@Autowired
	MobileCatalougeService mobileCatalougeService;
	
	@Autowired
	MobileHandsetRepository mobileHandsetRepository;
	
	public void testFindByCriteria ()
	
	{
		params params = new params();
		params.setSim("eSIM");
	   List<MobileHandset> data = mobileCatalougeService.findByCriteria(params);
	   assertThat(data).isNotNull()
       .isNotEmpty();
		
		
		
	}
}
