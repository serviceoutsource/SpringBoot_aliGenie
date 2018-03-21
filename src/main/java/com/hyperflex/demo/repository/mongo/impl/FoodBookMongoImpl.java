package com.hyperflex.demo.repository.mongo.impl;

import com.hyperflex.demo.model.BillFare;
import com.hyperflex.demo.repository.mongo.FoodBookMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

/**
 * @author chuntaojun
 */
@Component
@Service("FoodBookMongo")
public class FoodBookMongoImpl implements FoodBookMongo {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public BillFare queryBillFare(String foodName) {
        Pattern pattern = Pattern.compile("^.*" + foodName + ".*$", Pattern.CASE_INSENSITIVE);
        Query query = new Query();
        query.addCriteria(Criteria.where("foodName").regex(pattern));
        return mongoTemplate.findOne(query, BillFare.class);
    }
}
