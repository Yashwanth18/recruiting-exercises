import java.util.HashMap;
import java.util.Map;

public class Allocation {
    Map<String,Order>shipmentMap;
    public Allocation(Map<String,Order>shipmentMap)
    {
        this.shipmentMap=shipmentMap;
    }
}
