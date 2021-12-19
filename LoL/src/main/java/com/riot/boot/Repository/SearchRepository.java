package com.riot.boot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riot.boot.model.search;


public interface SearchRepository extends JpaRepository<search,Integer>{
}
