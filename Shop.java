import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
  public static void main(String[] args) {



ArrayList<Potion> potions = new ArrayList<Potion>();
ArrayList<Potion> recommendations = new ArrayList<Potion>();
ArrayList<Potion> savedPotions = new ArrayList<Potion>();
    
PotionShop thePotionShop = new PotionShop(potions, savedPotions, recommendations);

potions.add(new Potion("Potion of Health", 0, "Red", false));
potions.add(new Potion("Potion of Mending", 1, "Red", false));
potions.add(new Potion("Potion of Healing", 2, "Light Red", false));
potions.add(new Potion("Potion of Restoration", 3, "Pink", false));
potions.add(new Potion("Potion of Harm", 1, "Black", true));
potions.add(new Potion("Potion of Death", 2, "Black", true));
potions.add(new Potion("Potion of Frostwalk", 1, "Blue", false));
potions.add(new Potion("Potion of Invertedness", 1, "White", false));
potions.add(new Potion("Potion of Invisibility", 1, "Clear", false));
potions.add(new Potion("Potion of Hovering", 1, "White", false));
potions.add(new Potion("Potion of Flight", 2, "White", false));
potions.add(new Potion("Potion of Amalgamation", 8, "Dark Blue", true));
potions.add(new Potion("Potion of Stone", 5, "Grey", false));
    


Scanner userInput = new Scanner(System.in);

System.out.println("What potion are you looking for?");

String userSearch = userInput.nextLine();

/** if(userSearch.indexOf(" ") !=6) { // index of the space is 6 so single words wont trigger this
  String placement = thePotionShop.lengthenPotion(userSearch);
  System.out.println(thePotionShop.searchShop(placement));
}

else{
  System.out.println(thePotionShop.searchShop(userSearch));
}
*/
int count = 0;

if(userSearch.equals("What potions do you have?")) {
  System.out.println("");
  System.out.println("Zog [Shopkeeper]: I have these potions right now:");
  System.out.println("");
  thePotionShop.getPotions();
  count++;
}

if(userSearch.equals("What do you have?")) {
  System.out.println("");
  System.out.println("Zog [Shopkeeper]: I have these potions in stock right now:");
  System.out.println("");
  thePotionShop.getPotions();
    count++;
}

if(userSearch.equals("What are you selling?")) {
  System.out.println("");
  System.out.println("Zog [Shopkeeper]: I am selling these potions right now:");
  System.out.println("");
  thePotionShop.getPotions();
    count++;
}

if(userSearch.equals("Potion Tier")) {
  System.out.println("");
  System.out.println("Zog [Shopkeeper]: What tier potion do you want?");
  
 String userIntSearch = userInput.nextLine();
  
  if(userIntSearch.equals("1")) {
  int userSearchCategory = 1;
  thePotionShop.searchByCategoryTier(userSearchCategory);
      count++;
  }
  if(userIntSearch.equals("2")) {
  int userSearchCategory = 2;
  thePotionShop.searchByCategoryTier(userSearchCategory);
      count++;
  }
    if(userIntSearch.equals("3")) {
  int userSearchCategory = 3;
  thePotionShop.searchByCategoryTier(userSearchCategory);
      count++;
  }
    if(userIntSearch.equals("4")) {
  int userSearchCategory = 4;
  thePotionShop.searchByCategoryTier(userSearchCategory);
      count++;
  }
    if(userIntSearch.equals("5")) {
  int userSearchCategory = 5;
  thePotionShop.searchByCategoryTier(userSearchCategory);
      count++;
  }
    if(userIntSearch.equals("6")) {
  int userSearchCategory = 6;
  thePotionShop.searchByCategoryTier(userSearchCategory);
      count++;
  }
    if(userIntSearch.equals("7")) {
  int userSearchCategory = 7;
  thePotionShop.searchByCategoryTier(userSearchCategory);
      count++;
  }
    if(userIntSearch.equals("8")) {
  int userSearchCategory = 8;
  thePotionShop.searchByCategoryTier(userSearchCategory);
      count++;
  }
    if(userIntSearch.equals("9")) {
  int userSearchCategory = 9;
  thePotionShop.searchByCategoryTier(userSearchCategory);
      count++;
  }
    if(userIntSearch.equals("10")) {
  int userSearchCategory = 10;
  thePotionShop.searchByCategoryTier(userSearchCategory);
      count++;
  }
}
    
if(userSearch.equals("Potion Color")) {
  System.out.println("");
  System.out.println("Zog [Shopkeeper]: What Color potion do you want?");
  String userSearchCategory = userInput.nextLine();
  thePotionShop.searchByCategoryColor(userSearchCategory);
      count++;
}

if(userSearch.equals("Potion isToxic")) {
  System.out.println("");
  System.out.println("Zog [Shopkeeper]: Do you want your potion to be toxic?");
    if(userInput.nextLine().equals("true")); {
      boolean userSearchCategory = true;
  thePotionShop.searchByCategoryIsToxic(userSearchCategory);
      count++;
  }
  if(userInput.nextLine().equals("false")); {
      boolean userSearchCategory = false;
  thePotionShop.searchByCategoryIsToxic(userSearchCategory);
      count++;
  }
}


if(count < 1) {
  System.out.println(thePotionShop.searchShop(userSearch)); 
}

thePotionShop.recommendPotion();


System.out.println(thePotionShop.iterateRecommend());

    
    
    
    
  }
}
