package com.ternopil.service.serviceImpl;

import com.ternopil.DTO.CommentDTO;
import com.ternopil.DTO.InstitutionDTO;
import com.ternopil.DTO.InstitutionSummaryDTO;
import com.ternopil.exeption.NotFoundException;
import com.ternopil.mappers.InstitutionMapper;
import com.ternopil.models.Institution;
import com.ternopil.models.WorkingDays;
import com.ternopil.models.enums.InstitutionType;
import com.ternopil.models.enums.KitchensType;
import com.ternopil.repository.CommentRepository;
import com.ternopil.repository.InstitutionRepository;
import com.ternopil.repository.WorkingDaysRepository;
import com.ternopil.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InstitutionServiceImpl implements InstitutionService {

    private final InstitutionRepository institutionRepository;
    private final WorkingDaysRepository workingDaysRepository;


    @Autowired
    public InstitutionServiceImpl(InstitutionRepository institutionRepository, WorkingDaysRepository workingDaysRepository) {
        this.institutionRepository = institutionRepository;
        this.workingDaysRepository = workingDaysRepository;
    }

    @Override
    public InstitutionDTO createInstitution(InstitutionDTO institutionDTO) {
        Institution institution = InstitutionMapper.INSTANCE.toModel(institutionDTO);
        Institution institutionSaved =  institutionRepository.save(institution);

        for (WorkingDays workingDays : institutionDTO.getWorkingDays()) {
            workingDays.setInstitutionAndSave(institution);
            workingDaysRepository.save(workingDays);
        }
        return InstitutionMapper.INSTANCE.toDTO(institutionSaved);
    }

    @Override
    public List<InstitutionSummaryDTO> getAll(PageRequest pageRequest) {
        List<Institution> institution = institutionRepository.findAll(pageRequest).getContent();
        return institution.stream().map(InstitutionMapper.INSTANCE::toSummaryDTO).collect(Collectors.toList());
    }

    @Override
    public InstitutionDTO findById(Long id) {
        Optional<Institution> institutionOptional = institutionRepository.findById(id);
        Institution institution = institutionOptional.orElseThrow(() -> new NotFoundException("Not found"));
        return InstitutionMapper.INSTANCE.toDTO(institution);
    }

    @Override
    public List<InstitutionSummaryDTO> getByKitchenType(KitchensType typeKitchens, PageRequest pageRequest) {
        List<Institution> institutions = institutionRepository.getInstitutionByTypeKitchens(typeKitchens, pageRequest).getContent();
        return institutions.stream().map(InstitutionMapper.INSTANCE::toSummaryDTO).collect(Collectors.toList());
    }

    @Override
    public List<InstitutionSummaryDTO> getByInstitutionType(InstitutionType institutionType, PageRequest pageRequest) {
        List<Institution> institutions = institutionRepository.getInstitutionByTypeInstitution(institutionType, pageRequest).getContent();
        return institutions.stream().map(InstitutionMapper.INSTANCE::toSummaryDTO).collect(Collectors.toList());
    }

    @Override
    public List<InstitutionDTO> getByFilter(InstitutionType institutionType, KitchensType kitchensType, String city, PageRequest pageRequest) {
        List<Institution> institutions = institutionRepository.findByTypeInstitutionAndTypeKitchensAndCity(institutionType, kitchensType, city, pageRequest).getContent();
        return institutions.stream().map(InstitutionMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<InstitutionDTO> getByCity(String city, PageRequest pageRequest) {
        List<Institution> institutions = institutionRepository.getInstitutionByCity(city, pageRequest).getContent();
        return institutions.stream().map(InstitutionMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public void update(Long id, InstitutionDTO institutionDTO) {
        Optional<Institution> optionalInstitution = institutionRepository.findById(id);

        Institution institution = optionalInstitution.orElseThrow(() -> new NotFoundException("Not found user by id" + id));

        institution.setName(institutionDTO.getName());
        institution.setDescription(institutionDTO.getDescription());
        institution.setAddress(institutionDTO.getAddress());
        institution.setFeatures(institutionDTO.getFeatures());
        institution.setSocialNetworks(institutionDTO.getSocialNetworks());
        institution.setWebSite(institutionDTO.getWebSite());
        institution.setLat(institutionDTO.getLat());
        institution.setLon(institutionDTO.getLon());
        institution.setTypeInstitution(institutionDTO.getTypeInstitution());
        institution.setTypeKitchens(institutionDTO.getTypeKitchens());
//        institution.setCountry(institutionDTO.getCountry());
        institution.setCity(institutionDTO.getCity());
        institution.setWorkingDays(institutionDTO.getWorkingDays());

        institutionRepository.save(institution);
    }

    @Override
    public void remove(Long id) {
        institutionRepository.deleteById(id);
    }
}