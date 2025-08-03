package mapper;

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
        dto.setBookingId(booking.getBook_id());
        if (booking.getCustomer() != null) {
            dto.setCustomerId(booking.getCustomer().getCustId());
        }
        if (booking.getVehicle() != null) {
            dto.setVehicleId(booking.getVehicle().getVehicleId());
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
        booking.setBook_id(dto.getBookingId());
        Customer customer = new Customer();
        customer.setCustId(dto.getCustomerId());
        booking.setCustomer(customer);
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleId(dto.getVehicleId());
        booking.setVehicle(vehicle);
        booking.setStartDate(dto.getStartDate());
        booking.setEndDate(dto.getEndDate());
        booking.setPickupLocation(dto.getPickupLocation());
        booking.setDropdownLocation(dto.getDropdownLocation());
        booking.setStatus(dto.getStatus());
        return booking;
    }
    
    public static VehicleAssignmentDTO toDTO(VehicleAssignment va) {
        if (va == null) return null;
        VehicleAssignmentDTO dto = new VehicleAssignmentDTO();
        dto.setAssignmentId(va.getAssignmentId());
        if (va.getVehicle() != null) {
            dto.setVehicleId(va.getVehicle().getVehicleId());
        }
        if (va.getCustomer() != null) {
            dto.setCustomerId(va.getCustomer().getCustId());
        }
        if (va.getBooking() != null) {
            dto.setBookingId(va.getBooking().getBook_id());
        }
        dto.setLocalDl(va.getLocalDl());
        dto.setAssignDate(va.getAssignDate());
        dto.setReturnDate(va.getReturnDate());
        return dto;
    }
    public static VehicleAssignment toEntity(VehicleAssignmentDTO dto) {
        if (dto == null) return null;
        VehicleAssignment va = new VehicleAssignment();
        va.setAssignmentId(dto.getAssignmentId());
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleId(dto.getVehicleId());
        va.setVehicle(vehicle);
        Customer customer = new Customer();
        customer.setCustId(dto.getCustomerId());
        va.setCustomer(customer);
        Booking booking = new Booking();
        booking.setBook_id(dto.getBookingId());
        va.setBooking(booking);
        va.setLocalDl(dto.getLocalDl());
        va.setAssignDate(dto.getAssignDate());
        va.setReturnDate(dto.getReturnDate());
        return va;
    }
    
    
    public static FuelLogDTO mapToFuelLogDTO(FuelLogs fuelLog) {
        if (fuelLog == null) return null;
        FuelLogDTO dto = new FuelLogDTO();
        dto.setFuelId(fuelLog.getFuel_id());
        if (fuelLog.getAssignment() != null) {
            dto.setAssignmentId(fuelLog.getAssignment().getAssignmentId());
        }
        dto.setFuelVolume(fuelLog.getFuelVolume());
        dto.setDate(fuelLog.getDate());
        dto.setEndVolume(fuelLog.getEndVolume());
        return dto;
    }
    public static FuelLogs mapToFuelLogEntity(FuelLogDTO dto) {
        if (dto == null) return null;
        FuelLogs fuelLog = new FuelLogs();
        fuelLog.setFuel_id(dto.getFuelId());
        VehicleAssignment assignment = new VehicleAssignment();
        assignment.setAssignmentId(dto.getAssignmentId());
        fuelLog.setAssignment(assignment);
        fuelLog.setFuelVolume(dto.getFuelVolume());
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
        dto.setSeason(rate.getSeason());
        if (rate.getVehicle() != null) {
            dto.setVehicleId(rate.getVehicle().getVehicleId());
        }
        dto.setGpsNavigation(rate.getGpsNavigation());
        dto.setCampingKit(rate.getCampingKit());
        dto.setChildSeats(rate.getChildSeats());
        return dto;
    }
    public static Rate mapToRateEntity(RateDTO dto) {
        if (dto == null) return null;
        Rate rate = new Rate();
        rate.setRateId(dto.getRateId());
        rate.setDailyRate(dto.getDailyRate());
        rate.setWeeklyRate(dto.getWeeklyRate());
        rate.setMonthlyRate(dto.getMonthlyRate());
        rate.setSeason(dto.getSeason());
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleId(dto.getVehicleId());
        rate.setVehicle(vehicle);
        rate.setGpsNavigation(dto.getGpsNavigation());
        rate.setCampingKit(dto.getCampingKit());
        rate.setChildSeats(dto.getChildSeats());
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


    
    public static AddOnDTO mapToAddOnDTO(AddOn addOn) {
        if (addOn == null) return null;
        AddOnDTO dto = new AddOnDTO();
        dto.setAddonId(addOn.getAddonId());
        dto.setGpsNavigation(addOn.getGpsNavigation());
        dto.setCampingKit(addOn.getCampingKit());
        dto.setChildSeats(addOn.getChildSeats());
        dto.setBookingId(addOn.getBooking() != null ? addOn.getBooking().getBook_id() : null);
        return dto;
    }
    public static AddOn mapToAddOnEntity(AddOnDTO dto) {
        if (dto == null) return null;
        AddOn addOn = new AddOn();
        addOn.setAddonId(dto.getAddonId());
        addOn.setGpsNavigation(dto.getGpsNavigation());
        addOn.setCampingKit(dto.getCampingKit());
        addOn.setChildSeats(dto.getChildSeats());
        // Do not set Booking here directly unless you fetch and assign externally in service
        addOn.setBooking(null); // or handle this in the service class
        return addOn;
    }
    
    
    
    
}
