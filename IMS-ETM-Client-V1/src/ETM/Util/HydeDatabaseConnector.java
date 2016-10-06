/*
 * HydeDatabaseConnector Module
 *  Version 1.27 (03/10/2011)
 *
 *  Author Peranitti Tuvaphanthaphiphat (PERANITTI@GMAIL.COM)
 *
 */

package ETM.Util;

import java.sql.*;
import java.text.*;
import java.util.*;

public class HydeDatabaseConnector
{
    public Connection con;
    public boolean loop;

    public String   hostIP,
                    database,
                    username,
                    password,
                    tempPO;

    public boolean autoReconnect = false;

    public SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public SimpleDateFormat SDF_GMT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public DecimalFormat decimalFormat = new DecimalFormat("#0000");

    public boolean DEBUG;
    public String currentDatabase;

    public HydeDatabaseConnector()
    {
        DEBUG = false;
	SDF_GMT.setTimeZone(TimeZone.getTimeZone("GMT"));
    }

    public boolean connect(String hostIP, String database, String username, String password, boolean autoReconnect)
    {
        this.autoReconnect = autoReconnect;
        this.hostIP   = hostIP;
        this.database = database;
        this.username = username;
        this.password = password;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://"+hostIP+"/"+database+"?user="+username+"&password="+password+"&characterEncoding=tis620");
            currentDatabase = database;
            reconnectCount = 0;
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public boolean connect(String[] dbData, boolean autoReconnect)
    {
        this.autoReconnect = autoReconnect;
        hostIP   = dbData[0];
        database = dbData[1];
        username = dbData[2];
        password = dbData[3];
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://"+hostIP+"/"+database+"?user="+username+"&password="+password+"&characterEncoding=tis620");
            currentDatabase = database;
            reconnectCount = 0;
            return true;
        }
        catch (Exception e)
        {
            System.out.println("HydeDatabaseConnector/Connect : "+e);
            e.printStackTrace();
            return false;
        }
    }

    public void setAutoReconnect(boolean autoReconnect)
    {
        this.autoReconnect = autoReconnect;
    }

