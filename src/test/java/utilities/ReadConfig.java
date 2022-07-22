package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties prop;
	public ReadConfig()
	{
		//---reading from config.properties to this class------
		File src =new File ("./Configuration/config.properties");
		try
		{
			FileInputStream fis=new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);
			
		}
		catch(Exception e)
		{
			System.out.println("Exception is :"+ e.getMessage());
		}
	}
	public String getAppURL()
	{
		String url=prop.getProperty("baseURL");
		return url;
	}
	public String getUserName()
	{
		String uname=prop.getProperty("username");
		return uname;
	}
	public String getPassword()
	{
		String pwd=prop.getProperty("password");
		return pwd;
	}
	public String getChromePath()
	{
		String chromePath=prop.getProperty("chromepath");
		return chromePath;
	}
	public String getEdgePath()
	{
		String edgePath=prop.getProperty("edgepath");
		return edgePath;
	}
	public String getFirefoxPath()
	{
		String firefoxPath=prop.getProperty("firefoxpath");
		return firefoxPath;
	}
	
}
