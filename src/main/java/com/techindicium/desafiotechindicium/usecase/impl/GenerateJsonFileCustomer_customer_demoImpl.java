package com.techindicium.desafiotechindicium.usecase.impl;

import com.google.gson.Gson;
import com.techindicium.desafiotechindicium.models.Customer_Customer_Demo;
import com.techindicium.desafiotechindicium.usecase.GenerateJsonFileCustomer_Customer_Demo;
import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GenerateJsonFileCustomer_customer_demoImpl implements GenerateJsonFileCustomer_Customer_Demo {
    @SneakyThrows
    @Override
    public String execute(List<Customer_Customer_Demo> customer_customer_demoList, String date) {
        JSONArray jsonArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();

        customer_customer_demoList.stream().forEach(customer_customer_demo -> {
            Gson gson = new Gson();
            String jsonString = gson.toJson(customer_customer_demo);
            jsonArray.put(jsonString);
        });
        jSONObject.put("customer_customer_demo", jsonArray);

        String jsonFormattedString = jSONObject.toString().replace("\\\"", "\"");
        String finalJSON = jsonFormattedString.replace("\"{", "{").replace("}\"", "}");
        try (FileWriter file = new FileWriter("data\\postgres-" + date + "-customer_customer_demo.json")) {
            file.write(finalJSON);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
