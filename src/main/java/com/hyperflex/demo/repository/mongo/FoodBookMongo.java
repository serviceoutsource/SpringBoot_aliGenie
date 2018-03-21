package com.hyperflex.demo.repository.mongo;

import com.hyperflex.demo.model.BillFare;

/**
 * @author chuntaojun
 */
public interface FoodBookMongo {

    /**
     *
     * @param foodName
     * @return
     */
    BillFare queryBillFare(String foodName);

}
