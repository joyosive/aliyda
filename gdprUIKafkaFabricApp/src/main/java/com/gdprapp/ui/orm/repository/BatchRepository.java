package com.gdprapp.ui.orm.repository;


import com.gdprapp.ui.orm.model.BatchItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatchRepository extends JpaRepository<BatchItem, Long> {

    public BatchItem findByUniqueCode(String uniqueCode);
    public BatchItem findByDrugNameContaining(String drugname);

}