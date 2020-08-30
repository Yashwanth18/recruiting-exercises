import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class InventoryAllocator {
    public List<Allocation> inventoryAllocator(Order order, List<Warehouses>warehouses)
    {
        List<Allocation>list=new ArrayList<>();
        for(Warehouses warehouse:warehouses)
        {
            Map<String,Integer>inventoryMap=warehouse.getInventory();
            if(order.getQuantity()<inventoryMap.get(order.getItemName()))
            {

            }
        }
    }

}
