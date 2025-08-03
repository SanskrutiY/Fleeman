package service.impl;

import dto.VehicleAssignmentDTO;
import entity.VehicleAssignment;
import repository.VehicleAssignmentRepository;
import service.VehicleAssignmentService;
import mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleAssignmentServiceImpl implements VehicleAssignmentService {

    @Autowired
    private VehicleAssignmentRepository repository;

    @Override
    public List<VehicleAssignmentDTO> getAllAssignments() {
        return repository.findAll()
                .stream()
                .map(Mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VehicleAssignmentDTO getAssignmentById(int id) {
        return repository.findById(id)
                .map(Mapper::toDTO)
                .orElse(null);
    }

    @Override
    public List<VehicleAssignmentDTO> getAssignmentsByCustomerId(int customerId) {
        return repository.findByCustomer_CustId(customerId)
                .stream()
                .map(Mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VehicleAssignmentDTO createAssignment(VehicleAssignmentDTO dto) {
        VehicleAssignment entity = Mapper.toEntity(dto);
        VehicleAssignment saved = repository.save(entity);
        return Mapper.toDTO(saved);
    }

    @Override
    public VehicleAssignmentDTO updateAssignment(int id, VehicleAssignmentDTO dto) {
        if (!repository.existsById(id)) return null;

        VehicleAssignment entity = Mapper.toEntity(dto);
        entity.setAssignmentId(id); // Ensure update
        VehicleAssignment updated = repository.save(entity);
        return Mapper.toDTO(updated);
    }

    @Override
    public void deleteAssignment(int id) {
        repository.deleteById(id);
    }
}
