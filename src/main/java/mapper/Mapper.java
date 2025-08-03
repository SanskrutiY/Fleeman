package mapper;

import java.util.List;

import dto.*;
import entity.*;


public class Mapper {
	public static VehicleDTO mapToVehicleDTO(Vehicle vehicle) {
	    if (vehicle == null)
	        return null;
	    VehicleDTO dto = new VehicleDTO();
	    dto.setModel(vehicle.getModel());
	    dto.setType(vehicle.getType());
	    dto.setYear(vehicle.getYear());
	    dto.setStatus(vehicle.getStatus());
	    dto.setMileage(vehicle.getMileage());
	    return dto;
	}
    public static Vehicle mapToVehicleEntity(VehicleDTO dto) {
        if (dto == null)
            return null;
        Vehicle vehicle = new Vehicle();
        vehicle.setModel(dto.getModel());
        vehicle.setType(dto.getType());
        vehicle.setYear(dto.getYear());
        vehicle.setStatus(dto.getStatus());
        vehicle.setMileage(dto.getMileage());
//        if (dto.getRateId() != null) {
//        	vehicle.setRate(set from rateRepository if doing payment);
//        }
        return vehicle;
    }
    
    public static CustomerDTO mapToCustomerDTO(Customer customer) {
        if (customer == null) return null;
        CustomerDTO dto = new CustomerDTO();
        dto.setFullName(customer.getFullName());
        dto.setEmail(customer.getEmail());
        dto.setPhoneNum(String.valueOf(customer.getPhoneNum()));
        dto.setCity(customer.getCity());
        dto.setPassportNum(customer.getPassportNum());
        return dto;
    }
    public static Customer mapToCustomerEntity(CustomerDTO dto) {
        if (dto == null)
            return null;
        Customer customer = new Customer();
        customer.setFullName(dto.getFullName());
        customer.setEmail(dto.getEmail());
        try {
            customer.setPhoneNum(Long.parseLong(dto.getPhoneNum()));
        } catch (NumberFormatException e) {
            customer.setPhoneNum(0L);
        }
        customer.setCity(dto.getCity());
        customer.setPassportNum(dto.getPassportNum());
        return customer;
    }
    
    public static BookingDTO mapToBookingDTO(Booking booking) {
        if (booking == null) return null;
        BookingDTO dto = new BookingDTO();
        dto.setBookingId(booking.getBookingId());
        if (booking.getCustomer() != null) {
            dto.setCustomerId(booking.getCustomer().getCustId());
        }
        if (booking.getVehicleAssignments() != null) {
            dto.setVehicleAssignments(
            		booking.getVehicleAssignments().stream().map(obj -> mapToVehicleAssignmentDTO(obj)).toList()
    		);
        }
        dto.setStartDate(booking.getStartDate());
        dto.setEndDate(booking.getEndDate());
        dto.setPickupLocation(booking.getPickupLocation());
        dto.setDropdownLocation(booking.getDropdownLocation());
        dto.setStatus(booking.getStatus());
        return dto;
    }
    public static Booking mapToBookingEntity(BookingDTO dto) {
        if (dto == null) return null;
        Booking booking = new Booking();
        booking.setBookingId(dto.getBookingId());
        Customer customer = new Customer();
        customer.setCustId(dto.getCustomerId());
        booking.setCustomer(customer);
        booking.setStartDate(dto.getStartDate());
        booking.setEndDate(dto.getEndDate());
        booking.setPickupLocation(dto.getPickupLocation());
        booking.setDropdownLocation(dto.getDropdownLocation());
        booking.setStatus(dto.getStatus());
        return booking;
    }
    
    public static VehicleAssignmentDTO mapToVehicleAssignmentDTO(VehicleAssignment va) {
        if (va == null) return null;
        VehicleAssignmentDTO dto = new VehicleAssignmentDTO();
        dto.setAssignmentId(va.getAssignmentId());
        if (va.getVehicle() != null) {
            dto.setVehicle(mapToVehicleDTO(va.getVehicle()));
        }
        if (va.getFuelLog() != null) {
            dto.setFuelLog(mapToFuelLogDTO(va.getFuelLog()));
        }
        dto.setLocalDl(va.getLocalDl());
        dto.setAssignDate(va.getAssignDate());
        dto.setReturnDate(va.getReturnDate());
        return dto;
    }
    
