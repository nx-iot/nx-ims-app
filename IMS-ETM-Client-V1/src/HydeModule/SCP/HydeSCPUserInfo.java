/*
 * HydeSCPUserInfo Module
 *  Version 1.0 (01/07/2009)
 *
 *  Author Peranitti Tuvaphanthaphiphat (PERANITTI@GMAIL.COM)
 *  Intelenics Co.,Ltd. (www.intelenics.com)
 *
 */

package HydeModule.SCP;

import com.jcraft.jsch.*;

public class HydeSCPUserInfo implements UserInfo, UIKeyboardInteractive
{
    public HydeSCPUserInfo(String pass)
    {
        passwd = pass;
    }
    public String getPassword(){ return passwd; }
    public boolean promptYesNo(String str)
    {
       return true;
    }

    String passwd;

    public String getPassphrase(){ return null; }
    public boolean promptPassphrase(String message){ return true; }
    public boolean promptPassword(String message)
    {
        //passwd=message;
        return true;
    }
    public void showMessage(String message)
    {
        System.out.println("MSG:"+message);
    }
    
    public String[] promptKeyboardInteractive(String destination,
                                              String name,
                                              String instruction,
                                              String[] prompt,
                                              boolean[] echo)
    {
        return null;
    }
  }