package com.example.stacksourcewebservices.service.impl;

import com.example.stacksourcewebservices.entities.Education;
import com.example.stacksourcewebservices.repository.IEducationRepository;
import com.example.stacksourcewebservices.service.IEducationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class EducationServiceImpl implements IEducationService {

    private final IEducationRepository educationRepository;

    public EducationServiceImpl(IEducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    @Override
    @Transactional
    public Education save(Education education) throws Exception {
        return educationRepository.save(education);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        educationRepository.deleteById(id);
    }

    @Override
    public List<Education> getAll() throws Exception {
        return educationRepository.findAll();
    }

    @Override
    public Optional<Education> getById(Long id) throws Exception {
        return educationRepository.findById(id);
    }

    @Override
    public Optional<Education> findByDigitalProfileId(Long id) throws Exception {
        return educationRepository.findByDigitalProfileId(id);
    }
}
