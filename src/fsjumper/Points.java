
package fsjumper;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Random;

/**
 * Points class used to randomly select points.
 * @author Michael Telford
 */
public class Points {

    private int numPoints = 3;
    private String[] points;
    private Dictionary dict;
    private Random rand;

    public Points(){
        points = new String[numPoints];
        dict = new Hashtable();
        rand = new Random();
        initDictionary();
    }

    private void initDictionary() {
        dict.put("1",  "A");
        dict.put("2",  "B");
        dict.put("3",  "C");
        dict.put("4",  "D");
        dict.put("5",  "E");
        dict.put("6",  "F");
        dict.put("7",  "G");
        dict.put("8",  "H");
        dict.put("9",  "J");
        dict.put("10", "K");
        dict.put("11", "L");
        dict.put("12", "M");
        dict.put("13", "N");
        dict.put("14", "O");
        dict.put("15", "P");
        dict.put("16", "Q");
    }

    private int getRandomNumber(){
        return (rand.nextInt(dict.size()) + 1);
    }

    public String[] getRandomPoints(){
        String currentPoint = null, previousPoint = null;
        for (int i = 0; i < points.length; i++){
            try {
                do {
                    currentPoint = (String) dict.get(
                            String.valueOf(getRandomNumber()));
                }
                while (currentPoint.equals(previousPoint) ||
                       currentPoint.equals(points[0]));
            }
            catch (Exception ex){
                /* Do nothing if previousPoint or points[0] is not set yet */
            }
            points[i] = currentPoint;
            previousPoint = currentPoint;
        }
        return points;
    }
}