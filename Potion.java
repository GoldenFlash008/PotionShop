import java.util.ArrayList;
import java.util.Scanner;

public class Potion {
  
  private String potionName; //potion name
  private int potionTier; //strength of potion
  private String potionColor; //color of potion
  private boolean isToxic; //if the potion is harmful
  private String potionEffect; //effect description

  public Potion(String potionName, int potionTier, String potionColor, boolean isToxic) {
/**
* Constructor Potion, the constructor used to create a Potion object with its name, tier, color, and toxic status.
* @param potionName, variable used to represent the name of the Potion.
* @param potionTier, variable used to represent the tier of the Potion.
* @param potionColor, variable used to represent the color of the Potion.
* @param isToxic, variable used to represent if the Potion is toxic.
* @intent, create a constroctor method to create a potion that has attributes which can be used to find other Potions that are similar and Potions that match your search.
*/
    

    
    this.potionName = potionName;
    this.potionTier = potionTier;
    this.potionColor = potionColor;
    this.isToxic = isToxic;
  }

public String getPotionName() {
  /**
  * getPotionName, method used to return the name of the potion.
  * @intent, method used to compare the name of the potion with the search of the user and also return the name of the potion.
  */
  return potionName;
}

public int getPotionTier() {
  /**
  * getPotionTier, method used to return the tier of the potion.
  * @intent, method used to compare the tier of the potion with other similar potions to find recommendations.
  */
  return potionTier;
}

public String getPotionColor() {
  /**
  * getPotionTier, method used to return the color of the potion.
  * @intent, method used to compare the color of the potion with other similar potions to find recommendations.
  */
  return potionColor;
}

public boolean getPotionIsToxic() {
  /**
  * getPotionIsToxic, method used to return the isToxic status of the potion.
  * @intent, method used to compare the isToxic status of the potion with other similar potions to find recommendations.
  */
  return isToxic;
}

public String getPotion() {
  /**
  * getPotion, method used to return the Potion object and its attributes.
  * @intent, method used to compare the tier of the potion with other similar potions to find recommendations.
  * @return, returns the name, tier, color, isToxic, and potionEffect variables. (potionEffect is not yet implimented)
  */
  
  return potionName + potionTier + potionColor + isToxic + potionEffect;
}
}
