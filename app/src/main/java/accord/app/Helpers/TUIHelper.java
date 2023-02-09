package accord.app.helpers;

public class TUIHelper{

    public final String[] validOpts;

    public TUIHelper(){
        this.validOpts = {
            "-h",
            "-a",
            "-l",
        };
    }

    public void showHelp(){
        System.out.println("\n"+
"\n"+
"                                     _ \n"+
"     /\\                             | |\n"+
"    /  \\    ___  ___  ___   _ __  __| |\n"+
"   / /\\ \\  / __|/ __|/ _ \\ | \"__|/ _` |\n"+
"  / ____ \\| (__| (__| (_) || |  | (_| |\n"+
" /_/    \\_\\\\___|\\___|\\___/ |_|   \\__,_|\n"+
"                                       \n"+
"                                       \n"+
"\n"+           
                                       
    "This is Accord - Discord, now from the comfort of your terminal. \n"+
    "\n"+
    "the usage options are: \n"+
    "\n"+
    "-h (elp): Shows this manual. \n"+
    "\n"+
    "-l (ogin): Logs in using your email and password (second and third arguments \n"+
    "           respectively). \n"+
    "\n"+
    "-a (nonymous): Logs in with a temporary account \n");
    }

}
