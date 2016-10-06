/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ETM.STRUCTURE;

/**
 *
 * @author Hyde
 */
public class SessionData
{
    public String loginUser;
    public String loginDepartment;
    public String loginUserPassword;
    public String DIR;
    public String upload;
    
    public String proxyEnable;
    public String proxyIP;
    public String proxyPort;
    public String proxyUser;
    public String proxyPass;

    public String computerName;
    public String computerIP;
    public String serverType;

    public String serverIP;
    public String serverPassword;
    public String serverImgPath;
    public String defaultDatabase;
    public String urlImgPath;

    public int FILE_SERVER_PORT;
    public int APPLICATION_PORT;
    public int SERVER_PORT;
    public int MAXIMUM_APPLICATION_THREAD;
    public int MAXIMUM_CLIENT_THREAD;

    public String userPermission;
    public String permissionManageUser;
    public String permissionManageDevice;
    public String permissionManageHost;
    public String permissionViewLog;
    public String permissionViewFloorPlan;
    public String permissionDataPresentation;
    public String permissionCrossDepartment;
    public String permissionManageMessage;
    public String permissionManageDepartment;
    
    public String popup;
    public String sms;
    public String email;
    public String serialNumber;
    
    public String popupUpper;
    public String popupUpperTime;
    public String popupUpperExtreme;
    public String popupLower;
    public String popupLowerTime;
    public String popupLowerExtreme;
    public String popupProbe;
    public String popupDevice;
    public String popupConnection;

    public SessionData()
    {
        loginUser = "";
        loginUserPassword = "";
        loginDepartment = "";
        DIR = "";
        upload = "";
        
        proxyEnable = "no";
        proxyIP = "";
        proxyPort = "";
        proxyUser = "";
        proxyPass = "";

        computerName = "";
        computerIP = "";
        serverType = "";
        defaultDatabase = "";
        urlImgPath = "";

        serverIP = "";
        serverPassword = "";
        serverImgPath = "";
        serialNumber = "";

        userPermission = "";
        permissionManageUser = "0";
        permissionManageDevice = "0";
        permissionManageHost = "0";
        permissionViewLog = "0";
        permissionViewFloorPlan = "0";
        permissionDataPresentation = "0";
        permissionCrossDepartment = "0";
        permissionManageMessage = "0";
        permissionManageDepartment = "0";
           
        popup = "1";
        sms = "1";
        email = "1";
        popupUpper = "1";
        popupUpperTime = "1";
        popupUpperExtreme = "1";
        popupLower = "1";
        popupLowerTime = "1";
        popupLowerExtreme = "1";
        popupProbe = "1";
        popupDevice = "1";
        popupConnection = "1";
    }
}
