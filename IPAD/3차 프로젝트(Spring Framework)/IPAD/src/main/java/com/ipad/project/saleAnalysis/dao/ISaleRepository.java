package com.ipad.project.saleAnalysis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ipad.project.saleAnalysis.model.PatientPointVO;
import com.ipad.project.saleAnalysis.model.RegionDataVO;
import com.ipad.project.saleAnalysis.model.RegionFeeVO;
import com.ipad.project.saleAnalysis.model.SaleOverlayVO;
import com.ipad.project.saleAnalysis.model.SalePredictPointVO;

public interface ISaleRepository {
	List<SaleOverlayVO> getOverlay();
	List<RegionDataVO> getRegionData(@Param("regionCode") String regionCode);
	List<PatientPointVO> getPatientPoint();
	List<RegionDataVO> getSaleRegionData(@Param("regionCode") String regionCode);
	List<SalePredictPointVO> getSalePredictPoint();
	List<RegionFeeVO> getRegionFee(@Param("regionCode") String regionCode);
}
