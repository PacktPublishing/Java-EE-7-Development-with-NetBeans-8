package com.ensode.jsonpstreamingapi;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

@Named
@RequestScoped
public class JsonPStreamingApiBean {

    @Inject
    private Person person;
    private String jsonStr;

    public String generateJson() {
        StringWriter stringWriter = new StringWriter();
        try (JsonGenerator jsonGenerator
                = Json.createGenerator(stringWriter)) {
            jsonGenerator.writeStartObject().
                    write("firstName", person.getFirstName()).
                    write("middleName", person.getMiddleName()).
                    write("lastName", person.getLastName()).
                    write("gender", person.getGender()).
                    write("age", person.getAge()).
                    writeEnd();
        }

        setJsonStr(stringWriter.toString());
        return "generated_json";
    }

    public String parseJson() {
        StringReader stringReader = new StringReader(jsonStr);

        JsonParser jsonParser = Json.createParser(stringReader);

        Map<String, Object> jsonMap = new HashMap<>();
        String jsonKeyNm = null;
        Object jsonVal = null;

        while (jsonParser.hasNext()) {
            JsonParser.Event event = jsonParser.next();

            if (event.equals(Event.KEY_NAME)) {
                jsonKeyNm = jsonParser.getString();
            } else if (event.equals(Event.VALUE_STRING)) {
                jsonVal = jsonParser.getString();
            } else if (event.equals(Event.VALUE_NUMBER)) {
                jsonVal = jsonParser.getInt();
            }

            jsonMap.put(jsonKeyNm, jsonVal);
        }

        person.setFirstName((String) jsonMap.get("firstName"));
        person.setMiddleName((String) jsonMap.get("middleName"));
        person.setLastName((String) jsonMap.get("lastName"));
        person.setGender((String) jsonMap.get("gender"));
        person.setAge((Integer) jsonMap.get("age"));
        
        return "display_populated_obj";
    }

    public String getJsonStr() {
        return jsonStr;
    }

    public void setJsonStr(String jsonStr) {
        this.jsonStr = jsonStr;
    }

}
