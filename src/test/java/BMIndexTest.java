import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class BMIndexTest {

    @Test
@Parameters(method="calcHeightMassValues")
    public void testCalculateBMI (double height, double mass, String exp){
        BodyCalculator bmi = new BMIndex(height,mass);
        assertEquals(exp,bmi.calculate());
    }

    private Object[] calcHeightMassValues() {
return new Object[]{
        new Object[]{1.60,90,35.2},
        new Object[]{2.00,117,29.3},
        new Object[]{1.84,85,25.1},};
    }
    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "calcHeightMassIllegalValues")
    public void testBMIndexConstructor(double height, double mass){
        new BMIndex(height,mass);

    }

    private Object[] calcHeightMassIllegalValues(){
        return new Object[]{
                new Object[]{0,0},
                new Object[]{-1,0},
                new Object[]{0,-1},
                new Object[]{-1,-1},
                new Object[]{1.50,-1},
                new Object[]{-1,90},};
        }
     @Test
    @Parameters (method = "interpretBMIValues")
    public void testInterpretBMI (double mass, double height, String category){
        BodyCalculator bc =new BMIndex(height,mass);
        assertEquals(category,bc.interpret());

     }
     private Object[] interpretBMIValues(){
        return new Object[]{
                new Object[]{30,  1.80, "very severely underweight"},
                new Object[]{24,  1.25, "severely underweight"},
                new Object[]{30,  1.30, "underweight"},
                new Object[]{27, 1.20, "normal (healthy)"},
                new Object[]{40, 1.20, "overweight"},
                new Object[]{50,  1.20, "moderate obese"},
                new Object[]{55,  1.20, "severely obese"},
                new Object[]{60,  1.20, "very severely obese"},
                new Object[]{70,  1.20, "morbidly obese"},
                new Object[]{80,  1.20 , "super obese"},
                new Object[]{120, 1.20, "hyper obese"}
        };
     }
    }

