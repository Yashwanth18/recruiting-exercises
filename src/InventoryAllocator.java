import java.util.*;

public class InventoryAllocator {


    public List<Map> inventoryAllocator(Map<String, Integer> order, List<WareHouse> listOfWareHouses)
    {

        if(listOfWareHouses.size()==0 || order.size()==0)
        {
            return new ArrayList<>();
        }

        List<Map> listOfAllocations = new ArrayList<>();
        Map<String, Map<String, Integer>> currentMap = new LinkedHashMap<>();

        for (String itemName : order.keySet())
        {
            int currentCount = order.get(itemName);
            if(currentCount<=0)
            {
                return listOfAllocations;
            }
            for (WareHouse currentWareHouse : listOfWareHouses)
            {
                if (currentWareHouse.getInventory().size() == 0)
                {
                    continue;
                }
                String currentWareHouseName = currentWareHouse.getWarehouseName();
                int currentWareHouseItemQuantity = currentWareHouse.getItemQuantity(itemName);


                if (currentWareHouseItemQuantity <= 0)
                {
                    continue;
                }

                if (currentCount <= 0)
                {
                    break;
                }
                else if (currentCount > currentWareHouseItemQuantity)
                {
                    currentCount = currentCount - currentWareHouseItemQuantity;
                    Map<String, Integer> temp = currentMap.getOrDefault(currentWareHouseName, new LinkedHashMap<>());
                    temp.put(itemName, currentWareHouseItemQuantity);
                    currentMap.put(currentWareHouseName, temp);

                }
                else {
                    currentCount = 0;
                    Map<String, Integer> temp = currentMap.getOrDefault(currentWareHouseName, new LinkedHashMap<>());
                    temp.put(itemName, currentWareHouseItemQuantity);
                    currentMap.put(currentWareHouseName, temp);
                    break;
                }
            }

            if (currentCount != 0)
            {
                return new ArrayList<>();
            }

        }


        for(String itemName : currentMap.keySet())
        {
            Map<String, Map<String, Integer>> listOfAllocationsMap = new LinkedHashMap<>();
            listOfAllocationsMap.put(itemName, currentMap.get(itemName));
            listOfAllocations.add(listOfAllocationsMap);
        }

        return listOfAllocations;

    }
}
