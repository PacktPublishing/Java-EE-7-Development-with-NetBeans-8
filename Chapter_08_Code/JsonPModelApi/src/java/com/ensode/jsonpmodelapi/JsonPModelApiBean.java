package com.ensode.jsonpmodelapi;

import java.io.StringReader;
import java.io.StringWriter;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonWriter;

@Named
@RequestScoped
public class JsonPModelApiBean {

    @Inject
    private Person person;
    private String jsonStr;

    public String generateJson() {
        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();

        JsonObject jsonObject = jsonObjectBuilder.
                add("firstName", person.getFirstName()).
                add("middleName", person.getMiddleName()).
                add("lastName", person.getLastName()).
                add("gender", person.getGender()).
                add("age", person.getAge()).
                build();

        StringWriter stringWriter = new StringWriter();

        try (JsonWriter jsonWriter = Json.createWriter(stringWriter)) {
            jsonWriter.writeObject(jsonObject);
        }
        setJsonStr(stringWriter.toString());

        return "generated_json";
    }

    public String parseJson() {
        JsonObject jsonObject;

        try (JsonReader jsonReader = Json.createReader(new StringReader(jsonStr))) {
            jsonObject = jsonReader.readObject();
        }

        person.setFirstName(jsonObject.getString("firstName"));
        person.setMiddleName(jsonObject.getString("middleName"));
        person.setLastName(jsonObject.getString("lastName"));
        person.setGender(jsonObject.getString("gender"));
        person.setAge(jsonObject.getInt("age"));
        
        return "display_populated_obj";
    }

    public String getJsonStr() {
        return jsonStr;
    }

    public void setJsonStr(String jsonStr) {
        this.jsonStr = jsonStr;
    }

}
