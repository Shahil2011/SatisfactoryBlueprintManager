import java.util.ArrayList;
import java.util.Arrays;

public class Recipe
{
    private String itemName;
    private float itemRate;
    private String building;
    private String[] inputItems;
    private float[] inputRates;
    private int complexity;
    public ArrayList<Recipe> recipes;
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
        recipes = (ArrayList<Recipe>) Main.recipes.clone();
        complexity = 0;
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
        recipes = (ArrayList<Recipe>) Main.recipes.clone();
        complexity = 0;
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

    public int recipeComplexity()
    {
        int max = 0;
        int temp = 0;
        for(String i : inputItems)
        {
            if(i.equals("IronOre") || i.equals("CopperOre") || i.equals("Coal") || i.equals("Limestone"))
            {
                temp = 0;
            }
            else if(Main.getRecipe(i) == null)
            {
                temp = 0;
            }
            else
            {
                temp = Main.getRecipe(i).getComplexity();
            }
            if(max <= temp)
                max = temp;
        }
        complexity = max + 1;
        return complexity;
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
