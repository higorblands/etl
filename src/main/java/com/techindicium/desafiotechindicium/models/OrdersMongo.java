package com.techindicium.desafiotechindicium.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "orders")
public class OrdersMongo extends org.bson.Document {
    @Id
    int order_id;
    String customer_id;
    int employee_id;
    Date order_date;
    Date required_date;
    Date shipped_date;
    int ship_via;
    float freight;
    String ship_name;
    String ship_address;
    String ship_city;
    String ship_region;
    String ship_postal_code;
    String ship_country;
}