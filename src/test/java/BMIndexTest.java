import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class BMIndexTest {

    @Test
@Parameters(method="calcHeightMassValues")
    public void testCalculateBMI (double height, double mass, double exp){
        BodyCalculator bmi = new BMIndex(height,mass);
        assertEquals(exp,bmi.calculate());
    }

    private Object[] calcHeightMassValues() {
return new Object[]{
        new Object[]{160,90,35.2},
        new Object[]{200,117,29.3},
        new Object[]{184,85,24.3},};
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
                new Object[]{150,-1},
                new Object[]{-1,90},};
        }
     @Test
    @Parameters (method = "interpretBMIValues")
    public void testInterpretBMI (String bmi,String category){
        BodyCalculator bc =new BMIndex();
        assertEquals(category,bc.interpret());

     }
     private Object[] interpretBMIValues(){
        return new Object[]{
                new Object[]{"10", "Very severly underweight"},
                new Object[]{"15.5", "Severly underweight"},
                new Object[]{"17", "Underweight"},
                new Object[]{"20", "Normal"},
                new Object[]{"27", "Overweight"},
                new Object[]{"32.5", "Obese"},};
     }
    }