    /** 
     * Not needed
     */
//    public static VehicleAssignment mapToVehicleAssignmentEntity(VehicleAssignmentDTO dto) {
//        if (dto == null) return null;
//        VehicleAssignment va = new VehicleAssignment();
//        va.setAssignmentId(dto.getAssignmentId());
//        Vehicle vehicle = new Vehicle();
//        vehicle.setVehicleId(dto.getVehicleId());
//        va.setVehicle(vehicle);
//        Customer customer = new Customer();
//        customer.setCustId(dto.getCustomerId());
//        va.setCustomer(customer);
//        Booking booking = new Booking();
//        booking.setBook_id(dto.getBookingId());
//        va.setBooking(booking);
//        va.setLocalDl(dto.getLocalDl());
//        va.setAssignDate(dto.getAssignDate());
//        va.setReturnDate(dto.getReturnDate());
//        return va;
//    }
    
    public static FuelLogDTO mapToFuelLogDTO(FuelLogs fuelLog) {
        if (fuelLog == null) return null;
        FuelLogDTO dto = new FuelLogDTO();
        dto.setFuelId(fuelLog.getFuelId());
        dto.setStartVolume(fuelLog.getStartVolume());
        dto.setDate(fuelLog.getDate());
        dto.setEndVolume(fuelLog.getEndVolume());
        return dto;
    }
    public static FuelLogs mapToFuelLogEntity(FuelLogDTO dto) {
        if (dto == null) return null;
        FuelLogs fuelLog = new FuelLogs();
        fuelLog.setFuelId(dto.getFuelId());
        fuelLog.setStartVolume(dto.getStartVolume());
        fuelLog.setDate(dto.getDate());
        fuelLog.setEndVolume(dto.getEndVolume());
        return fuelLog;
    }
    
    public static RateDTO mapToRateDTO(Rate rate) {
        if (rate == null) return null;
        RateDTO dto = new RateDTO();
        dto.setRateId(rate.getRateId());
        dto.setDailyRate(rate.getDailyRate());
        dto.setWeeklyRate(rate.getWeeklyRate());
        dto.setMonthlyRate(rate.getMonthlyRate());
        return dto;
    }
    public static Rate mapToRateEntity(RateDTO dto) {
        if (dto == null) return null;
        Rate rate = new Rate();
        rate.setRateId(dto.getRateId());
        rate.setDailyRate(dto.getDailyRate());
        rate.setWeeklyRate(dto.getWeeklyRate());
        rate.setMonthlyRate(dto.getMonthlyRate());
        return rate;
    }
    
    public static LocationDTO mapToLocationDTO(Location location) {
        if (location == null) return null;
        LocationDTO dto = new LocationDTO();
        dto.setHubId(location.getHubId());
        dto.setHubAddress(location.getHubAddress());
        dto.setCity(location.getCity());
        dto.setState(location.getState());
        dto.setAirportCode(location.getAirportCode());
        return dto;
    }
    public static Location mapToLocationEntity(LocationDTO dto) {
        if (dto == null) return null;
        Location location = new Location();
        location.setHubId(dto.getHubId());
        location.setHubAddress(dto.getHubAddress());
        location.setCity(dto.getCity());
        location.setState(dto.getState());
        location.setAirportCode(dto.getAirportCode());
        return location;
    }


    /**
     * Returns addons associated with particular booking and not the addon type list
     * @param addon
     */
    public static AddOnDTO mapToAddOnDTO(Addon addon) {
        if (addon == null) return null;
        AddOnDTO dto = new AddOnDTO();
        dto.setAddonId(addon.getAddonId());
        dto.setAddonType(addon.getAddonType());
        
        return dto;
    }
    public static Addon mapToAddOnEntity(AddOnDTO dto) {
        if (dto == null) return null;
        Addon addon = new Addon();
        addon.setAddonId(dto.getAddonId());
        addon.setAddonType(dto.getAddonType());
        return addon;
    }
    
    
    
    
}
