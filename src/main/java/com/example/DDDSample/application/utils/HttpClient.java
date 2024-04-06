package com.example.DDDSample.application.utils;

import okhttp3.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;
import com.example.DDDSample.application.configuration.ApplicationConfig;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HttpClient {

    private String server = "http://localhost:3000";
    private String httpServer = "";
    private RestTemplate rest = null;
    private HttpHeaders headers;
    private HttpStatus status;
    private int timeout;

//    public HttpClient(DatabaseConfig config) {
//        this.rest = new RestTemplate();
//        this.headers = new HttpHeaders();
//        headers.add("Content-Type", "application/json");
//        headers.add("Accept", "*/*");
//
//        server = config.getMobileGWIP() + ":" + config.getMobileGWPort();
//        timeout=Integer.parseInt( config.getMobileGWTimeout());
//    }

    public HttpClient(ApplicationConfig applicationConfig) {
        this.rest = new RestTemplate();
        this.headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "*/*");

        server = applicationConfig.getGw().getIp() + ":" + applicationConfig.getGw().getPort();
        timeout = applicationConfig.getGw().getTimeout();
    }

    public String post(String json, String path) {
        //server = "http://" + server + path + "/";
        httpServer = "http://" + server + path + "/";

        WriteLog.write("REQUEST[" + httpServer + "]>>>>> " + json);
        OkHttpClient client = new OkHttpClient();
//        client.setConnectTimeout(timeout, TimeUnit.MILLISECONDS);
//        client.setReadTimeout(timeout, TimeUnit.MILLISECONDS);

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, json);
        Request request = new Request.Builder().url(httpServer ).post(body)
                .addHeader("content-type", "application/json")
                .addHeader("cache-control", "no-cache").build();

        try {
            Response response = client.newCall(request).execute();
            String strRes = response.body().string();
            WriteLog.write("RESPONSE[" + httpServer + "]>>>>> " + strRes);
            return strRes;
        } catch (Exception e) {
            WriteLog.error("[HttpClient] EXCEPTION >>>>> ", e);
            return null;
        }
    }
}
