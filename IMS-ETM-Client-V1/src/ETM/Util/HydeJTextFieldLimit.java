/*
 * HydeJTextFieldLimit Module
 *  Version 1.1 (19/08/2011)
 *
 *  Author Peranitti Tuvaphanthaphiphat (PERANITTI@GMAIL.COM)
 *  Intelenics Co.,Ltd. (www.intelenics.com)
 *
 */

package ETM.Util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class HydeJTextFieldLimit extends PlainDocument
{
  public int limit;
  public int mode;

  public static int MODE_TEXT_WITH_LIMIT = 0;
  public static int MODE_UNSIGNED_INTEGER_WITH_LIMIT = 1;
  public static int MODE_UNSIGNED_FLOATING_1POINT_WITH_LIMIT = 2;
  public static int MODE_INTEGER_WITH_LIMIT = 3;
  public static int MODE_FLOATING_1POINT_WITH_LIMIT = 4;
  public static int MODE_IP_SEGMENT = 5;


  public HydeJTextFieldLimit(int limit, int mode)
  {
    super();
    this.limit = limit;
    this.mode = mode;
  }

  @Override
  public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException
  {
    if (str == null)
      return;
  
    try
    {
        if (mode == MODE_UNSIGNED_INTEGER_WITH_LIMIT)
        {
            int temp = Integer.parseInt(str);
        }
        else if (mode == MODE_IP_SEGMENT)
        {
            int temp = Integer.parseInt(str);
        }
        else if(mode == MODE_INTEGER_WITH_LIMIT)
        {
            if (str.indexOf("-") == 0)
            {
                if (super.getText(0, 1).equals("-"))
                {
                    int temp = Integer.parseInt(str.substring(1));
                }
                else
                {
                    int temp = Integer.parseInt(str);
                }
            }
        }
        else if (mode == MODE_UNSIGNED_FLOATING_1POINT_WITH_LIMIT)
        {
            if (str.indexOf("-") > -1 && offset == 0)
                {
                    String inField = super.getText(0, super.getLength());
                    if (inField.indexOf("-") > -1)
                    {
                        return;
                    }
                    else
                    {
                        if (str.length() > 1)
                        {
                            int temp = Integer.parseInt(str.substring(1));
                        }
                    }
                }
                else
                {
                    int temp = Integer.parseInt(str);
                }
        }
        else if (mode == MODE_FLOATING_1POINT_WITH_LIMIT)
        {
            if(str.indexOf(".") > -1)
            {
                String inField = super.getText(0, super.getLength());
                if (inField.indexOf(".") > -1)
                {
                    return;
                }
            }
            else
            {
                if (str.indexOf("-") > -1 && offset == 0)
                {
                    String inField = super.getText(0, super.getLength());
                    if (inField.indexOf("-") > -1)
                    {
                        return;
                    }
                    else
                    {
                        if (str.length() > 1)
                        {
                            int temp = Integer.parseInt(str.substring(1));
                        }
                    }
                }
                else
                {
                    int temp = Integer.parseInt(str);
                }
            }
        }
        if ((getLength() + str.length()) <= limit)
        {
            if (mode == MODE_IP_SEGMENT)
            {
                String ss = super.getText(0, offset)+str;
                if (Integer.parseInt(ss) > 255)
                {
                    super.remove(0, offset);
                    super.insertString(0, "255", attr);
                    return;
                }
                else
                {
                    super.remove(0, offset);
                    super.insertString(0, Integer.parseInt(ss)+"", attr);
                    return;
                }
            }
            super.insertString(offset, str, attr);
        }
    }
    catch (NumberFormatException e)
    { }
  }
}

