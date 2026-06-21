package com.workintech.s19d1.dao;

import com.workintech.s19d1.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorDao extends JpaRepository<Actor, Long> {
}
