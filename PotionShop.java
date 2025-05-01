import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class PotionShop {

public static String shortPotion; // shortened name of potion
public static String longPotion;
public String search; //varaible for argument used to search potions
public int searchCategoryTier; //variable for an argument used to search potions by category of tier 
public String searchCategoryColor; //variable for an argument used to search potions by category of color
public boolean searchCategoryIsToxic; //variable for an argument used to search potions by category of if its toxic
private ArrayList<Potion> potions; //list of potions
private ArrayList<Potion> savedPotions; //list of potions that were saved when searched
private ArrayList<Potion> recommendations; //list of recommendations
private static String[] notFoundResponses = FileReader.toStringArray("ShopKeeperResponse.txt"); //reads the shop keeper responses for when potion is not found
private static String[] foundResponses = FileReader.toStringArray("ShopKeeperResponse2.txt"); //reads the shop keeper responses for when potion is found


  public PotionShop(ArrayList<Potion> potions, ArrayList<Potion> savedPotions, ArrayList<Potion> recommendations) {
/**
* Object Potionshop to access the ArrayLists "potions", "savedPotions", and "recommendations" in Shop.java
* @param potions, the ArrayList of potions used to store the potions in the shop.
* @param savedPotions, the ArrayList of potions that are saved when sucessfully finding a match to your search.
* @param recommendations, the ArrayList of potions that are stored and then printed to show similar potions to the ones that are searched.
*/

    
    this.potions = potions;
    this.savedPotions = savedPotions;
    this.recommendations = recommendations;

    potions = new ArrayList<Potion>();
    savedPotions = new ArrayList<Potion>();
    recommendations = new ArrayList<Potion>();
  }

public String searchShop(String search) {
      this.search = search;
int matchedPotion = 0; // number of potions that match search
/**
* searchShop, the method used to search and iterate through the ArrayList "potions," to find a Potion object that matches the name of the searched potion.
* @param search, the variable that is used as an argument when searching for a potion.
* @intent, iterate through potions to find matching potions and then prints out the matched potion and its attributes. Lastly, add those objects to the ArrayList "savedPotions.""
*/


if(search.indexOf("of") == -1) { // index of the space is 6 so single words wont trigger this
  String newSearch = PotionShop.lengthenPotion(search);
  search = newSearch;
}
  
for(int index = 0; index < potions.size(); index++) { 
  Potion currentPotion = potions.get(index);
    if(search.equals(currentPotion.getPotionName())) { //STRING METHOD
      System.out.println(" ");
      System.out.println("Potions found: ");
      System.out.println(" ");
      System.out.println("|Name: " + currentPotion.getPotionName() + " | Tier: " + currentPotion.getPotionTier() + " | Color: " + currentPotion.getPotionColor() + " | Is toxic: " + currentPotion.getPotionIsToxic() + "|");
      System.out.println("");
      PotionShop.respondToFound(); //prints line when there is a successfully matched potion

      savedPotions.add(new Potion(currentPotion.getPotionName(), currentPotion.getPotionTier(), currentPotion.getPotionColor(), currentPotion.getPotionIsToxic()));
      matchedPotion++;
    }

}
  if(matchedPotion < 1) {
        PotionShop.respondToNotFound(); //prints a line when there is less than 1 matched potion
  }
  if(matchedPotion > 0) {

  System.out.println("");
  System.out.println("___________________________________________________________________________________________________");
  System.out.println("");
  System.out.println("SIMILAR POTIONS:");  
  }
return "";
}


public String recommendPotion() {

  /**
  * recommendPotion, iterates through the ArrayList savedPotions to find the potions matching the search and recommends potions with the same attributes
  * @intent, use the data from ArrayList "savedPotions" to recommend Potion objects from the ArrayList "potions" by adding them to the ArrayList "recommendaitons."
  */
  
  int index = 0;
  int i = 0;
  while(index < savedPotions.size()) { //iterates through saved potions
    Potion similarPotion = savedPotions.get(index); //similar potion is the saved potion that matched the search
    int similarPotionTier = similarPotion.getPotionTier();
    String similarPotionColor = similarPotion.getPotionColor();
    boolean similarPotionIsToxic = similarPotion.getPotionIsToxic();

    while(i < potions.size()) {
      Potion comparisonPotion = potions.get(i); //current potion

      int count1 = 0; //prevents listing multiple potions with more than one of the same attribute
      int count2 = 0; //prevents listing multiple potions with more than one of the same attribute
      int count3 = 0; //prevents listing multiple potions with more than one of the same attribute
      
      if(similarPotionTier == comparisonPotion.getPotionTier()) { //checks if the saved potion attribute matches with iterated potion
        if(count1 + count2 + count3 == 0) { //makes sure that none of the other potions have added a comparison potion
        recommendations.add(new Potion(comparisonPotion.getPotionName(), comparisonPotion.getPotionTier(), comparisonPotion.getPotionColor(), comparisonPotion.getPotionIsToxic()));
        count1++;
        }
      }
      if(similarPotionColor.equals(comparisonPotion.getPotionColor())) { //color attribute STRING METHOD
         if(count1 + count2 + count3 == 0) { 
        recommendations.add(new Potion(comparisonPotion.getPotionName(), comparisonPotion.getPotionTier(), comparisonPotion.getPotionColor(), comparisonPotion.getPotionIsToxic()));
        count2++;
         }
      }
      if(similarPotionIsToxic == comparisonPotion.getPotionIsToxic()) { //isToxic attribute
        if(count1 + count2 + count3 == 0) { 
        recommendations.add(new Potion(comparisonPotion.getPotionName(), comparisonPotion.getPotionTier(), comparisonPotion.getPotionColor(), comparisonPotion.getPotionIsToxic()));
          count3++;
        }
      }
      i++;
    }
    index++;
  }
  return "";
}

public String searchByCategoryTier(int searchCategoryTier) {
  this.searchCategoryTier = searchCategoryTier;
  for(int index = 0; index < potions.size(); index++) {
    Potion categoryPotion1 = potions.get(index);
    if(searchCategoryTier == categoryPotion1.getPotionTier()) {
      
      System.out.println(" ");
      System.out.println("Tier " + searchCategoryTier + " potion found: ");
      System.out.println(" ");
      System.out.println("|Name: " + categoryPotion1.getPotionName() + " | Tier: " + categoryPotion1.getPotionTier() + " | Color: " + categoryPotion1.getPotionColor() + " | Is toxic: " + categoryPotion1.getPotionIsToxic() + "|");
      System.out.println("");
      
    }
  }
  return "";
}

public String searchByCategoryColor(String searchCategoryColor) {
  this.searchCategoryColor = searchCategoryColor;
  
  for(int index = 0; index < potions.size(); index++) {
    Potion categoryPotion2 = potions.get(index);
    if(searchCategoryColor.equals(categoryPotion2.getPotionColor())) {
      
      System.out.println(" ");
      System.out.println(searchCategoryColor + " potion found: ");
      System.out.println(" ");
      System.out.println("|Name: " + categoryPotion2.getPotionName() + " | Tier: " + categoryPotion2.getPotionTier() + " | Color: " + categoryPotion2.getPotionColor() + " | Is toxic: " + categoryPotion2.getPotionIsToxic() + "|");
      System.out.println("");
    }
  }
  return "";
}

public String searchByCategoryIsToxic(boolean searchCategoryIsToxic) {
  this.searchCategoryIsToxic = searchCategoryIsToxic;
  for(int index = 0; index < potions.size(); index++) {
    Potion categoryPotion3 = potions.get(index);
    if(searchCategoryIsToxic == categoryPotion3.getPotionIsToxic()) {
      boolean no = false; //not toxic
      boolean yes = true;//toxic

      if(categoryPotion3.getPotionIsToxic() == false) {
        System.out.println("");
        System.out.println("Potion found that is not toxic:");
        System.out.println("");
        System.out.println("|Name: " + categoryPotion3.getPotionName() + " | Tier: " + categoryPotion3.getPotionTier() + " | Color: " + categoryPotion3.getPotionColor() + " | Is toxic: " + categoryPotion3.getPotionIsToxic() + "|");
        System.out.println("");
      }
      
      if(categoryPotion3.getPotionIsToxic() == true) {
        System.out.println("");
        System.out.println("Potion found that is toxic:");
        System.out.println("");
        System.out.println("|Name: " + categoryPotion3.getPotionName() + " | Tier: " + categoryPotion3.getPotionTier() + " | Color: " + categoryPotion3.getPotionColor() + " | Is toxic: " + categoryPotion3.getPotionIsToxic() + "|");
        System.out.println("");
      }
  
}
  }
    return "";
  }
  

public String iterateRecommend() { 
  /**
  * iterateRecommend, method that prints out the potions attributes at the current index in the ArrayList "recommendations."
  * @intent, print out the Potion's attributes as a recommendation from your search.
  */
    for(int index2 = 0; index2 < recommendations.size(); index2++) {
    Potion recommendedPotion = recommendations.get(index2);
    System.out.println("");
    System.out.println("Similar potion: " + "|Name: " + recommendedPotion.getPotionName() + " | Tier: " + recommendedPotion.getPotionTier() + " | Color: " + recommendedPotion.getPotionColor() + " | Is toxic: " + recommendedPotion.getPotionIsToxic() + "|");

  }
  return "";
}

public static String respondToNotFound() { 
/**
Method to print a line from the ArrayList notFoundResponses
* @intent method is used when your query when searching for a potion does not match with a potion in potions
*/
  int randomResponse = (int)(Math.random()*6);
  System.out.println(notFoundResponses[randomResponse]);
  return "";
}
public static String respondToFound() { 
/**
Method to print a line from the ArrayList foundResponses
* @intent method is used when your query when searching for a potion sucessfully matches with a potion in potions
*/

  int randomResponse2 = (int)(Math.random()*4);
  System.out.println(foundResponses[randomResponse2]);
  return "";
}

public ArrayList<Potion> getPotions() {
/**
getPotions, returns the ArrayList potions
* @return, returns potions
*/


for(int index = 0; index < potions.size(); index++) {
Potion returnedPotion = potions.get(index);
System.out.println("|Name: " + returnedPotion.getPotionName() + " | Tier: " + returnedPotion.getPotionTier() + " | Color: " + returnedPotion.getPotionColor() + " | Is toxic: " + returnedPotion.getPotionIsToxic() + "|");
}
return potions;

}

public static String lengthenPotion(String shortPotion) {
  shortPotion = shortPotion;

  longPotion = "Potion of " + shortPotion;
  return longPotion;
}
  
}
