import java.util.Arrays;

public class Recipe
{
    private String itemName;
    private float itemRate;
    private String building;
    private String[] inputItems;
    private float[] inputRates;
    private int complexity;
    //Single-input constructor
    public Recipe(String itemName, float itemRate, String building, String inputItem, float inputRate)
    {
        this.itemName = itemName;
        this.itemRate = itemRate;
        this.building = building;
        inputItems = new String[1];
        inputRates = new float[1];
        inputItems[0] = inputItem;
        inputRates[0] = inputRate;
    }

    //Double-input constructor
    public Recipe(String itemName, float itemRate, String building, String inputItem1, float inputRate1, String inputItem2, float inputRate2)
    {
        this.itemName = itemName;
        this.itemRate = itemRate;
        this.building = building;
        inputItems = new String[2];
        inputRates = new float[2];
        inputItems[0] = inputItem1;
        inputRates[0] = inputRate1;
        inputItems[1] = inputItem2;
        inputRates[1] = inputRate2;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "itemName='" + itemName + '\'' +
                ", itemRate=" + itemRate +
                ", building='" + building + '\'' +
                ", inputItems=" + Arrays.toString(inputItems) +
                ", inputRates=" + Arrays.toString(inputRates) +
                ", complexity=" + complexity +
                '}';
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public float getItemRate() {
        return itemRate;
    }

    public void setItemRate(float itemRate) {
        this.itemRate = itemRate;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String[] getInputItems() {
        return inputItems;
    }

    public void setInputItems(String[] inputItems) {
        this.inputItems = inputItems;
    }

    public float[] getInputRates() {
        return inputRates;
    }

    public void setInputRates(float[] inputRates) {
        this.inputRates = inputRates;
    }

    public int getComplexity() {
        return complexity;
    }

    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }
}
