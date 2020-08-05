import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Recipe> recipes = new ArrayList<Recipe>();

    public static void main(String[] args) {
        System.out.println("Hey! Welcome to an unofficial satisfactory blueprint manager program!");
        Scanner sc = new Scanner(System.in);

        //Build database
        System.out.println("Building database from file recipes.txt...");
        try
        {
            Scanner f = new Scanner(new File("recipes.txt"));
            f.useDelimiter(",|\\r|\\n");
            while(f.hasNext())
            {
                String outputItem = f.next();
                float outputRate = f.nextFloat();
                String building = f.next();
                String input1 = f.next();
                float inputRate1 = f.nextFloat();
                if(building.equals("Foundry") || building.equals("Assembler"))
                {
                    String input2 = f.next();
                    float inputRate2 = f.nextFloat();
                    recipes.add(new Recipe(outputItem, outputRate, building, input1, inputRate1, input2, inputRate2));
                }
                else
                {
                    recipes.add(new Recipe(outputItem, outputRate, building, input1, inputRate1));
                }
                if(f.hasNextLine())
                    f.nextLine();
            }

        }
        catch (FileNotFoundException e)
        {
            System.out.println(e);
        }

        for(Recipe i : recipes)
        {
            System.out.println(i);
        }

        //System Loop
        System.out.println("Please enter the number of the operation you'd like to perform:" +
                "\n0: Exit" +
                "\n1: View Recipe" +
                "\n2: Add Recipe" +
                "\n3: Build Blueprint");
        int choice = sc.nextInt();
        while(choice != 0)
        {

            switch(choice)
            {
                case 1:
                    System.out.println("Calling function viewRecipe()...");
                    viewRecipe();
                    break;
                case 2:
                    System.out.println("Choice 2 Made!");
                    break;
                case 3:
                    System.out.println("Choice 3 Made!");
                    break;
                default:
                    System.out.println("Not a valid choice. Please enter the number of the above listed options");
            }

            System.out.println("Please enter the number of the operation you'd like to perform:" +
                    "\n0: Exit" +
                    "\n1: View Recipe" +
                    "\n2: Add Recipe" +
                    "\n3: Build Blueprint");
            choice = sc.nextInt();
        }

        System.out.println("Exiting...");
        System.exit(0);
    }

    public static void viewRecipe()
    {
        System.out.println("Please enter the name of an item to look up the recipe for:");

        Scanner sc = new Scanner(System.in);
        String itemName = sc.next();
        String item = "";

        System.out.println("Checking file recipes.txt");
        try
        {
            Scanner f = new Scanner(new File("recipes.txt"));
            f.useDelimiter(",");
            boolean itemFound = false;
            while(f.hasNextLine() && !itemFound)
            {
                item = f.next();
                if(itemName.equals(item))
                {
                    System.out.println("Found Item : " + item);
                    itemFound = true;
                    break;
                }
                f.nextLine();
            }
            if(itemFound == false)
                System.out.println("Sorry, could not find that item");
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e);
        }
    }
}
