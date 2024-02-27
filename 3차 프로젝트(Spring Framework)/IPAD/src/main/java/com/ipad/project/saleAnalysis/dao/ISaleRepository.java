package com.ipad.project.saleAnalysis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ipad.project.saleAnalysis.model.PatientPointVO;
import com.ipad.project.saleAnalysis.model.RegionDataVO;
import com.ipad.project.saleAnalysis.model.SaleCalculateVO;
import com.ipad.project.saleAnalysis.model.SaleOverlayVO;

public interface ISaleRepository {
	List<SaleOverlayVO> getOverlay();
	List<RegionDataVO> getRegionData(@Param("regionCode") String regionCode);
	List<PatientPointVO> getPatientPoint();
}
