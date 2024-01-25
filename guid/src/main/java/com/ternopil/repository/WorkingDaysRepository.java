package com.ternopil.repository;

import com.ternopil.models.WorkingDays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkingDaysRepository extends JpaRepository<WorkingDays, Long> {
}
