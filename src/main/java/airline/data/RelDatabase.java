package airline.data;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public final class RelDatabase
{
  public static final String PROPERTIES_FILE_NAME="/connection.properties";        
  Connection cnx;
  public RelDatabase()
  {
    cnx = this.getConnection();            
  }
  public Connection getConnection()
  {
    try 
    {
      Properties prop = new Properties();
      URL resourceUrl = getClass().getResource(PROPERTIES_FILE_NAME);         
      prop.load(new BufferedInputStream(resourceUrl.openStream()));
      String driver = prop.getProperty("database_driver");
      String server = prop.getProperty("database_server");
      String port = prop.getProperty("database_port");
      String user = prop.getProperty("database_user");
      String password = prop.getProperty("database_password");
      String database = prop.getProperty("database_name");

      String URL_conexion="jdbc:mysql://"+ server+":"+port+"/"+database+
              "?useTimezone=true"+
              "&serverTimezone=UTC"+
              "&user="+user+"&password="+password+
              "&allowPublicKeyRetrieval=true"+
              "&useSSL=false";
      
      Class.forName(driver).newInstance();
      return DriverManager.getConnection(URL_conexion);
    } 
    catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) 
    {
      System.err.println(e.getMessage());
      System.exit(-1);
    } 
    return null;
  }

  public int executeUpdate(String statement) 
  {
    try 
    {
      Statement stm = cnx.createStatement();
      stm.executeUpdate(statement);
      return stm.getUpdateCount();
    } 
    catch (SQLException ex) 
    {
      System.err.println(ex.getMessage());
      return 0;
    }
  }
  public ResultSet executeQuery(String statement)
  {
    try 
    {
      Statement stm = cnx.createStatement();
      return stm.executeQuery(statement);
    } 
    catch (SQLException ex)
    {
      System.err.println(ex.getMessage());
    }
    return null;
  }
}