package cz4046intelligentagentsassignment1.UtilityRules;

import java.io.Serializable;
import java.util.Random;

/**
 * Enumeration class of all possible actions that the agent can perform 
 * in each state
 * @author Kenneth
 */
public class ActionUtilityPair implements Serializable, Comparable<ActionUtilityPair> {
    public enum Action {
		UP("^"),
		DOWN("v"),
		LEFT("<"),
		RIGHT(">");
		
		/**
                * String representation of the action, to be used in policy map
                */
		private String representation;
		
                /**
                * Create a new action
                * @param representation String representation of the action,
                *                       to be used in policy map
                */
		Action(String representation) {
			this.representation = representation;
		}
		
                /**
                * Obtain the string representation of the action enum
                */
		@Override
		public String toString() {
			return representation;
		}
		
                /**
                * An array of all the values in the Actions enum class
                */
		private static final Action[] ACTIONSLIST = values();
                
                /**
                * Number of values in the Actions enum class
                */
		private static final int SIZE = ACTIONSLIST.length;
                
                /**
                * Obtain a random object for use in getRandomaction()
                */
		private static final Random RANDOM = new Random();

                /**
                * Obtain a random action
                */  
		public static Action getRandomAction() {
			return ACTIONSLIST[RANDOM.nextInt(SIZE)];
		}
	}
    
    /**
    * Action in the pair
    */
    private Action action;
    
    /**
    * Utility of performing the paired action
    */
    private double utility;
    
    /**
    * Define a new action utility pair
    * @param action The action to be performed
    * @param utility Utility of performing the paired action
    */
    public ActionUtilityPair(Action action, double utility) {
        this.action = action;
        this.utility = utility;
    }
    
    /**
    * Get the action of this action utility pair
    * @return The action to be performed
    */
    public Action getAction() {
        return action;
    }
    
    /**
    * Get the utility of this action utility pair
    * @return Utility of performing the paired action
    */
    public double getUtility() {
        return utility;
    }
    
    /**
    * Change the action of this action utility pair
    * @param action New action to be performed
    */
    public void setAction(Action action) {
        this.action = action;
    }
    
    /**
    * Change the utility of this action utility pair
    * @param utility New utility of performing the paired action
    */
    public void setUtility(double utility) {
        this.utility = utility;
    }
    
    /**
    * Compare the utility between two action utility pairs
    * @return returns true if this pair provides higher utility 
    *         than the other pair
    */
    @Override
    public int compareTo(ActionUtilityPair o) {
        return ((Double) o.getUtility()).compareTo(getUtility());
    }
}
