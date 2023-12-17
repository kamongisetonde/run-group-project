package com.sethondrunninggroop.web.repository;

import com.sethondrunninggroop.web.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
