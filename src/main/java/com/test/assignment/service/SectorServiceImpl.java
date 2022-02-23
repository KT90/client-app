package com.test.assignment.service;

import com.test.assignment.model.Sector;
import com.test.assignment.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectorServiceImpl implements SectorService {

    @Autowired
    private SectorRepository sectorRepository;

    @Override
    public List<Sector> getAllParentSectors() {
        return sectorRepository.findAllByParentSectorIsNull();
    }
}
