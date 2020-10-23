package com.revature.repositories;

import com.revature.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepo extends CrudRepository<Event, Integer> {
}
