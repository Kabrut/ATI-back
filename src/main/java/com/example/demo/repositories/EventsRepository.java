package com.example.demo.repositories;

import com.example.demo.model.Events;
import org.springframework.data.repository.CrudRepository;

public interface EventsRepository extends CrudRepository<Events, Integer> {
}
