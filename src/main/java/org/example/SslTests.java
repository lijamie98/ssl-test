package org.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Hello world!
 */
public class SslTests {
    public static void sslTest(String urlString) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(urlString)
                .build();

        try (Response response = client.newCall(request).execute()) {
            assert response.body() != null;
            System.out.println(response.body().string());
        }
    }

    public static void main(String[] args) {
        System.out.println("#######################################");
        System.out.println("Testing LOBSTR ......");
        try {
            sslTest("https://lobstr.co/.well-known/stellar.toml");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("#######################################");
        System.out.println("Testing Horizon testnet ......");
        try {
            sslTest("https://horizon-testnet.stellar.org/");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("#######################################");
        System.out.println("Testing Google ......");
        System.out.println("#######################################");
        System.out.println("Testing Horizon testnet ......");
        try {
            sslTest("https://www.google.com");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
