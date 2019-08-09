package com.test.sample.repository;

import org.springframework.data.repository.CrudRepository;

import com.test.sample.model.UserData;

public interface UserDataMongoRepository extends CrudRepository<UserData, String>{}