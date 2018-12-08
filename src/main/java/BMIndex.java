import java.util.Arrays;

import static java.lang.Math.abs;

public class BMIndex implements BodyCalculator {
private double height;
private double mass;
    BMIndex(double height, double mass){
        if (height<=0 || mass<=0 ){
            throw new  IllegalArgumentException("Please use values greater than 0.") ;
        }else
        this.height =height;
        this.mass = mass;
    }

    @Override
    public String calculate() {
       double bmiD =  mass / Math.pow(height,2);
       String result = String.format("%.1f",bmiD);
       return result.replaceAll(",","\\.");
    }

    @Override
    public String interpret() {
        double[] breakPointValues = {15,16,18.5,25,30,35,40,45,50,60,200};
        String[] category ={"very severely underweight",
                "severely underweight",
                "underweight",
                "normal (healthy)",
                "overweight",
                "moderate obese",
                "severely obese",
                "very severely obese",
                "morbidly obese",
                "super obese",
                "hyper obese"};
        double bmi = Double.parseDouble(calculate().replaceAll(",","\\."));
        int index = abs(-1 * (Arrays.binarySearch(breakPointValues,bmi) +1));
        return category[index];
    }
}
