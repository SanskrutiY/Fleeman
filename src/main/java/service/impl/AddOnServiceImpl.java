package service.impl;

import dto.AddOnDTO;
import entity.AddOn;
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
    private AddOnRepository addOnRepo;
    
    @Override
    public List<AddOnDTO> getAllAddOns() {
        return addOnRepo.findAll()
                .stream()
                .map(Mapper::mapToAddOnDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AddOnDTO getAddOnById(int id) {
        return addOnRepo.findById(id)
                .map(Mapper::mapToAddOnDTO)
                .orElse(null);
    }

    @Override
    public List<AddOnDTO> getAddOnsByBookingId(int bookingId) {
        return addOnRepo.findByBookingBook_id(bookingId)
                .stream()
                .map(Mapper::mapToAddOnDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AddOnDTO createAddOn(AddOnDTO dto) {
        AddOn addOn = Mapper.mapToAddOnEntity(dto);
        AddOn saved = addOnRepo.save(addOn);
        return Mapper.mapToAddOnDTO(saved);
    }

    @Override
    public AddOnDTO updateAddOn(int id, AddOnDTO dto) {
        if (!addOnRepo.existsById(id)) return null;

        AddOn updated = Mapper.mapToAddOnEntity(dto);
        updated.setAddonId(id);
        updated = addOnRepo.save(updated);
        return Mapper.mapToAddOnDTO(updated);
    }

    @Override
    public void deleteAddOn(int id) {
        addOnRepo.deleteById(id);
    }
}
