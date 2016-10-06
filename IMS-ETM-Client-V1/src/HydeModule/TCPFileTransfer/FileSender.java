package HydeModule.TCPFileTransfer;


import java.io.OutputStream;
import java.io.File;

import java.net.Socket;


public class FileSender
{

  public static void send(String host, int port, String file, String destination)
  {
    try
    {
        Socket socket = new Socket(host, port);
        OutputStream os     = socket.getOutputStream();

        ByteStream.toStream(os, 1);
        ByteStream.toStream(os, destination);
        ByteStream.toStream(os, new File(file));
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }

  public static void multipleSend(String host, int port, String[] file, String[] destination)
  {
    try
    {
      Socket socket = new Socket(host, port);
      OutputStream os     = socket.getOutputStream();

      ByteStream.toStream(os, file.length);

      for (int currentFile=0; currentFile<file.length; currentFile++)
      {
        ByteStream.toStream(os, destination[currentFile]);
        ByteStream.toStream(os, new File(file[currentFile]));
      }
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
