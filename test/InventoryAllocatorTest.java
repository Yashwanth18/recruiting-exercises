import org.junit.Test;

import java.util.*;
import static org.hamcrest.CoreMatchers.*;

import static org.junit.Assert.*;

public class InventoryAllocatorTest {

    private Map<String, Integer> order=new LinkedHashMap<>();  //order input
    private List<Map> testOutputList=new ArrayList<>();


    @Test
    public void shipmentFromOneWareHouse()
    {


        Map<String,Integer>map=new LinkedHashMap<>();
        map.put("apple",1);
        map.put("banana",2);
        WareHouse owd = new WareHouse("owd",map);
        List<WareHouse> warehouseList = new ArrayList<>();
        warehouseList.add(owd);

        //adding values for order
        order.put("apple",  1);
        order.put("banana",2);

        InventoryAllocator object = new InventoryAllocator();

        //dummy result data
        Map<String, HashMap<String, Integer>> outputMap = new LinkedHashMap<String, HashMap<String, Integer>>();
        HashMap<String, Integer> innerMap=new LinkedHashMap<>();
        innerMap.put("apple", 1);
        outputMap.put("owd", innerMap);
        testOutputList.add(outputMap);
        List<Map<String,Map<String,Integer>>>list=object.inventoryAllocator(order,warehouseList);

        assertEquals("[{owd={apple=1, banana=2}}]",list.toString());

    }


}
