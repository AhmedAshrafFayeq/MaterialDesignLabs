package com.example.retrofit_recyclerview;

import com.example.retrofit_recyclerview.Model.WorldPopulation;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class JsonResponse {

    @SerializedName("worldpopulation")
    private ArrayList<WorldPopulation> worldPopulations=null;

    public ArrayList<WorldPopulation> getWorldPopulations() {
        return this.worldPopulations;
    }
}
