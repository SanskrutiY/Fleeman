package service;

import dto.AddOnDTO;

import java.util.List;

public interface AddOnService {
    List<AddOnDTO> getAllAddOns();
    AddOnDTO getAddOnById(int id);
    List<AddOnDTO> getAddOnsByBookingId(int bookingId);
    AddOnDTO createAddOn(AddOnDTO dto);
    AddOnDTO updateAddOn(int id, AddOnDTO dto);
    void deleteAddOn(int id);
}
