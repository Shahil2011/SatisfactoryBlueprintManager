import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Recipe> recipes = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Hey! Welcome to an unofficial satisfactory blueprint manager program!");
        Scanner sc = new Scanner(System.in);

        //Build database
        System.out.println("Building database from file recipes.txt...");
        try
        {
            Scanner f = new Scanner(new File("recipes.txt"));
            //f.useDelimiter(",");
            while(f.hasNextLine())
            {
                Scanner l = new Scanner(f.nextLine());
                l.useDelimiter(",");
                String outputItem = l.next();
                float outputRate = l.nextFloat();
                String building = l.next();
                String input1 = l.next();
                float inputRate1 = l.nextFloat();
                if(l.hasNext())
                {
                    String input2 = l.next();
                    float inputRate2 = l.nextFloat();
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

        //System Loop
        System.out.println("\nPlease enter the number of the operation you'd like to perform:" +
                "\n0: Exit" +
                "\n1: View Recipe" +
                "\n2: Add Recipe" +
                "\n3: Build Blueprint");
        int choice = sc.nextInt();
        while(choice != 0)
        {

            String itemName;
            switch(choice)
            {
                case 1:
                    System.out.println("Please enter the name of an item to look up the recipe for (Use no spaces, capitalise the beginning of each word, and use singular form)" +
                            "\nEnter 'all' to view all recipes");

                    itemName = sc.next();
                    viewRecipe(itemName);
                    break;
                case 2:
                    System.out.println("Please enter the name of an item to create a recipe for: ");
                    itemName = sc.next();
                    if(findRecipe(itemName))
                    {
                        System.out.println("Sorry, that recipe already exists");
                        break;
                    }
                    else if(itemName.equals("all"))
                    {
                        System.out.println("Invalid option");
                        break;
                    }
                    else
                        addRecipe(itemName);
                    break;
                case 3:
                    System.out.println("Choice 3 Made!");
                    break;
                default:
                    System.out.println("Not a valid choice. Please enter the number of the above listed options");
            }

            System.out.println("\nPlease enter the number of the operation you'd like to perform:" +
                    "\n0: Exit" +
                    "\n1: View Recipe" +
                    "\n2: Add Recipe" +
                    "\n3: Build Blueprint");
            choice = sc.nextInt();
        }

        System.out.println("Exiting...");
        System.exit(0);
    }

    private static boolean findRecipe(String itemName)
    {
        for(Recipe i : recipes)
        {
            if(i.getItemName().equals(itemName))
                return true;
        }
        return false;
    }

    private static void addRecipe(String itemName)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the output rate of " + itemName + ":");
        float outputRate = sc.nextFloat();
        System.out.println("Please enter the building it is produced in: ");
        String building = sc.next();
        System.out.println("Please enter the name of input item 1:");
        String item1Name = sc.next();
        System.out.println("Please enter the rate of input item 1:");
        float item1Rate = sc.nextFloat();
        System.out.println("If there are more input items, enter the name of the next one, otherwise enter 'exit':");
        String item2Name = sc.next();
        if(item2Name.equals("exit"))
        {
            recipes.add(new Recipe(itemName,outputRate,building,item1Name,item1Rate));
        }
        else
        {
            System.out.println("Enter the rate of input item 2:");
            float item2Rate = sc.nextFloat();
            recipes.add(new Recipe(itemName,outputRate,building,item1Name,item1Rate,item2Name,item2Rate));
        }
        System.out.println("Recipe added!");

    }

    private static void viewRecipe(String itemName)
    {
        if(itemName.equals("all"))
        {
            for(Recipe i : recipes)
            {
                System.out.println(i);
            }
            return;
        }
        else {
            for (Recipe i : recipes) {
                if (i.getItemName().equals(itemName)) {
                    System.out.println("Recipe found!\n" + i);
                    return;
                }
            }
            System.out.println("Sorry, could not find the recipe for that item :(");
            return;
        }
    }
}
