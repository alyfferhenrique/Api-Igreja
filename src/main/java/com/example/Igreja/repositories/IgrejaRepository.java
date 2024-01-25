package com.example.Igreja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Igreja.models.IgrejaModel;

@Repository
public interface IgrejaRepository extends JpaRepository<IgrejaModel,Long> {


    
}
