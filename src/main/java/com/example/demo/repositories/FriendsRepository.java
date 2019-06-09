package com.example.demo.repositories;

import com.example.demo.model.Friends;
import org.springframework.data.repository.CrudRepository;

public interface FriendsRepository extends CrudRepository<Friends, Integer> {
}
