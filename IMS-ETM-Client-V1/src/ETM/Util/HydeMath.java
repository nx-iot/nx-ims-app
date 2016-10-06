/*
 * HydeMath Module
 *  Version 1.0 (15/07/2011)
 *
 *  Author Peranitti Tuvaphanthaphiphat (PERANITTI@GMAIL.COM)
 *  Intelenics Co.,Ltd. (www.intelenics.com)
 *
 */

package ETM.Util;

public class HydeMath
{
    public static double findMax( double[] data )
    {
        int dataLength = data.length;
        if (data == null || data.length == 0)
        {
            return 0.0;
        }
        double max = data[0];
        for (int i=1;i<dataLength;i++)
        {
            if (data[i] > max)
            {
                max = data[i];
            }
        }
        return max;
    }

    public static double findMin( double[] data )
    {
        int dataLength = data.length;
        if (data == null || data.length == 0)
        {
            return 0.0;
        }
        double min = data[0];
        for (int i=1;i<dataLength;i++)
        {
            if (data[i] < min)
            {
                min = data[i];
            }
        }
        return min;
    }

    public static double average( double[] data )
    {
        int dataLength = data.length;
        double ret = 0.0;
        for (int i=0;i<dataLength;i++)
        {
            ret += data[i];
        }
        return ret/((double)dataLength);
    }

    public static double StandardDeviationMean ( double[] data )
    {
        double mean = 0;
        final int n = data.length;
        if ( n < 2 )
        {
            return Double.NaN;
        }
        for ( int i=0; i<n; i++ )
        {
            mean += data[i];
        }
        mean /= n;
        // calculate the sum of squares
        double sum = 0;
        for ( int i=0; i<n; i++ )
        {
            final double v = data[i] - mean;
            sum += v * v;
        }
        // Change to ( n - 1 ) to n if you have complete data instead of a sample.
        return Math.sqrt( sum / ( n - 1 ) );
    } 

    public static double standardDeviationCalculate ( double[] data )
    {
        final int n = data.length;
        if ( n < 2 )
        {
            return Double.NaN;
        }
        double avg = data[0];
        double sum = 0;
        for ( int i = 1; i < data.length; i++ )
        {
            double newavg = avg + ( data[i] - avg ) / ( i + 1 );
            sum += ( data[i] - avg ) * ( data [i] -newavg ) ;
            avg = newavg;
        }
        // Change to ( n - 1 ) to n if you have complete data instead of a sample.
        return Math.sqrt( sum / ( n - 1 ) );
    }

}
