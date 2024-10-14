package project.testex1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	static FileInputStream f;
    static  Properties p = new Properties();
    public static String reader(String key) throws IOException {
		
		f=new FileInputStream("C:\\Users\\arun.kumar\\Downloads\\Jagacy VT\\testex2\\jagacyVT.properties");
		p.load(f);
		return p.getProperty(key);
		

	}

}
