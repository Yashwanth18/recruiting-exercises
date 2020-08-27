import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class InventoryAllocatorTest {




    @Test
    public void shipmentFromOneWareHouse()
    {

        Map<String,Integer> orderMap=new HashMap<>();
        String wareHouseName1="owd";
        Map<String,Integer>inventoryMap1=new HashMap<>();
        inventoryMap1.put("apple",1);
        Warehouses warehouses=new Warehouses(wareHouseName1,inventoryMap1);
        List<Warehouses> listOfWareHouses=new ArrayList<>();
        listOfWareHouses.add(warehouses);
        InventoryAllocator inventoryAllocator=new InventoryAllocator();
        Order order=new Order("apple",5);
        Map<String,Order>shipmentMap=new HashMap<>();
        shipmentMap.put("owd",order);
        Allocation allocation=new Allocation(shipmentMap);
        List<Allocation>allocations=new ArrayList<>();
        allocations.add(allocation);
        assertEquals(allocations,inventoryAllocator.inventoryAllocator(orderMap,listOfWareHouses));
    }

    @Test
    public void shipmentFromMultipleWareHouses()
    {

    }

    @Test
    public void notEnoughInventory()
    {

    }
}
