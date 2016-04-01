/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensode.netbeansbook.jaxrsclient;

/**
 *
 * @author heffel
 */
public class Main {

    public static void main(String[] args) {
        NewJerseyClient newJerseyClient = new NewJerseyClient();

        String response = newJerseyClient.find_JSON(String.class, "1");

        System.out.println("response is: " + response);

        newJerseyClient.close();
    }
}
