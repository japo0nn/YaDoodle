package com.yadoodle.YaDoodle.repo;

import com.yadoodle.YaDoodle.models.Search;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface SearchRepository extends CrudRepository<Search, Long>, JpaRepository<Search, Long> {
    @Query
    Optional<Search> findSearchByName(String text);
    Optional<Search> findSearchByDesc(String text);
}
