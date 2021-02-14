import gas.station.GasStationsTour;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GasStationsTourTest {

    private GasStationsTour gasStationsTour;

    @Before
    public void initGasStationsTour() {
        gasStationsTour = new GasStationsTour();
    }

    @Test
    public void testCaseOne() {
        String[] arr = new String[] { "4", "1:1", "2:2", "1:2", "0:1" };
        Assert.assertEquals("Impossible", gasStationsTour.getStartingGasStation(arr));
    }

    @Test
    public void testCaseTwo() {
        String[] arr = new String[] { "4", "0:1", "2:2", "1:2", "3:1" };
        Assert.assertEquals("4", gasStationsTour.getStartingGasStation(arr));
    }

    @Test
    public void testCaseThree() {
        String[] arr = new String[] { "4", "3:1", "2:2", "1:2", "0:1" };
        Assert.assertEquals("1", gasStationsTour.getStartingGasStation(arr));
    }

}