    public int reconnectCount = 0;
    public boolean reconnect()
    {
        reconnectCount++;
        if (reconnectCount > 3) return false;
        if (autoReconnect && hostIP != null && database != null && username != null && password != null)
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                con = DriverManager.getConnection("jdbc:mysql://"+hostIP+"/"+database+"?user="+username+"&password="+password+"&characterEncoding=tis620");
                currentDatabase = database;
                reconnectCount = 0;
                return true;
            }
            catch (Exception e)
            {
                System.out.println("HydeDatabaseConnector/Reconnect : "+e);
                e.printStackTrace();
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    //com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException
    public boolean changeDatabase(String db)
    {
        try
        {
            Statement stmt = con.createStatement();
            stmt.execute("use "+db+";");
            stmt.close();
            currentDatabase = db;
            return true;
        }
        catch (Exception e)
        {
            System.out.println("HydeDatabaseConnector/changeDatabase : "+e);
            System.out.println("Change DB to : "+db);
            e.printStackTrace();
            return false;
        }
    }

    public String getNextIncrement(String table)
    {
        String nai = null;
        try
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT AUTO_INCREMENT "
                    + "FROM information_schema.tables "
                    + "WHERE table_name = '"+table+"' "
                    + "AND table_schema = database();");
            while (rs.next())
            {
                nai = rs.getString(1);
            }
            stmt.close();
            return nai;
        }
        catch (com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException e)
        {
            System.out.println("Database no connection... reconnect...");
            if (reconnect())
            {
                return getNextIncrement(table);
            }
            else
            {
                return null;
            }
        }
        catch(Exception e)
        {
            System.out.println("HydeDatabaseConnector/getNextIncrement : "+e);
            System.out.println("Table : "+table);
            e.printStackTrace();
            return null;
        }
    }

    public boolean customUpdate(String cmd)
    {
        try
        {
            Statement stmt = con.createStatement();
            int c = 0;
            int c2 = cmd.indexOf(";",c);
            while (c2 != -1)
            {
                stmt.executeUpdate(cmd.substring(c,c2+1));
                c = c2+1;
                c2 = cmd.indexOf(";",c);
            }
            stmt.close();
            return true;
        }
        catch (com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException e)
        {
            System.out.println("Database no connection... reconnect...");
            if (reconnect())
            {
                return customUpdate(cmd);
            }
            else
            {
                return false;
            }
        }
        catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e)
        {
            System.out.println("HydeDatabaseConnector/customUpdate : "+e);
            System.out.println("Command : "+cmd);
            return false;
        }
        catch(Exception e)
        {
            System.out.println("HydeDatabaseConnector/customUpdate : "+e);
            System.out.println("Command : "+cmd);
            e.printStackTrace();
            return false;
        }
    }
    
    public int insertAndReturnAIID(String cmd)
    {
        try
        {
            Statement stmt = con.createStatement();
            int c = 0;
            int c2 = cmd.indexOf(";",c);
            while (c2 != -1)
            {
                stmt.executeUpdate(cmd.substring(c,c2+1),Statement.RETURN_GENERATED_KEYS);
                c = c2+1;
                c2 = cmd.indexOf(";",c);
            }
            
            int autoIncKeyFromApi = -1;
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) 
            {
                autoIncKeyFromApi = rs.getInt(1);
            } 
            else 
            {

            }
            rs.close();
            stmt.close();
            return autoIncKeyFromApi;
        }
        catch (com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException e)
        {
            System.out.println("Database no connection... reconnect...");
            if (reconnect())
            {
                return insertAndReturnAIID(cmd);
            }
            else
            {
                return -1;
            }
        }
        catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e)
        {
            System.out.println("HydeDatabaseConnector/customUpdate : "+e);
            System.out.println("Command : "+cmd);
            return -1;
        }
        catch(Exception e)
        {
            System.out.println("HydeDatabaseConnector/customUpdate : "+e);
            System.out.println("Command : "+cmd);
            e.printStackTrace();
            return -1;
        }
    }

    public String query0(String cmd)
    {
        String S = null;
        try
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(cmd);
            while (rs.next())
            {
                S = rs.getString(1);
            }
            stmt.close();
            return S;
        }
        catch (com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException e)
        {
            System.out.println("Database no connection... reconnect...");
            if (reconnect())
            {
                return query0(cmd);
            }
            else
            {
                return null;
            }
        }
        catch (Exception e)
        {
            System.out.println("HydeDatabaseConnector/query0 : "+e);
            System.out.println("Command : "+cmd);
            e.printStackTrace();
            return null;
        }
    }

    public Vector queryColumn(String cmd)
    {
        Vector V = new Vector();
        try
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(cmd);
            while (rs.next())
            {
                V.add(rs.getString(1));
            }
            stmt.close();
            return V;
        }
        catch (com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException e)
        {
            System.out.println("Database no connection... reconnect...");
            if (reconnect())
            {
                return queryColumn(cmd);
            }
            else
            {
                return null;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public Vector queryRow(String sql)
    {
        Vector V = new Vector();
        try
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next())
            {
                for (int j = 1; j<=rsmd.getColumnCount(); j++)
                {
                    V.add(rs.getString(j));
                }
            }
            stmt.close();
            return V;
        }
        catch (com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException e)
        {
            System.out.println("Database no connection... reconnect...");
            if (reconnect())
            {
                return queryRow(sql);
            }
            else
            {
                return null;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
  
    public Vector<Vector> customQuery(String cmd)
    {
        Vector<Vector> VSS = new Vector();
        try
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(cmd);
            ResultSetMetaData rsmd = rs.getMetaData();
            Vector<String> VSC = new Vector();
            for (int i = 1; i<=rsmd.getColumnCount(); i++)
            {
                VSC.add(rsmd.getColumnName(i));
            }
            VSS.add(VSC);
            while (rs.next())
            {
                Vector<String> VSR = new Vector();
                for (int j = 1; j<=rsmd.getColumnCount(); j++)
                {
                    VSR.add(rs.getString(j));
                }
                VSS.add(VSR);
            }
            stmt.close();
            return VSS;
        }
        catch (com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException e)
        {
            System.out.println("Database no connection... reconnect...");
            if (reconnect())
            {
                return customQuery(cmd);
            }
            else
            {
                return null;
            }
        }
        catch (Exception e)
        {
            System.out.println("HydeDatabaseConnector/customQuery : "+e);
            System.out.println("Command : "+cmd);
            e.printStackTrace();
            return null;
        }
    }

    public Vector<Vector> queryAll(String sql)
    {
        Vector<Vector> VSS = new Vector();
        try
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            ResultSetMetaData rsmd = rs.getMetaData();
            Vector<String> VSC = new Vector();
            for (int i = 1; i<=rsmd.getColumnCount(); i++)
            {
                VSC.add(rsmd.getColumnLabel(i));
            }
            VSS.add(VSC);
            while (rs.next()) {
                Vector<String> VSR = new Vector();
                for (int j = 1; j<=rsmd.getColumnCount(); j++)
                {
                    VSR.add(rs.getString(j));
                }
                VSS.add(VSR);
            }
            stmt.close();
            return VSS;
        }
        catch (com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException e)
        {
            System.out.println("Database no connection... reconnect...");
            if (reconnect())
            {
                return queryAll(sql);
            }
            else
            {
                return null;
            }
        }
        catch (Exception e)
        {
            System.out.println("HydeDatabaseConnector/queryAll : "+e);
            System.out.println("Command : "+sql);
            e.printStackTrace();
            return null;
        }
    }

    public void closeDB()
    {
        try
        {
            con.close();
        }
        catch (Exception e)
        {  }
    }

    public boolean customExport(String query)
    {
        Statement stmt;
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            //For comma separated file
            stmt.executeQuery(query);
            stmt.close();
            return true;
        }
        catch (com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException e)
        {
            System.out.println("Database no connection... reconnect...");
            if (reconnect())
            {
                return customExport(query);
            }
            else
            {
                return false;
            }
        }
        catch(Exception e)
        {
            stmt = null;
            System.out.println("HydeDatabaseConnector/customExport : "+e);
            System.out.println("Command : "+query);
            e.printStackTrace();
            return false;
        }
    }

    public boolean importData(String filename, String table)
    {
        Statement stmt;
        String query;
        try {
            stmt = con.createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);

            //For comma separated file
            query = "LOAD DATA LOCAL INFILE '"+filename+"' "
                    +"INTO TABLE "+table+" "
                    +"FIELDS TERMINATED BY ',' "
                    +"LINES TERMINATED BY '\n' ;";

            stmt.executeUpdate(query);
            stmt.close();
            return true;
        }
        catch(Exception e)
        {
            stmt = null;
            System.out.println("HydeDatabaseConnector/importData : "+e);
            System.out.println("Table : "+table);
            e.printStackTrace();
            return false;
        }
    }

    public boolean exportAll(String folder, String database)
    {
        changeDatabase(database);
        Vector v = queryColumn("show tables;");
        if (v != null)
        {
            Enumeration enu = v.elements();
            while (enu.hasMoreElements())
            {
                String table = (String) enu.nextElement();
                Statement stmt;
                String query;
                try {
                    stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                            ResultSet.CONCUR_UPDATABLE);

                    //For comma separated file
                    query = "SELECT * into OUTFILE '"+folder+"/"+table+".csv' "
                          + "FIELDS TERMINATED BY ',' "
                          + "FROM "+table+";";
                    stmt.executeQuery(query);
                    stmt.close();
                    return true;
                }
                catch(Exception e)
                {
                    stmt = null;
                    System.out.println("HydeDatabaseConnector/exportData : "+e);
                    System.out.println("Table : "+table);
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return false;
    }

    public boolean exportData(String filename, String table)
    {
        Statement stmt;
        String query;
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            //For comma separated file
            query = "SELECT * into OUTFILE  '"+filename+
                    "' FIELDS TERMINATED BY ',' FROM "+table+";";
            stmt.executeQuery(query);
            stmt.close();
            return true;
        }
        catch(Exception e)
        {
            stmt = null;
            System.out.println("HydeDatabaseConnector/exportData : "+e);
            System.out.println("Table : "+table);
            e.printStackTrace();
            return false;
        }
    }

    public String getCurrentDateTime()
    {
        String time = "";
        java.util.Date d = new java.util.Date();
        time = SDF.format(d);
        return time;
    }
    
    public String getCurrentDateTimeGMT() throws ParseException
    {
        String time = "";
        java.util.Date d = new java.util.Date();
        time = SDF.format(SDF.parse( SDF_GMT.format(d)));
        return time;
    }

    public String formatDateTime(java.util.Date d)
    {
        return SDF.format(d);
    }
    public java.util.Date parseDateTime(String dstr)
    {
        try
        {
            return SDF.parse(dstr);
        }
        catch (Exception e)
        {
            return null;
        }
    }
}


