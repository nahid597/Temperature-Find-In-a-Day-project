
/**
 * Write a description of class CSVMaxTemprature here.
 *
 * @author (Nahid Hasan)
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CSVMaxTemprature
{
   
    public CSVRecord hotestHourInDay(CSVParser parser)
    {
        CSVRecord largestSoFar = null;
        for(CSVRecord currenRow : parser)
        {
            if(currenRow == null)
            {
                largestSoFar = currenRow;
            }
            else
            {
                double currentTem = Double.parseDouble(currenRow.get("TemperatureF"));
                double largestTem = Double.parseDouble(currenRow.get("TemperatureF"));
                if(currentTem > largestTem)
                {
                    largestSoFar = currenRow;
                }
         
            }
            
            
        }
        
        return largestSoFar;
        
        
    }
    
    public void testHottestDay()
    {
        FileResource fr = new FileResource();
        CSVRecord largest = hotestHourInDay(fr.getCSVParser());
        System.out.println("Hottest temperature was: " + largest.get("TemperatureF" )+ "at" + largest.get("TimeEST"));
    }
    
    public CSVRecord testHottestManyDays()
    {
        CSVRecord largestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles())
        { 
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = hotestHourInDay(fr.getCSVParser());
             if(largestSoFar == null)
            {
                largestSoFar = currentRow;
            }
            else
            {
                double currentTem = Double.parseDouble(currentRow.get("TemperatureF"));
                double largestTem = Double.parseDouble(currentRow.get("TemperatureF"));
                if(currentTem > largestTem)
                {
                    largestSoFar = currentRow;
                }
         
            }
            
            
        }
        
        return largestSoFar;
        
            
    }
        
        
        
}
    
