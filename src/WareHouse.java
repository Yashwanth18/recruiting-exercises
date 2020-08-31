import java.util.LinkedHashMap;
import java.util.Map;

public class WareHouse {

    private String warehouseName;
    private Map<String, Integer> inventory;

    public WareHouse(String warehouseName,Map<String,Integer>inventory)
    {

        this.warehouseName = warehouseName;
        this.inventory = inventory;
    }


    public String getWarehouseName()
    {
        return warehouseName;
    }


    public int getItemQuantity(String itemName)
    {
        return this.inventory.getOrDefault(itemName, 0);
    }


    public Map<String, Integer> getInventory()
    {
        return inventory;
    }


}
