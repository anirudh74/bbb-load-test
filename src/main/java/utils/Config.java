package utils;


import static utils.ConfigUtil.getProperty;


public class Config {

    public static final String URL= getProperty("URL");
    public static final int NUMBEROFUSERS= Integer.parseInt(System.getenv("users"));
    public static int ITERATION= Integer.parseInt(System.getenv("iteration"));
    public static final String BROWSER= getProperty("BROWSER");
}
