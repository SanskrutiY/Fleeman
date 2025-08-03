package service;

import java.util.List;

import dto.RateDTO;

public interface RateService {
	List<RateDTO> getAllRates();
    RateDTO getRateById(int vehicleId);
    List<RateDTO> getRatesByVehicleId(int vehicleId);
    RateDTO createRate(RateDTO dto);
    RateDTO updateRate(int rateId, RateDTO dto);
    void deleteRate(int rateId);
}
