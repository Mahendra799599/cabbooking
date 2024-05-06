package com.abc.cabservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.cabservice.entity.Cab;

@Repository
public interface CabRepository extends JpaRepository<Cab, Integer> {
}