package com.ipad.project.locationRecommand.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipad.project.locationRecommand.dao.IRecommandRepository;
import com.ipad.project.locationRecommand.model.RecommandVO;

@Service
public class RecommandService implements IRecommandService {

	@Autowired
	IRecommandRepository recommandRepository;

	@Override
	public List<RecommandVO> recommandRegion(boolean opt1, boolean opt2) {
		List<Map<String, Object>> vos = selectRegion();
		ArrayList<RecommandVO> voss = new ArrayList<RecommandVO>();
		for (Map<String, Object> map : vos) {
			RecommandVO vo = new RecommandVO();
			vo.setTeens(Integer.valueOf(String.valueOf(map.get("TEENS"))));
			vo.setTwenties(Integer.valueOf(String.valueOf(map.get("TWENTIES"))));
			vo.setSixties(Integer.valueOf(String.valueOf(map.get("SIXTIES"))));
			vo.setOver70s(Integer.valueOf(String.valueOf(map.get("OVER70S"))));
			vo.setSale(Integer.valueOf(String.valueOf(map.get("SALE"))));
			vo.setAdm_cd(String.valueOf(map.get("ADM_CD")));
			vo.setAdm_nm(String.valueOf(map.get("REGION_NAME_DETAIL")));
			voss.add(vo);
		}

		setScore(voss, opt1, opt2);
		return getTop3List(voss);
	}


	@Override
	public int avgData(String data) {
		return recommandRepository.avgData(data);
	}

	@Override
	public void setSaleScore(RecommandVO dto) {
		double score = 0;
		score = (dto.getSale() - minData("sale")) * 10 / (maxData("sale") - minData("sale"));
		dto.setSaleScore(score);

	}

	@Override
	public void setTeensScore(RecommandVO dto) {
		double score = 0;
		score = (dto.getTeens() - minData("teens")) * 10 / (maxData("teens") - minData("teens"));
		dto.setTeensScore(score);

	}

	@Override
	public void setTwentiesScore(RecommandVO dto) {
		double score = 0;
		score = (dto.getTwenties() - minData("twenties")) * 10 / (maxData("twenties") - minData("twenties"));
		dto.setTwentiesScore(score);

	}

	@Override
	public void setSixtiesScore(RecommandVO dto) {
		double score = 0;
		score = (dto.getSixties() - minData("sixties")) * 10 / (maxData("sixties") - minData("sixties"));
		dto.setSixtiesScore(score);
	}

	@Override
	public void setOver70sScore(RecommandVO dto) {
		double score = 0;
		score = (dto.getOver70s() - minData("over70s")) * 10 / (maxData("over70s") - minData("over70s"));
		dto.setOver70sScore(score);
	}

	@Override
	public void setTotalScore(RecommandVO dto, boolean opt1, boolean opt2) {
		if (opt1 == true && opt2 == true) {
			dto.setTotalScore(dto.getSaleScore() * 6 + dto.getTwentiesScore() * 1 + dto.getTeensScore() * 1
					+ dto.getSixtiesScore() * 1 + dto.getOver70sScore() * 1);
		} else if (opt1 == false && opt2 == true) {
			dto.setTotalScore(dto.getSaleScore() * 6 + dto.getTwentiesScore() * 0 + dto.getTeensScore() * 0
					+ dto.getSixtiesScore() * 2 + dto.getOver70sScore() * 2);
		} else if (opt1 == true && opt2 == false) {
			dto.setTotalScore(dto.getSaleScore() * 6 + dto.getTwentiesScore() * 2 + dto.getTeensScore() * 2
					+ dto.getSixtiesScore() * 0 + dto.getOver70sScore() * 0);
		} else if (opt1 == false && opt2 == false) {
			dto.setTotalScore(dto.getSaleScore() * 10 + dto.getTwentiesScore() * 0 + dto.getTeensScore() * 0
					+ dto.getSixtiesScore() * 0 + dto.getOver70sScore() * 0);
		}
	}

	@Override
	public void setScore(ArrayList<RecommandVO> dtos, boolean opt1, boolean opt2) {
		for (RecommandVO dto : dtos) {
			setSaleScore(dto);
			setTeensScore(dto);
			setTwentiesScore(dto);
			setSixtiesScore(dto);
			setOver70sScore(dto);
			setTotalScore(dto, opt1, opt2);
		}
	}

	@Override
	public int minData(String option) {
		return recommandRepository.minData(option);
	}

	@Override
	public int maxData(String option) {
		return recommandRepository.maxData(option);
	}

	@Override
	public List<Map<String, Object>> selectRegion() {
		return recommandRepository.selectRegion();
	}

	@Override
	public double getMaxScore(ArrayList<RecommandVO> dtos) {
		double max = dtos.get(0).getTotalScore();
		for (int i = 0; i < dtos.size(); i++) {
			if (dtos.get(i).getTotalScore() > max) {
				max = dtos.get(i).getTotalScore();
			}
		}
		return max;
	}

	@Override
	public List<RecommandVO> getTop3List(List<RecommandVO> dtos) {
		return dtos.stream().sorted(Comparator.comparingDouble(RecommandVO::getTotalScore).reversed()).limit(3)
				.collect(Collectors.toList());
	}

}
