package com.test.assignment.repository;

import com.test.assignment.model.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SectorRepository extends JpaRepository<Sector, Long> {

    List<Sector> findAllByParentSectorIsNull();

}
