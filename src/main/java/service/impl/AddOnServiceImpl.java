package service.impl;

import dto.AddOnDTO;
import entity.Addon;
import mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AddOnRepository;
import service.AddOnService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddOnServiceImpl implements AddOnService {

    @Autowired
    private AddOnRepository addonRepo;
    
    @Override
    public List<AddOnDTO> getAllAddOns() {
        return addonRepo.findAll()
                .stream()
                .map(Mapper::mapToAddOnDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AddOnDTO getAddOnById(int id) {
        return addonRepo.findById(id)
                .map(Mapper::mapToAddOnDTO)
                .orElse(null);
    }

//    @Override
//    public List<AddOnDTO> getAddOnsByBookingId(int bookingId) {
//        return addonRepo.findByBookingBookingId(bookingId)
//                .stream()
//                .map(Mapper::mapToAddOnDTO)
//                .collect(Collectors.toList());
//    }

    @Override
    public AddOnDTO createAddOn(AddOnDTO dto) {
        Addon addon = Mapper.mapToAddOnEntity(dto);
        Addon saved = addonRepo.save(addon);
        return Mapper.mapToAddOnDTO(saved);
    }

    @Override
    public AddOnDTO updateAddOn(int id, AddOnDTO dto) {
        if (!addonRepo.existsById(id)) return null;

        Addon updated = Mapper.mapToAddOnEntity(dto);
        updated.setAddonId(id);
        updated = addonRepo.save(updated);
        return Mapper.mapToAddOnDTO(updated);
    }

    @Override
    public void deleteAddOn(int id) {
        addonRepo.deleteById(id);
    }
}
