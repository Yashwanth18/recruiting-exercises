import java.util.Map;

public class Warehouses {

    private String warehouseName;
    private Map<String,Integer> inventory;
    public Warehouses(String warehouseName,Map<String,Integer>inventory)
    {
        this.warehouseName=warehouseName;
        this.inventory=inventory;
    }

}