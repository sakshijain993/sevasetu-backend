package com.sevasetu.need_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sevasetu.need_service.entity.Need;

public interface NeedRepository extends JpaRepository<Need, Long>{

}
