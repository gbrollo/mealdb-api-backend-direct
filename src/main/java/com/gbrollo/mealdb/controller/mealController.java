package com.gbrollo.mealdb.controller;

import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class mealController {

        private static final String url = "https://www.themealdb.com/api/json/v1/1/";        

        @GetMapping(value="search", produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseBody
        public String getMealByName(@RequestParam(name = "s") String search) {
            try {
                String rawUrl = mealController.url+"search.php?s=" + search;
                URL url = new URL(rawUrl);
                HttpsURLConnection  con = (HttpsURLConnection ) url.openConnection();
                con.setRequestMethod("GET");
                con.setRequestProperty("Content-Type", "application/json");
                con.setRequestProperty("Charset", "UTF-8");
                int responseCode = con.getResponseCode();

                BufferedReader br;
                if (responseCode >= 200 && responseCode < 300) {
                    br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
                } else {
                    br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "UTF-8"));
                }
        
                String inputLine;
                StringBuilder response = new StringBuilder();
        
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
        
                String responseStr = response.toString();
                return responseStr;
            } catch (Exception ex) {
                String fail = "{ \"msg\": \"internal server error\", \"code\": 500 }";
                return fail;
            }
        }

        @GetMapping(value="filter", produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseBody
        public String getMealByFilter(@RequestParam(name = "s") String search) {
            try {
                String rawUrl = mealController.url+"search.php?s=" + search;
                URL url = new URL(rawUrl);
                HttpsURLConnection  con = (HttpsURLConnection ) url.openConnection();
                con.setRequestMethod("GET");
                con.setRequestProperty("Content-Type", "application/json");
                con.setRequestProperty("Charset", "UTF-8");
                int responseCode = con.getResponseCode();

                BufferedReader br;
                if (responseCode >= 200 && responseCode < 300) {
                    br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
                } else {
                    br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "UTF-8"));
                }
        
                String inputLine;
                StringBuilder response = new StringBuilder();
        
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
        
                String responseStr = response.toString();
                return responseStr;
            } catch (Exception ex) {
                String fail = "{ \"msg\": \"internal server error\", \"code\": 500 }";
                return fail;
            }
        }

}