package pageObjects;

//Page objects would hold page and element data specific to a given page.
//Would also hold helper functions (ie for a sign in page, could have helper function that fills in the necessary fields with arguments from function and clicks log in)
public class HomePage 
{
	
	public final static String aumniUrl = "https:\\aumni.fund";
	public final static String title = "Aumni — Investment Analytics for the Private Capital Markets";
	public final static String navLogo = "//div [@class=\"nav-logo\"]";
	public final static String bookADemoButton = "//a [@href=\"/demo\"][@class=\"btn w-button\"]";
	public final static String banner = "//div [@role=\"banner\"]";
}
