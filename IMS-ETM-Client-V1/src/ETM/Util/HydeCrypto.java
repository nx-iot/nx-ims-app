/*
 * HydeCrypto Module
 *  Version 0.8 (01/04/2011)
 *
 *  Author Peranitti Tuvaphanthaphiphat (PERANITTI@GMAIL.COM)
 *  Intelenics Co.,Ltd. (www.intelenics.com)
 *
 */

package ETM.Util;



import javax.crypto.*;
import java.io.*;
import java.security.spec.KeySpec;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class HydeCrypto
{
    /* Create Key to a file
     *
     * ex. HydeCrypto.createKey(56,"C:/key1.key","Blowfish");
     *
     */
    public static void createKey(int keySize, String path, String algorithm)
    {
        try
        {
            KeyGenerator kg = KeyGenerator.getInstance(algorithm);
            kg.init(keySize);

            SecretKey ky = kg.generateKey();
            String fl = path;
            FileOutputStream fos = new FileOutputStream(fl);
            byte[] kb = ky.getEncoded();
            fos.write(kb);
            fos.close();
        }
        catch (Exception e)
        {
            System.out.println("Exception : HydeCrypto/createKey");
        }
   }

    /* Load Key From a File
     *
     * SecretKey SK = HydeCrypto.loadKey("C:/key1.key", "Blowfish");
     *
     */
    public  static SecretKey loadKey(String path, String algorithm)
    {
        try
        {
            String fl = path;
            FileInputStream fis = new FileInputStream(fl);
            int kl = fis.available();
            byte[] kb = new byte[kl];
            fis.read(kb);
            fis.close();
            KeySpec ks = null;
            SecretKey ky = null;
            SecretKeyFactory kf = null;
            if (algorithm.equalsIgnoreCase("DES"))
            {
                ks = new DESKeySpec(kb);
                kf = SecretKeyFactory.getInstance("DES");
                ky = kf.generateSecret(ks);
            }
            else if (algorithm.equalsIgnoreCase("DESede"))
            {
                ks = new DESedeKeySpec(kb);
                kf = SecretKeyFactory.getInstance("DESede");
                ky = kf.generateSecret(ks);
            }
            else
            {
                ks = new SecretKeySpec(kb,algorithm);
                ky = new SecretKeySpec(kb,algorithm);
            }
            //System.out.println(ky.toString());
            return ky;
        }
        catch (Exception e)
        {
            System.out.println("Exception : HydeCrypto/loadKey");
            return null;
        }
    }

    /* Load Key from a file to Key<String>
     *
     * String keyString = HydeCrypto.loadKeyToString("C:/key1.key");
     */
    public static String loadKeyToString(String path)
    {
        try
        {
            String fl = path;
            FileInputStream fis = new FileInputStream(fl);
            int kl = fis.available();
            byte[] kb = new byte[kl];
            fis.read(kb);
            fis.close();
            String keyString = "";
            for (int i=0; i<kb.length; i++)
            {
                keyString += toHexString(kb[i]);
            }
            return keyString;
        }
        catch (Exception e)
        {
            System.out.println("Exception : HydeCrypto/loadKey");
            return null;
        }
    }

    /* Load Key<String> to Key
     *
     * String keyString = HDC.query0("SELECT secret_key FROM secret WHERE secret_id = 1;");
     * SecretKey SK = HydeCrypto.loadStringToKey(keyString, "Blowfish");
     */
    public static SecretKey loadStringToKey(String keyString, String algorithm)
    {
        try
        {
            byte[] rec = new byte[1024];
            for (int i=0; i<keyString.length(); i+=2)
            {
                rec[i/2] = (byte) Integer.parseInt((keyString.charAt(i)+""+keyString.charAt(i+1)),16);
            }
            byte[] kb = trimByte(rec);
            
            KeySpec ks = null;
            SecretKey ky = null;
            SecretKeyFactory kf = null;
            if (algorithm.equalsIgnoreCase("DES"))
            {
                ks = new DESKeySpec(kb);
                kf = SecretKeyFactory.getInstance("DES");
                ky = kf.generateSecret(ks);
            }
            else if (algorithm.equalsIgnoreCase("DESede"))
            {
                ks = new DESedeKeySpec(kb);
                kf = SecretKeyFactory.getInstance("DESede");
                ky = kf.generateSecret(ks);
            }
            else
            {
                ks = new SecretKeySpec(kb,algorithm);
                ky = new SecretKeySpec(kb,algorithm);
            }
            //System.out.println(ky.toString());
            return ky;
        }
        catch (Exception e)
        {
            System.out.println("Exception : HydeCrypto/loadKey");
            return null;
        }
    }

    /* Encrypt to a file
     *
     * encrypt("C:/enc1.enc","password",SK,"Blowfish");
     *
     */

    public static boolean encrypt(String path, String pass, SecretKey SK, String algo)
    {
        try
        {
            Cipher cipher1 = Cipher.getInstance(algo);
            cipher1.init(Cipher.ENCRYPT_MODE, SK);

            byte[] cipherText = cipher1.doFinal(pass.getBytes());

            FileOutputStream fos;
            fos = new FileOutputStream(path);
            fos.write(cipherText, 0, cipherText.length);
            fos.close();
            return true;
        }
        catch (Exception e)
        {
            System.out.println("Exception : HydeCrypto/encrypt");
            return false;
        }
    }

    /* Encrypted the original string to encrypted PASSWORD<string>
     *
     * HydeCrypto.encryptToString("password", SK, "Blowfish")
     *
     */
    public static String encryptToString(String pass, SecretKey SK, String algo)
    {
        try
        {
            Cipher cipher1 = Cipher.getInstance(algo);
            cipher1.init(Cipher.ENCRYPT_MODE, SK);

            byte[] cipherText = cipher1.doFinal(pass.getBytes());
            /*FileWriter fw;
            fw = new FileWriter(path);
            for (int i=0; i<cipherText.length; i++)
            {
                fw.write(toHexString(cipherText[i]));
                System.out.println(cipherText[i]);
            }
            fw.close();*/
            String cipherString = "";
            for (int i=0; i<cipherText.length; i++)
            {
                cipherString += toHexString(cipherText[i]);
            }
            return cipherString;
        }
        catch (Exception e)
        {
            System.out.println("Exception : HydeCrypto/encrypt");
            return null;
        }
    }

    public static String toHexString(int d)
    {
        String s = (Integer.toHexString(d)).toUpperCase();
        if (s.length() == 1) s = "0"+s;
        if (s.length() > 2) s = s.substring(s.length()-2,s.length());
        return s;
    }


    /* Decrypt from a file
     *
     * String decString = HydeCrypto.decrypt("C:/enc1.enc",SK,"Blowfish");
     *
     */
    public static String decrypt(String path, SecretKey SK, String algo)
    {
        try
        {
            Cipher cipher1 = Cipher.getInstance(algo);
            cipher1.init(Cipher.DECRYPT_MODE, SK);

            FileInputStream fis;
            fis = new FileInputStream(path);
            byte[] rec = new byte[1024];
            int i = fis.read(rec);
            while (i != -1)
            {
                 i = fis.read(rec);
            }
            byte[] encryptedData = trimByte(rec);
            byte[] decryptedData = cipher1.doFinal(encryptedData);
            return new String(decryptedData);
        }
        catch (Exception e)
        {
            System.out.println("Exception : HydeCrypto/decrypt");
            return "";
        }
    }

    /* Decrypted the encrypted PASSWORD<String> to original string
     * 
     * HydeCrypto.decryptFromString(encryptedString, SK2, "Blowfish")
     *
     */
    public static String decryptFromString(String encryptedString, SecretKey SK, String algo)
    {
        try
        {
            Cipher cipher1 = Cipher.getInstance(algo);
            cipher1.init(Cipher.DECRYPT_MODE, SK);

            /*FileReader fr;
            fr = new FileReader(path);
            String sr = "";

            int r = 0;
            byte[] rec = new byte[1024];
            int count = 0;
            r =  fr.read();
            while (r != -1)
            {
                sr += (char) r;
                r =  fr.read();
            }*/
            byte[] rec = new byte[1024];
            for (int i=0; i<encryptedString.length(); i+=2)
            {
                rec[i/2] = (byte) Integer.parseInt((encryptedString.charAt(i)+""+encryptedString.charAt(i+1)),16);
            }
            byte[] encryptedData = trimByte(rec);
            byte[] decryptedData = cipher1.doFinal(encryptedData);
            return new String(decryptedData);
        }
        catch (Exception e)
        {
            System.out.println("Exception : HydeCrypto/decrypt" +e);
            return "";
        }
    }

    public static byte[] trimByte(byte[] inByte)
    {
        int counter = 0;
        int i = 0;
        while (inByte[i] != 0)
        {
            i++;
            counter++;
        }
        byte[] returnByte = new byte[counter];
        for (int j=0; j<counter;j++)
        {
            returnByte[j] = inByte[j];
        }

        return returnByte;
    }

    public static byte[] trimByte(byte[] inByte,int length)
    {
        byte[] returnByte = new byte[length];
        for (int j=0; j<length;j++)
        {
            returnByte[j] = inByte[j];
        }

        return returnByte;
    }

    public static byte[] concat(byte[] A, byte[] B)
    {
        byte[] C= new byte[A.length+B.length];
        System.arraycopy(A, 0, C, 0, A.length);
        System.arraycopy(B, 0, C, A.length, B.length);
        return C;
    }
}

