package accord.app;

import java.util.HashMap;
import java.io.IOException;

import accord.app.helpers.DiscordHTTPCall;
import accord.app.helpers.TUIHelper;

public class App {
    public static void main(String[] args) {

        TUIHelper tui = new TUIHelper();

        if(args.length == 0 || args[1] == "-h"){
            tui.showHelp();
            return;
        }

        DiscordHTTPCall loginCall = new DiscordHTTPCall();
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");
        loginCall.setHeaders(headers);
        loginCall.setRequestBodyJSON("{\"email\":\""+args[1]+"\",\"password\":\""+args[2]+"\"}");
        try {
            loginCall.login();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
