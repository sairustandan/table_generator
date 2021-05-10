package jdbc;

public class Html extends Driver{

	public static String open(String TAG0)
    {
        return ("<" +TAG0+ ">");
    }

    public  static String close(String TAG1)
    {
        return ("</"+TAG1+">");
    }

	public static String getTitle(String string) {
		String Title = open("Title") + "Generator" + close("Title"); 
		return Title; 
	}

	public static String getLabel(String string) {
	      String makeLabel = open("h2") + "Customer Table" + close("h2");
	      return makeLabel;
	}
}
