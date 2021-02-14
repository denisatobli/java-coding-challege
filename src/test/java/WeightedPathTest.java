import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import weighted.path.WeightedPath;

public class WeightedPathTest {

    private WeightedPath weightedPath;

    @Before
    public void initWeightedPath() {
        weightedPath = new WeightedPath();
    }

    @Test
    public void testCaseOne() {
        String[] arr = new String[] { "4", "A", "B", "C", "D", "A|B|1", "B|D|9", "B|C|3", "C|D|4" };
        Assert.assertEquals("A-B-C-D", weightedPath.getWeightedPath(arr));

    }

    @Test
    public void testCaseTwo() {
        String[] arr = new String[] { "7", "A", "B", "C", "D", "E", "F", "G", "A|B|1", "A|E|9", "B|C|2", "C|D|1", "D|F|2", "E|D|6", "F|G|2" };
        Assert.assertEquals("A-B-C-D-F-G", weightedPath.getWeightedPath(arr));
    }

    @Test
    public void testCaseThree() {
        String[] arr = new String[] { "4", "A", "B", "C", "D", "A|B|2", "C|B|11", "C|D|3", "B|D|2" };
        Assert.assertEquals("A-B-D", weightedPath.getWeightedPath(arr));
    }

    @Test
    public void testCaseFour() {
        String[] arr = new String[] { "4", "x", "y", "z", "w", "x|y|2", "y|z|14", "z|y|31" };
        Assert.assertEquals("-1", weightedPath.getWeightedPath(arr));
    }

}
