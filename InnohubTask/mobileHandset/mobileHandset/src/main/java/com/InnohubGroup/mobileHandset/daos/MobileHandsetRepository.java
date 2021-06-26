package com.InnohubGroup.mobileHandset.daos;

import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.InnohubGroup.mobileHandset.models.MobileHandset;

@Repository
public interface MobileHandsetRepository extends JpaRepository<MobileHandset, Long>{

}
