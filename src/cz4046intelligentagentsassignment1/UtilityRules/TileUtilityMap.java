package cz4046intelligentagentsassignment1.UtilityRules;

import cz4046intelligentagentsassignment1.TileWorld.TileEnv;
import cz4046intelligentagentsassignment1.TileWorld.TileState;
import cz4046intelligentagentsassignment1.UtilityRules.ActionUtilityPair.Action;
import java.io.Serializable;

/**
 * Class that represents the map that pairs a tile with its utility
 * @author Kenneth
 */
public class TileUtilityMap implements Serializable {
    /**
    * A 2 dimensional array of action utility pairs that maps directly to the
    * design of the tile environment
    */
    private ActionUtilityPair[][] tileUtilityMap;
    
    /**
    * The tile environment mapped by the utility map
    */
    private TileEnv tileEnv;
    
    /**
    * Transition model used to navigate through the tile environment
    * Used to calculate utility
    */
    private TransitionModel transitionModel;
    
    /**
    * Discount factor to be used in the calculation of utility
    */
    private double discountFactor;
    
    /**
    * Defines a new tile utility map that contains the utility of each tile in
    * the environment
    * @param tileEnv The time environment that this map will created on
    * @param intentionProb Transition Model: the probability that the agent will
    *                      carry out its intended move
    * @param cwProb Transition Model: the probability that the agent will move
    *               clockwise from the intended move instead
    * @param ccwProb Transition Model: the probability that the agent will move
    *                anti-clockwise from the intended move instead
    * @param discountFactor The amount to discount neighboring tile utility
    */
    public TileUtilityMap(TileEnv tileEnv, double intentionProb,
            double cwProb, double ccwProb, double discountFactor) {
        int width = tileEnv.getWidth();
        int height = tileEnv.getHeight();
        this.discountFactor = discountFactor;
        this.tileEnv = tileEnv;
        
        transitionModel = new TransitionModel(intentionProb, cwProb, ccwProb);
        tileUtilityMap = new ActionUtilityPair[width][height];
        
        for (int row=0; row<height; row++) {
            for (int col=0; col<width; col++) {
                tileUtilityMap[row][col] = 
                        new ActionUtilityPair(null,0.00);
            }
        }
    }
    
    /**
    * Defines a new tile utility map that contains the utility of each tile in
    * the environment
    * @param tileEnv The time environment that this map will created on
    * @param transitionModel The transition model containing the 
    *                        required state transition probabilities
    * @param discountFactor The amount to discount neighboring tile utility
    */
    public TileUtilityMap(TileEnv tileEnv, TransitionModel transitionModel,
            double discountFactor) {
        int height = tileEnv.getHeight();
        int width = tileEnv.getWidth();
        
        this.discountFactor = discountFactor;
        this.tileEnv = tileEnv;
        
        this.transitionModel = transitionModel;
        tileUtilityMap = new ActionUtilityPair[width][height];
        
        for (int row=0; row<height; row++) {
            for (int col=0; col<width; col++) {
                // Initialise every tile's utility pair to null action and 
                // 0 utility
                tileUtilityMap[row][col] = 
                        new ActionUtilityPair(null,0.00);
            }
        }
    }
    
    /**
    * Displays a grid representation of this utility map with all the utility 
    * of each tile specified
    */ 
    public void displayMap() {
        double tempUtility;
        int height = tileEnv.getHeight();
        int width = tileEnv.getWidth();
        
        // For each tile in the final utility map
        for (int row=0; row<height; row++) {
            for (int col=0; col<width; col++) {
                // Change the decimal precision
                tempUtility = Math.round(
                        tileUtilityMap[row][col].getUtility()*100.0)/100.0;
                System.out.print(
                        "[" + tempUtility + "]");
            }
            System.out.print("\n");
        }
    }
    
    /**
    * Displays a grid representation of this utility map with all the policy
    * of each tile specified
    */ 
    public void displayPolicy() {
        int height = tileEnv.getHeight();
        int width = tileEnv.getWidth();
        
        // For each tile in the final utility map
        for (int row=0; row<height; row++) {
            for (int col=0; col<width; col++) {
                if (tileEnv.getTile(row, col).getState() != TileState.WALL) {
                // Print the policy for non-wall tiles
                System.out.print(
                        "[" + tileUtilityMap[row][col].getAction().toString() + "]");
                }
                else {
                    System.out.print("[#]");
                }
            }
            System.out.print("\n");
        }
    }
    
    /**
    * Displays a list of all the coordinates and the corresponding estimated
    * utility for comparison purposes
    */ 
    public void displayUtilityArray() {
        double tempUtility;
        int height = tileEnv.getHeight();
        int width = tileEnv.getWidth();
        
        System.out.println("Reference utilities of states:");
        System.out.println("Coordinates are in (row,col) format with"
                + " the top left corner being (0,0).");
        
        // For each tile in the final utility map
        for (int row=0; row<height; row++) {
            for (int col=0; col<width; col++) {
                // Change the decimal precision
                tempUtility = Math.round(
                        tileUtilityMap[row][col].getUtility()*100.00000)/100.00000;
                System.out.println("("+row+","+col+")"+tempUtility);
            }
        }
    }
    
    /**
    * Get the action utility pair of the tile at the specified coordinates
    * @param row the row number of the tile
    * @param col the col number of the tile
    * @return the action utility pair of the tile
    */ 
    public ActionUtilityPair getTileActionUtilityPair(int row, int col) {
        return tileUtilityMap[row][col];
    }
    
    /**
    * Get the utility of the tile at the specified coordinates
    * @param row the row number of the tile
    * @param col the col number of the tile
    * @return the utility of the tile
    */ 
    public double getTileUtility(int row, int col) {
        return tileUtilityMap[row][col].getUtility();
    }
    
    /**
    * Get the policy/action of the tile
    * @param row the row number of the tile
    * @param col the col number of the tile
    * @return the policy of the tile
    */ 
    public Action getTileAction(int row, int col) {
        return tileUtilityMap[row][col].getAction();
    }
    
    /**
    * Get the tile environment that this utility map is mapped to
    * @return the tile environment
    */ 
    public TileEnv getTileEnv() {
        return tileEnv;
    }
    
    /**
    * Get the discount factor used in this utility map
    * @return the discount factor
    */ 
    public double getDiscountFactor() {
        return discountFactor;
    }
    
    /**
    * Get the discount factor used in this utility map
    * @return the discount factor
    */ 
    public TransitionModel getTransitionModel() {
        return transitionModel;
    }
    
    /**
    * Change the action utility pair of the tile at the specified coordinates
    * @param row the row number of the tile
    * @param col the col number of the tile
    * @param actionUtilityPair the new action utility pair to change to
    */ 
    public void setTileActionUtility(int row, int col,
            ActionUtilityPair actionUtilityPair) {
        tileUtilityMap[row][col] = actionUtilityPair;
    }
    
    /**
    * Change the utility of the tile at the specified coordinates
    * @param row the row number of the tile
    * @param col the col number of the tile
    * @param utility the new utility to change to
    */ 
    public void setTileUtility(int row, int col, double utility) {
        tileUtilityMap[row][col].setUtility(utility);
    }
    
    /**
    * Change the policy/action of the tile at the specified coordinates
    * @param row the row number of the tile
    * @param col the col number of the tile
    * @param action the new policy/action to change to
    */
    public void setTileAction(int row, int col, Action action) {
        tileUtilityMap[row][col].setAction(action);
    }
}
