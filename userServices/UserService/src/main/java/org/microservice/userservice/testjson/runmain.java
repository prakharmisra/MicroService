package org.microservice.userservice.testjson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class runmain {
    public static void main(String[] args) {
        String json1 = "{\"name\":\"Adelaide\",\"weather\":\"15 degree\",\"status\":[\"Wind: 8Kmph\",\"Humidity: 61% \"]}";
        String json2 = "{\"name\":\"allmade\",\"weather\":\"16 degree\",\"status\":[\"Wind: 6Kmph\",\"Humidity: 61% \"]}";
        String json3 = "{\"name\":\"amadeall\",\"weather\":\"121 degree\",\"status\":[\"Wind: 32Kmph\",\"Humidity: 61% \"]}";

        List<String> formattedData = new ArrayList<>();
        formattedData.add(extractData(json1));
        formattedData.add(extractData(json2));
        formattedData.add(extractData(json3));

        for (String data : formattedData) {
            System.out.println(data);
        }
    }

    private static String extractData(String jsonString) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(jsonString);

            String name = jsonNode.get("name").asText();
            String  weather = Arrays.stream(jsonNode.get("weather").asText().split(" ")).findFirst().get();
            String wind = jsonNode.get("status").get(0).asText().split(":")[1].trim();
            String humidity = jsonNode.get("status").get(1).asText().split(":")[1].trim();

            return name + ", " + weather + ", " + wind + ", " + humidity;
        } catch (Exception e) {
            e.printStackTrace();
            return ""; // Return empty string on error
        }
    }
    }





