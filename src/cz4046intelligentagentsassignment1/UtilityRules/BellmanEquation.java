package cz4046intelligentagentsassignment1.UtilityRules;

import cz4046intelligentagentsassignment1.TileWorld.TileEnv;
import cz4046intelligentagentsassignment1.TileWorld.TileState;
import cz4046intelligentagentsassignment1.UtilityRules.ActionUtilityPair.Action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
* Class that represents a bellman equation: a wrapper class to make calculations
* easier
*/
public class BellmanEquation {
    
    /**
    * The tile environment to be used in these calculations
    */
    private TileEnv tileEnv;
    
    /**
    * The utility map to update and retrieve neighboring tile utility from
    */
    private TileUtilityMap tileUtilityMap;
    
    /**
    * The utility map to update and retrieve neighboring tile utility from
    */
    private TransitionModel transitionModel;
    
    /**
    * The discount factor to be used in the calculations
    */
    private double discountFactor;
    
    /**
    * Defines a new bellman equation
    * @param tileUtilityMap The tile utility map to base calculations on
    */
    public BellmanEquation(TileUtilityMap tileUtilityMap) {
        this.tileUtilityMap = tileUtilityMap;
        this.tileEnv = tileUtilityMap.getTileEnv();
        this.transitionModel = tileUtilityMap.getTransitionModel();
        this.discountFactor = tileUtilityMap.getDiscountFactor();
    }
    
    /**
    * Calculate the max utility of the specified tile
    * @param stateRow Row of specified tile
    * @param stateCol Column of specified tile
    * @return The max utility of the specified tile
    */
    public ActionUtilityPair getMaxActionUtilityPair(int stateRow, int stateCol) {
        List<ActionUtilityPair> actionUtilityPairs = new ArrayList<>();
        
        // For each direction, calculate the utility
        for (Action action : Action.values()) {
            actionUtilityPairs.add(new ActionUtilityPair(action,
                                    getActionUtility(stateRow,stateCol,action)));
        }
        
        // Sort by utility in descending order 
        // and extract the one with highest utility
        Collections.sort(actionUtilityPairs);
	ActionUtilityPair maxActionUtilityPair = actionUtilityPairs.get(0);
		
        return maxActionUtilityPair;
    }
    
    /**
    * Calculate the utility of the specified tile
    * @param stateRow Row of specified tile
    * @param stateCol Column of specified tile
    * @param action the intended action of the agent
    * @return The utility of the specified tile
    */
    public double getActionUtility(int stateRow, int stateCol, Action action) {
        double actionUtility = 0;
        double neighbourUtility;
        
        // Depending on the intented action, calculate the neighboring tile 
        // utility accordingly
        switch (action) {
            case UP: 
                neighbourUtility = getNeighbourUtility(stateRow, stateCol,-1, 0);
                actionUtility += transitionModel.getIntentionProbability()*neighbourUtility;
                neighbourUtility = getNeighbourUtility(stateRow, stateCol,0,1);
                actionUtility += transitionModel.getCWProbability()*neighbourUtility;
                neighbourUtility = getNeighbourUtility(stateRow, stateCol,0,-1);
                actionUtility += transitionModel.getCCWProbability()*neighbourUtility;
                break;
                
            case RIGHT:
                neighbourUtility = getNeighbourUtility(stateRow, stateCol,0, 1);
                actionUtility += transitionModel.getIntentionProbability()*neighbourUtility;
                neighbourUtility = getNeighbourUtility(stateRow, stateCol,1,0);
                actionUtility += transitionModel.getCWProbability()*neighbourUtility;
                neighbourUtility = getNeighbourUtility(stateRow, stateCol,-1,0);
                actionUtility += transitionModel.getCCWProbability()*neighbourUtility;
                break;
                
            case LEFT:
                neighbourUtility = getNeighbourUtility(stateRow, stateCol,0, -1);
                actionUtility += transitionModel.getIntentionProbability()*neighbourUtility;
                neighbourUtility = getNeighbourUtility(stateRow, stateCol,-1,0);
                actionUtility += transitionModel.getCWProbability()*neighbourUtility;
                neighbourUtility = getNeighbourUtility(stateRow, stateCol,1,0);
                actionUtility += transitionModel.getCCWProbability()*neighbourUtility;
                break;
                
            case DOWN:
                neighbourUtility = getNeighbourUtility(stateRow, stateCol,1, 0);
                actionUtility += transitionModel.getIntentionProbability()*neighbourUtility;
                neighbourUtility = getNeighbourUtility(stateRow, stateCol,0,-1);
                actionUtility += transitionModel.getCWProbability()*neighbourUtility;
                neighbourUtility = getNeighbourUtility(stateRow, stateCol,0,1);
                actionUtility += transitionModel.getCCWProbability()*neighbourUtility;
                break;
        }    
        
        // Utility of tile = reward of tile +
        // (discountfactor * utility of neighbor tiles)
        actionUtility = tileEnv.getTile(stateRow,stateCol).getReward()
                + (discountFactor * actionUtility);
        return actionUtility;
    }
    
    /**
    * Calculate the utility of neighboring tiles
    * @param stateRow Row of specified tile
    * @param stateCol Column of specified tile
    * @param offsetRow Offset row of neighbor tile from specified tile
    * @param offsetCol Offset column of neighbor tile from specified tile
    * @return The utility of neighboring tile
    */
    private double getNeighbourUtility(int stateRow, int stateCol,
            int offsetRow, int offsetCol) {
        double neighbourUtility = 0;
        
        // Check if the requested tile is out of bounds or if its a wall
        if (stateRow+offsetRow >= 0 && stateRow+offsetRow < tileEnv.getHeight() &&
            stateCol+offsetCol >= 0 && stateCol+offsetCol < tileEnv.getWidth() &&
            tileEnv.getTile(stateRow+offsetRow,stateCol+offsetCol).getState() != TileState.WALL) {
            
            neighbourUtility = tileUtilityMap.getTileUtility(stateRow+offsetRow,stateCol+offsetCol);
        } else {
        
            // Use the current tile's utility if neighbor tile is out of bounds 
            // or is a wall
            neighbourUtility = tileUtilityMap.getTileUtility(stateRow,stateCol);
        }
        return neighbourUtility;
    }
    
    /**
    * Change the utility map to perform calculations on
    * @param tileUtilityMap The new tile utility map to base calculations on
    */
    public void changeTileUtilityMap(TileUtilityMap tileUtilityMap) {
        this.tileUtilityMap = tileUtilityMap;
    }
}
