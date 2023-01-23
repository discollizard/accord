package accord.app.helpers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Request.Builder;
import okhttp3.Response;

public class DiscordHTTPCall{

    private String endpoint;
    private String method;
    private String requestBodyJSON;
    private Map<String, String> responseBodyJSONToMap;
    private HashMap<String, String> headers;
    private String token;

    private Builder requestBuilder;
    private OkHttpClient client;
    private String discordBaseURL;

    public static final MediaType JSON
        = MediaType.parse("application/json; charset=utf-8");

    public DiscordHTTPCall(){
        this.discordBaseURL = "https://discord.com";
        this.client = new OkHttpClient();
        this.requestBuilder = new Request.Builder();
    }


    public String getEndpoint(){
        return this.endpoint;
    }

    public void setEndpoint(String endpoint){
        this.endpoint = endpoint;
    }

    public String getMethod(){
        return this.method;
    }

    public void setMethod(String method){
        this.method = method;
    }

    public String getRequestBodyJSON(){
        return this.requestBodyJSON;
    }

    public void setRequestBodyJSON(String requestBodyJSON){
        this.requestBodyJSON = requestBodyJSON;
    }

    public HashMap<String, String>  getHeaders(){
        return this.headers;
    }

    public void setHeaders(HashMap<String, String> headers){
        headers.forEach((key, value) -> this.requestBuilder.addHeader(key, value));
    }

    public String getToken(){
        return this.token;
    }

    public void setToken(String token){
        this.requestBuilder.header("Authorization", "token "+token);
    }

    public String login() throws IOException{
            Request builtReq = this.requestBuilder 
                .url(this.discordBaseURL+"/api/v9/auth/login")
                .post(RequestBody.create(this.requestBodyJSON, JSON))
                .build();

            System.out.println(builtReq.body());

            try (Response response = this.client.newCall(builtReq).execute()) {

                String bodyString = response.body().string();
                ObjectMapper jsonToMap = new ObjectMapper();
                this.responseBodyJSONToMap 
                    = jsonToMap.readValue(bodyString, Map.class);
                    
                if (!response.isSuccessful()){
                    throw new IOException("Error while logging in: " + this.responseBodyJSONToMap.get("message"));
                }

                System.out.println(this.responseBodyJSONToMap);
                return bodyString;
            }

    }

    

}
