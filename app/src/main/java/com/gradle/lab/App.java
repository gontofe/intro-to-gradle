package com.gradle.lab;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.javanet.NetHttpTransport;

import java.io.IOException;

public class App {

    AppModel appmodel = new AppModel();

    public String getGreeting() {
        return appmodel.getGreeting();
    }

    public String getUrl() {
        // This is a small website and easily prints.
        return appmodel.getUrl();
    }

    public static void main(String[] args) throws IOException {
        App app = new App();
        System.out.println(app.getGreeting());

        HttpRequestFactory requestFactory = new NetHttpTransport().createRequestFactory();
        HttpRequest request = requestFactory.buildGetRequest(new GenericUrl(app.getUrl()));
        String rawResponse = request.execute().parseAsString();
        System.out.println("\n---------\n");
        System.out.println(rawResponse);
    }
}