package accord.app;

import java.util.HashMap;
import java.io.IOException;

import accord.app.helpers.DiscordHTTPCall;

public class App {
    public static void main(String[] args) {
        DiscordHTTPCall loginCall = new DiscordHTTPCall();
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");
        loginCall.setHeaders(headers);
        loginCall.setRequestBodyJSON("{\"email\":\"mail\",\"password\":\"pass\"}");
        try {
            loginCall.login();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
