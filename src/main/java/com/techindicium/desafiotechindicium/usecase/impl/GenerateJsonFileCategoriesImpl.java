package com.techindicium.desafiotechindicium.usecase.impl;

import com.google.gson.Gson;
import com.techindicium.desafiotechindicium.models.Categories;
import com.techindicium.desafiotechindicium.usecase.GenerateJsonFileCategories;
import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GenerateJsonFileCategoriesImpl implements GenerateJsonFileCategories {
    @SneakyThrows
    @Override
    public String execute(List<Categories> categoriesList, String date) {
        JSONArray jsonArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();

        categoriesList.forEach(categories -> {
            Gson gson = new Gson();
            String jsonString = gson.toJson(categories);
            jsonArray.put(jsonString);
        });
        jSONObject.put("categories", jsonArray);

        String jsonFormattedString = jSONObject.toString().replace("\\\"", "\"");
        String finalJSON = jsonFormattedString.replace("\"{", "{").replace("}\"", "}");
        try (FileWriter file = new FileWriter("data\\postgres-" + date + "-categories.json")) {
            file.write(finalJSON);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
