package com.workintech.s19d1.dao;

import com.workintech.s19d1.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDao extends JpaRepository<Movie, Long> {
}
