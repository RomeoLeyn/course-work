package com.ternopil.service.serviceImpl;

import com.ternopil.DTO.InstitutionDTO;
import com.ternopil.exeption.NotFoundException;
import com.ternopil.mappers.InstitutionMapper;
import com.ternopil.models.Institution;
import com.ternopil.models.WorkingDays;
import com.ternopil.models.enums.InstitutionType;
import com.ternopil.models.enums.KitchensType;
import com.ternopil.repository.InstitutionRepository;
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

    @Autowired
    public InstitutionServiceImpl(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @Override
    public void createInstitution(InstitutionDTO institutionDTO) {
        Institution institution = InstitutionMapper.INSTANCE.toModel(institutionDTO);
        institutionRepository.save(institution);
    }

    @Override
    public void workDays(Long id, WorkingDays workingDays) {
        Optional<Institution> institutionOptional = institutionRepository.findById(id);
        Institution institution = institutionOptional.orElseThrow(() -> new NotFoundException("Not found user by id" + id));

        institution.setWorkingDays(workingDays.getInstitution().getWorkingDays());
    }

    @Override
    public List<InstitutionDTO> gettAll(PageRequest pageRequest) {
        List<Institution> institution = institutionRepository.findAll(pageRequest).getContent();
        return institution.stream().map(InstitutionMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<InstitutionDTO> getByKitchenType(KitchensType typeKitchens, PageRequest pageRequest) {
        List<Institution> institutions = institutionRepository.getInstitutionByTypeKitchens(typeKitchens, pageRequest).getContent();
        return institutions.stream().map(InstitutionMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<InstitutionDTO> getByInstitutionType(InstitutionType institutionType, PageRequest pageRequest) {
        List<Institution> institutions = institutionRepository.getInstitutionByTypeInstitution(institutionType, pageRequest).getContent();
        return institutions.stream().map(InstitutionMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<InstitutionDTO> getByFilter(InstitutionType institutionType, KitchensType kitchensType, String city, PageRequest pageRequest) {
        List<Institution> institutions = institutionRepository.findByTypeInstitutionAndTypeKitchensAndCity(institutionType, kitchensType, city, pageRequest).getContent();
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