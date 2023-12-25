package com.ternopil.service.serviceImpl;

import com.ternopil.models.Institution;
import com.ternopil.repository.InstitutionRepository;
import com.ternopil.service.InstitutionService;

public class InstitutionServiceImpl implements InstitutionService {

    private final InstitutionRepository institutionRepository;

    public InstitutionServiceImpl(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @Override
    public void createInstitution(Institution institution) {

    }
}
