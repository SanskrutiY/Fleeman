package service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.RateDTO;
import entity.Rate;
import mapper.Mapper;
import repository.RateRepository;
import service.RateService;

@Service
public class RateServiceImpl implements RateService {

	@Autowired
    private RateRepository rateRepo;
	
	@Override
	public List<RateDTO> getAllRates() {
		return rateRepo.findAll()
                .stream()
                .map(Mapper::mapToRateDTO)
                .collect(Collectors.toList());
	}

	@Override
	public RateDTO getRateById(int vehicleId) {
		return rateRepo.findById(vehicleId)
                .map(Mapper::mapToRateDTO)
                .orElse(null);
	}

//	@Override
//	public List<RateDTO> getRatesByVehicleId(int vehicleId) {
//		return rateRepo.findByVehicleVehicleId(vehicleId)
//                .stream()
//                .map(Mapper::mapToRateDTO)
//                .collect(Collectors.toList());
//	}

	@Override
	public RateDTO createRate(RateDTO dto) {
		Rate rate = Mapper.mapToRateEntity(dto);
        Rate saved = rateRepo.save(rate);
        return Mapper.mapToRateDTO(saved);
	}

	@Override
	public RateDTO updateRate(int rateId, RateDTO dto) {
		if (!rateRepo.existsById(rateId)) return null;
        Rate rate = Mapper.mapToRateEntity(dto);
        rate.setRateId(rateId);
        Rate updated = rateRepo.save(rate);
        return Mapper.mapToRateDTO(updated);
	}

	@Override
	public void deleteRate(int rateId) {
		rateRepo.deleteById(rateId);
	}

}
