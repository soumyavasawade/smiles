package com.test.sample.repository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.test.sample.model.UserData;

@Repository
public class UserDataSearchRepository {

	@Autowired
	MongoTemplate mongoTemplate;
	
	public Collection<UserData> searchUserDatas(String text) {
		return mongoTemplate.find(Query.query(new Criteria()
						.orOperator(Criteria.where("address").regex(text, "i"), 
									Criteria.where("name").regex(text, "i"), 
									Criteria.where("email").regex(text, "i"))
						), UserData.class);
	}
	
}
