package com.hyperflex.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author chuntaojun
 */
@Document(collection = "FoodBook")

public class BillFare {

    private static String BILL_TYPE = "家常菜";

    @Id
    private String _id;
    @Field(value = "foodCode")
    private Long billCode;
    @Field(value = "foodName")
    private String billName;
    @Field(value = "foodType")
    private String billType;
    @Field(value = "foodIngredient")
    private Map<String, String> billIngredient;
    @Field(value = "foodSteps")
    private ArrayList<String> billSteps;
    @Field(value = "foodPicUrls")
    private ArrayList<String> billPicture;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Long getBillCode() {
        return billCode;
    }

    public void setBillCode(Long billCode) {
        this.billCode = billCode;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        if (billType == null || "".equals(billType)) {
            this.billType = BILL_TYPE;
        } else {
            this.billType = billType;
        }
    }

    public Map<String, String> getBillIngredient() {
        return billIngredient;
    }

    public void setBillIngredient(Map<String, String> billIngredient) {
        this.billIngredient = billIngredient;
    }

    public ArrayList<String> getBillSteps() {
        return billSteps;
    }

    public void setBillSteps(ArrayList<String> billSteps) {
        this.billSteps = billSteps;
    }

    public ArrayList<String> getBillPicture() {
        return billPicture;
    }

    public void setBillPicture(ArrayList<String> billPicture) {
        this.billPicture = billPicture;
    }

    @Override
    public String toString() {
        return "BillFare{" +
                "_id='" + _id + '\'' +
                ", billCode=" + billCode +
                ", billName='" + billName + '\'' +
                ", billType='" + billType + '\'' +
                ", billIngredient=" + billIngredient +
                ", billSteps=" + billSteps +
                ", billPicture=" + billPicture +
                '}';
    }
}
