package accord.app;

import java.util.HashMap;
import java.io.IOException;

import accord.app.helpers.DiscordHTTPCall;
import accord.app.helpers.TUIHelper;

import accord.app.interfaces.TUIInterface;

public class App {
    public static void main(String[] args) {

        TUIHelper tuiHelp = new TUIHelper();
        TUIInterface tui = new TUIInterface();

        if(args.length == 0 || args[0].equals( "-h")){
            tuiHelp.showHelp();
            System.exit(0);
            return;
        }

        DiscordHTTPCall loginCall = new DiscordHTTPCall();
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");
        loginCall.setHeaders(headers);
        loginCall.setRequestBodyJSON("{\"email\":\""+args[1]+"\",\"password\":\""+args[2]+"\"}");
        try {
            loginCall.login();
            tui.instantiateTerminal();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
