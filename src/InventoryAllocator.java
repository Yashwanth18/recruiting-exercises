import java.util.*;

public class InventoryAllocator {


    public List<Map<String,Map<String,Integer>>> inventoryAllocator(Map<String, Integer> order, List<WareHouse> listOfWareHouses)
    {

        if(listOfWareHouses.size()==0 || order.size()==0)
        {
            return new ArrayList<>();
        }

        List<Map<String,Map<String,Integer>>> listOfAllocations = new ArrayList<>();
        Map<String, Map<String, Integer>> shipmentMap = new LinkedHashMap<>();

        for (String itemName : order.keySet())
        {
            int quantity = order.get(itemName);
            if(quantity<=0)
            {
                return listOfAllocations;
            }
            for (WareHouse wareHouse : listOfWareHouses)
            {
                Map<String, Integer> updateMap = shipmentMap.getOrDefault(wareHouse.getWarehouseName(), new LinkedHashMap<>());
                updateMap.put(itemName, wareHouse.getItemQuantity(itemName));

                if (quantity <= 0)
                {
                    break;
                }

                else if (quantity > wareHouse.getItemQuantity(itemName))
                {
                    quantity = quantity - wareHouse.getItemQuantity(itemName);
                    shipmentMap.put(wareHouse.getWarehouseName(), updateMap);

                }

                else {
                    quantity = 0;
                    shipmentMap.put(wareHouse.getWarehouseName(), updateMap);
                    break;
                }
            }

            if (quantity != 0)
            {
                return new ArrayList<>();
            }

        }


        for(String itemName : shipmentMap.keySet())
        {
            Map<String, Map<String, Integer>> listOfAllocationsMap = new LinkedHashMap<>();
            listOfAllocationsMap.put(itemName, shipmentMap.get(itemName));
            listOfAllocations.add(listOfAllocationsMap);
        }

        return listOfAllocations;

    }
}
