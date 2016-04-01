/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensode.netbeansbook.jaxrsclient;

import javax.ws.rs.ClientErrorException;

/**
 *
 * @author heffel
 */
public class Main1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String json = "{\"addressline1\":\"123 Icant Dr.\","
                + "\"addressline2\":\"Apt 42\",\"city\":"
                + "\"Springfield\",\"creditLimit\":1000,"
                + "\"customerId\":999,\"discountCode\":"
                + "{\"discountCode\":\"N\",\"rate\":0.00},"
                + "\"email\":\"customer@example.com\","
                + "\"fax\":\"555-555-1234\",\"name\":"
                + "\"Customer Name\",\"phone\":"
                + "\"555-555-2345\",\"state\":"
                + "\"AL\",\"zip\":{\"areaLength\":"
                + "547.967,\"areaWidth\":468.858,\""
                + "radius\":755.778,"
                + "\"zipCode\":\"12345\"}}";

        NewJerseyClient newJerseyClient = new NewJerseyClient();

        newJerseyClient.create_JSON(json);

        newJerseyClient.close();
    }

}
