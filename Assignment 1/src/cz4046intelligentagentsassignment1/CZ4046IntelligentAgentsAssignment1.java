package cz4046intelligentagentsassignment1;

import cz4046intelligentagentsassignment1.UtilityRules.TransitionModel;
import cz4046intelligentagentsassignment1.TileWorld.TileEnv;
import cz4046intelligentagentsassignment1.TileWorld.TileState;

import static cz4046intelligentagentsassignment1.Utilities.UtilityFunctions.deepCopy;

import cz4046intelligentagentsassignment1.UtilityRules.ActionUtilityPair;
import cz4046intelligentagentsassignment1.UtilityRules.ActionUtilityPair.Action;
import cz4046intelligentagentsassignment1.UtilityRules.BellmanEquation;
import cz4046intelligentagentsassignment1.UtilityRules.TileUtilityMap;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Class that contains the application functions to perform value iteration
 * and policy iteration
 * @author Kenneth
 */
public class CZ4046IntelligentAgentsAssignment1 {

    public static void main(String[] args) {
        // Part 1
        assignmentPart1();
        
        // Part 2
        //assignmentPart2Enlarged();
        //assignmentPart2Complex();
    }
    
    /**
    * Wrap the code for part 1 of the assignment into a function
    */
    private static void assignmentPart1() {
        // Initialise parameters
        TileEnv env1 = generatePart1Environment();
        double discountFactor = 0.99;
        double intentionProb = 0.80;
        double cwProb = 0.1;
        double ccwProb = 0.1;
        double epsilon = 0.1;
        int policyEvalIterations = 12;
       
        System.out.println("Settings ==========================================");
        System.out.println("Discount Factor: " + discountFactor);
        System.out.println("Transition Model Probability (i,cw,ccw): " +
                intentionProb + "," + cwProb + "," + ccwProb);
        System.out.println("Epsilon: " + epsilon);
        System.out.println("Number of iterations for Policy Evaluation: " +
                policyEvalIterations);
        
        System.out.println("Tile Environment:  ");
        env1.printEnv();
        System.out.println("Legend: +1 reward [+], -1 reward [x], wall [#]");
        System.out.println("");
        System.out.println("==================================================");
        
        // Value Iteration
        TransitionModel transition1 = new TransitionModel(intentionProb,cwProb,ccwProb);
        TileUtilityMap tileUtilityMap1 = valueIteration(env1,transition1,
                discountFactor,epsilon);
        
        System.out.println("Value Iteration - Utility Map: ");
        tileUtilityMap1.displayMap();
        System.out.println("");
        
        System.out.println("Value Iteration - Utility Array: ");
        tileUtilityMap1.displayUtilityArray();
        System.out.println("");
        
        System.out.println("Value Iteration - Policy: ");
        tileUtilityMap1.displayPolicy();
        System.out.println("");
        
        System.out.println("==================================================");
        
        // Policy Iteration
        TileUtilityMap tileUtilityMap2 = policyIteration(env1,
                transition1,discountFactor,policyEvalIterations);
        
        System.out.println("Policy Iteration - Utility Map: ");
        tileUtilityMap2.displayMap();
        System.out.println("");
        
        System.out.println("Policy Iteration - Utility Array: ");
        tileUtilityMap2.displayUtilityArray();
        System.out.println("");
        
        System.out.println("Policy Iteration - Policy: ");
        tileUtilityMap2.displayPolicy();
        System.out.println("");
        
        System.out.println("==================================================");
    }
    
    /**
    * Wrap the code for part 2 of the assignment into a function
    */
    private static void assignmentPart2Enlarged() {
        // Initialise parameters
        TileEnv env1 = generatePart2EnlargedEnvironment();
        double discountFactor = 0.99;
        double intentionProb = 0.80;
        double cwProb = 0.1;
        double ccwProb = 0.1;
        double epsilon = 0.1;
        int policyEvalIterations = 12;
       
        System.out.println("Settings ==========================================");
        System.out.println("Discount Factor: " + discountFactor);
        System.out.println("Transition Model Probability (i,cw,ccw): " +
                intentionProb + "," + cwProb + "," + ccwProb);
        System.out.println("Epsilon: " + epsilon);
        System.out.println("Number of iterations for Policy Evaluation: " +
                policyEvalIterations);
        
        System.out.println("Tile Environment:  ");
        env1.printEnv();
        System.out.println("Legend: +1 reward [+], -1 reward [x], wall [#]");
        System.out.println("");
        System.out.println("==================================================");
        
        // Value Iteration
        TransitionModel transition1 = new TransitionModel(intentionProb,cwProb,ccwProb);
        TileUtilityMap tileUtilityMap1 = valueIteration(env1,transition1,
                discountFactor,epsilon);
        
        System.out.println("Value Iteration - Utility Map: ");
        tileUtilityMap1.displayMap();
        System.out.println("");
        
        System.out.println("Value Iteration - Utility Array: ");
        tileUtilityMap1.displayUtilityArray();
        System.out.println("");
        
        System.out.println("Value Iteration - Policy: ");
        tileUtilityMap1.displayPolicy();
        System.out.println("");
        
        System.out.println("==================================================");
        
        // Policy Iteration
        TileUtilityMap tileUtilityMap2 = policyIteration(env1,
                transition1,discountFactor,policyEvalIterations);
        
        System.out.println("Policy Iteration - Utility Map: ");
        tileUtilityMap2.displayMap();
        System.out.println("");
        
        System.out.println("Policy Iteration - Utility Array: ");
        tileUtilityMap2.displayUtilityArray();
        System.out.println("");
        
        System.out.println("Policy Iteration - Policy: ");
        tileUtilityMap2.displayPolicy();
        System.out.println("");
        
        System.out.println("==================================================");
    }
    
    /**
    * Wrap the code for part 2 of the assignment into a function
    */
    private static void assignmentPart2Complex() {
        // Initialise parameters
        TileEnv env1 = generatePart2ComplexEnvironment();
        double discountFactor = 0.99;
        double intentionProb = 0.80;
        double cwProb = 0.1;
        double ccwProb = 0.1;
        double epsilon = 0.1;
        int policyEvalIterations = 12;
       
        System.out.println("Settings ==========================================");
        System.out.println("Discount Factor: " + discountFactor);
        System.out.println("Transition Model Probability (i,cw,ccw): " +
                intentionProb + "," + cwProb + "," + ccwProb);
        System.out.println("Epsilon: " + epsilon);
        System.out.println("Number of iterations for Policy Evaluation: " +
                policyEvalIterations);
        
        System.out.println("Tile Environment:  ");
        env1.printEnv();
        System.out.println("Legend: +1 reward [+], -1 reward [x], wall [#]");
        System.out.println("");
        System.out.println("==================================================");
        
        // Value Iteration
        TransitionModel transition1 = new TransitionModel(intentionProb,cwProb,ccwProb);
        TileUtilityMap tileUtilityMap1 = valueIteration(env1,transition1,
                discountFactor,epsilon);
        
        System.out.println("Value Iteration - Utility Map: ");
        tileUtilityMap1.displayMap();
        System.out.println("");
        
        System.out.println("Value Iteration - Utility Array: ");
        tileUtilityMap1.displayUtilityArray();
        System.out.println("");
        
        System.out.println("Value Iteration - Policy: ");
        tileUtilityMap1.displayPolicy();
        System.out.println("");
        
        System.out.println("==================================================");
        
        // Policy Iteration
        TileUtilityMap tileUtilityMap2 = policyIteration(env1,
                transition1,discountFactor,policyEvalIterations);
        
        System.out.println("Policy Iteration - Utility Map: ");
        tileUtilityMap2.displayMap();
        System.out.println("");
        
        System.out.println("Policy Iteration - Utility Array: ");
        tileUtilityMap2.displayUtilityArray();
        System.out.println("");
        
        System.out.println("Policy Iteration - Policy: ");
        tileUtilityMap2.displayPolicy();
        System.out.println("");
        
        System.out.println("==================================================");
    }
    
    /**
    * Perform policy iteration to obtain the optimal utility and policy for each
    * tile in the environment
    * @param tileEnv The tile environment to perform value iteration in
    * @param transitionModel The transition model used in calculations
    * @param discountFactor The discounting factor used in calculations
    * @param kIterations The number of times to calculate tile utility in 
    *                    policy evaluation
    * @return The final tile utility map with the optimal utility and policy
    */
    public static TileUtilityMap policyIteration(TileEnv tileEnv,
            TransitionModel transitionModel,double discountFactor, int kIterations) {
        
        /**
        * A 2 dimensional array of utility values that maps to the tile
        * environment for a particular iteration
        */
        double[][] utilitySnapshot;
        
        /**
        * An array list that stores the utility map of all iterations
        */
        List<double[][]> utilityLog = new ArrayList();
        
        /**
        * Variable to store the flag to indicate whether a policy changed
        */
        boolean unchanged;
        Action tempAction;
        
        /**
        * Track number of iterations
        */
        int numberOfIterations = 0;
        
        /**
        * Derive the height of the utility map from the mapped tile environment
        */
        int height = tileEnv.getHeight();
        
        /**
        * Derive the width of the utility map from the mapped tile environment
        */
        int width = tileEnv.getWidth();
        
        ActionUtilityPair newActionUtilityPair;
        
        /**
        * Utility of the tile from the previous iteration
        */
        double newUtility;
        
        /**
        * Utility of the tile from current iteration
        */
        double curUtility;
        
        TileUtilityMap newUtilityMap = new TileUtilityMap(
            tileEnv,transitionModel,discountFactor);
        TileUtilityMap curUtilityMap;

        // Set random directions as policy for each tile
        for (int row=0; row<height; row++) {
            for (int col=0; col<width; col++) {
                if(tileEnv.getTile(row, col).getState() == TileState.WALL) {
                    continue;
                }
                newUtilityMap.getTileActionUtilityPair(row, col).setAction(Action.getRandomAction());
            }
        }
        
        // Set the newly made utility map to be used for calculations
        BellmanEquation bellmanEquation = new BellmanEquation(newUtilityMap);
        
        do {
            // Policy Evaluation
            for (int i=0;i<kIterations;i++) {
                curUtilityMap = (TileUtilityMap) deepCopy(newUtilityMap);
                bellmanEquation.changeTileUtilityMap(curUtilityMap);
                
                for (int row=0; row<height; row++) {
                    for (int col=0; col<width; col++) {
                        // Skip calculations for walls
                        if(tileEnv.getTile(row, col).getState() == TileState.WALL) {
                            continue;
                        }
                        
                        // Calculate the utility for the tile
                        tempAction = curUtilityMap.getTileAction(row, col);
                        newUtility = bellmanEquation.getActionUtility(row, col, tempAction);
                        newUtilityMap.setTileUtility(row, col, newUtility);
                    }
                }
            }
            unchanged = true;
            curUtilityMap = (TileUtilityMap) deepCopy(newUtilityMap);
            bellmanEquation.changeTileUtilityMap(curUtilityMap);
            
            utilitySnapshot = new double[height][width];
            
            // For each tile in this iteration
            for (int row=0; row<height; row++) {
                for (int col=0; col<width; col++) {
                    // Skip calculations for walls
                    if(tileEnv.getTile(row, col).getState() == TileState.WALL) {
                        continue;
                    }
                    newActionUtilityPair = bellmanEquation.getMaxActionUtilityPair(row, col);
                    newUtility = newActionUtilityPair.getUtility();
                    curUtility = curUtilityMap.getTileUtility(row, col);
                    
                    // If policy needs to change
                    if (newUtility > curUtility) {
			newUtilityMap.setTileAction(row, col,
                                newActionUtilityPair.getAction());
                        // Notify that a policy has changed
			unchanged = false;
                    }
                    
                    utilitySnapshot[row][col] = curUtility;
                }
            }
            utilityLog.add(utilitySnapshot);
            numberOfIterations++;
            // Iterate until no tile requires a change in policy
        }while(unchanged != true);    
        System.out.println("Number of iterations: " + numberOfIterations);
        
        // Export the utility map log
        utilityLogToCSV(utilityLog,"dataPolicy");
        return newUtilityMap;
    }
    
    /**
    * Perform value iteration to obtain the optimal utility and policy for each
    * tile in the environment
    * @param tileEnv The tile environment to perform value iteration in
    * @param transitionModel The transition model used in calculations
    * @param discountFactor The discounting factor used in calculations
    * @param epsilon The convergence criteria to stop iterating
    * @return The final tile utility map with the optimal utility and policy
    */
    public static TileUtilityMap valueIteration(TileEnv tileEnv,
            TransitionModel transitionModel, double discountFactor,
            double epsilon) {
        
        /**
        * Track number of iterations
        */
        int numberOfIterations = 0;
        
        /**
        * A 2 dimensional array of utility values that maps to the tile
        * environment for a particular iteration
        */
        double[][] utilitySnapshot;
        
        /**
        * An array list that stores the utility map of all iterations
        */
        List<double[][]> utilityLog = new ArrayList();
        
        /**
        * Utility of the tile from the previous iteration
        */
        double newUtility;
        
        /**
        * Utility of the tile from current iteration
        */
        double curUtility;
        
        /**
        * Derive the height of the utility map from the mapped tile environment
        */
        int height = tileEnv.getHeight();
        
        /**
        * Derive the width of the utility map from the mapped tile environment
        */
        int width = tileEnv.getWidth();
        
                
        /**
        * Used to store the value to compare with the convergence criteria
        * (Difference between state utility of the current 
        * and previous iteration)
        */
        double delta;
        
        /**
        * Used to store the maximum delta from all the iterations
        */
        double deltaMax;
        
        // Convergence criteria is defined as:
        double convergenceCriteria =
            epsilon * ((1.000 - discountFactor) / discountFactor);
        
        TileUtilityMap newUtilityMap = new TileUtilityMap(
                tileEnv,transitionModel,discountFactor);
        TileUtilityMap curUtilityMap;
        
        // Create a new bellman equation to ease calculations
        BellmanEquation bellmanEquation = new BellmanEquation(newUtilityMap);

        do {
            // Make a copy of the old utility map
            curUtilityMap = (TileUtilityMap) deepCopy(newUtilityMap);
            
            // Base calculations on the old utility map
            bellmanEquation.changeTileUtilityMap(curUtilityMap);
            utilitySnapshot = new double[height][width];
            
            // Set delta max to 0
            deltaMax = 0.0;
			
            // For each tile
            for(int row = 0 ; row < height ; row++) {
		for(int col = 0 ; col < width ; col++) {
		    if(tileEnv.getTile(row, col).getState() == TileState.WALL) {
                        continue;
                    }
                    
                    // Get the max new utility
                    newUtilityMap.setTileActionUtility(row,col,
                        bellmanEquation.getMaxActionUtilityPair(row, col));
                                
		    newUtility = newUtilityMap.getTileUtility(row,col);
                    curUtility = curUtilityMap.getTileUtility(row,col);
                    
                    // Get the absolute difference between old and new utility
		    delta = Math.abs(newUtility - curUtility);
		        	
                    // Update maximum delta across all iterations
		    deltaMax = Math.max(deltaMax, delta);
                    
                    // Log the utility of the tile
                    utilitySnapshot[row][col] = newUtility;
		}
            }
            // Log the utility map in this iteration
            utilityLog.add(utilitySnapshot);
            ++numberOfIterations;
            
            // Iterate until delta max is greater than convergence criteria
	} while (deltaMax >= convergenceCriteria);
        
        System.out.println("Number of iterations: " + numberOfIterations);
        
        // Export the utility map log
        utilityLogToCSV(utilityLog,"dataValue");
        return newUtilityMap;
    }
    
    /**
    * Export the utility log to CSV for graphing purposes
    * @param utilityLog The utility log to be exported
    * @param fileName The name of the exported file
    */
    private static void utilityLogToCSV(List<double[][]> utilityLog,
            String fileName) {
        
        int width = utilityLog.get(0)[0].length;
        int height = utilityLog.get(0).length;
        int row,col;
        String tempString;
        
        StringBuilder sb = new StringBuilder();  
        
        // Build the header
        for (row=0;row<height;row++) {
            for(col=0;col<width;col++) {
                tempString = "("+row+"-"+col+"),";
                sb.append(tempString);
            }
        }
        // Get rid of the last comma
        sb.setLength(Math.max(sb.length() - 1, 0));
        sb.append("\n");
        
        // Build the row data, starting from (0,0) (0,1) (0,2) ... (i,j)
        // Every row will represent 1 iteration
        for (int j=0;j<utilityLog.size();j++) {
            for (row=0;row<height;row++) {
                for(col=0;col<width;col++) {
                    tempString = utilityLog.get(j)[row][col]+",";
                    sb.append(tempString);
                }
                
            }
            sb.setLength(Math.max(sb.length() - 1, 0));   
            sb.append("\n");
        }
        
        // Write the string to a csv file
        try {
            FileWriter fw = new FileWriter(new File(fileName + ".csv"), false);
            fw.write(sb.toString().trim());
            fw.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
    * Hard-coded function to generate the environment for part 1 of the 
    * assignment
    * @return Tile environment required to answer part 1 of the assignment
    */
     public static TileEnv generatePart1Environment() {
        TileEnv env = new TileEnv(6,6);
        // Row1
        env.setTileState(0, 0, TileState.GREEN);
        env.setTileState(0, 1, TileState.WALL);
        env.setTileState(0, 2, TileState.GREEN);
        env.setTileState(0, 5, TileState.GREEN);
        
        // Row2
        env.setTileState(1, 1, TileState.BROWN);
        env.setTileState(1, 3, TileState.GREEN);
        env.setTileState(1, 4, TileState.WALL);
        env.setTileState(1, 5, TileState.BROWN);
        
        // Row3
        env.setTileState(2, 2, TileState.BROWN);
        env.setTileState(2, 4, TileState.GREEN);
        
        // Row4
        env.setTileState(3, 3, TileState.BROWN);
        env.setTileState(3, 5, TileState.GREEN);
        
        // Row5
        env.setTileState(4, 1, TileState.WALL);
        env.setTileState(4, 2, TileState.WALL);
        env.setTileState(4, 3, TileState.WALL);
        env.setTileState(4, 4, TileState.BROWN);
        
        // Row6
        
        return env;
    }
     
    /**
    * Hard-coded function to generate the environment for part 2 of the 
    * assignment to study how the number of states affect convergence
    * @return Tile environment required to answer part 2 of the assignment
    */
     public static TileEnv generatePart2EnlargedEnvironment() {
        TileEnv env = new TileEnv(12,12);
        // Row1
        env.setTileState(0, 0, TileState.GREEN);
        env.setTileState(0, 1, TileState.GREEN);
        env.setTileState(0, 2, TileState.WALL);
        env.setTileState(0, 3, TileState.WALL);
        env.setTileState(0, 4, TileState.GREEN);
        env.setTileState(0, 5, TileState.GREEN);
        env.setTileState(0, 10, TileState.GREEN);
        env.setTileState(0, 11, TileState.GREEN);
        
        // Row 2
        env.setTileState(1, 0, TileState.GREEN);
        env.setTileState(1, 1, TileState.GREEN);
        env.setTileState(1, 2, TileState.WALL);
        env.setTileState(1, 3, TileState.WALL);
        env.setTileState(1, 4, TileState.GREEN);
        env.setTileState(1, 5, TileState.GREEN);
        env.setTileState(1, 10, TileState.GREEN);
        env.setTileState(1, 11, TileState.GREEN);
        
        // Row 3
        env.setTileState(2, 2, TileState.BROWN);
        env.setTileState(2, 3, TileState.BROWN);
        env.setTileState(2, 6, TileState.GREEN);
        env.setTileState(2, 7, TileState.GREEN);
        env.setTileState(2, 8, TileState.WALL);
        env.setTileState(2, 9, TileState.WALL);
        env.setTileState(2, 10, TileState.BROWN);
        env.setTileState(2, 11, TileState.BROWN);
        
        // Row 4
        env.setTileState(3, 2, TileState.BROWN);
        env.setTileState(3, 3, TileState.BROWN);
        env.setTileState(3, 6, TileState.GREEN);
        env.setTileState(3, 7, TileState.GREEN);
        env.setTileState(3, 8, TileState.WALL);
        env.setTileState(3, 9, TileState.WALL);
        env.setTileState(3, 10, TileState.BROWN);
        env.setTileState(3, 11, TileState.BROWN);
        
        // Row 5
        env.setTileState(4, 4, TileState.BROWN);
        env.setTileState(4, 5, TileState.BROWN);   
        env.setTileState(4, 8, TileState.GREEN);
        env.setTileState(4, 9, TileState.GREEN);
        
        // Row 6
        env.setTileState(5, 4, TileState.BROWN);
        env.setTileState(5, 5, TileState.BROWN);   
        env.setTileState(5, 8, TileState.GREEN);
        env.setTileState(5, 9, TileState.GREEN);
        
        // Row 7
        env.setTileState(6, 6, TileState.BROWN);
        env.setTileState(6, 7, TileState.BROWN);
        
        // Row 8
        env.setTileState(7, 6, TileState.BROWN);
        env.setTileState(7, 7, TileState.BROWN);
        
        // Row 9
        env.setTileState(8, 2, TileState.WALL);
        env.setTileState(8, 3, TileState.WALL);
        env.setTileState(8, 4, TileState.WALL);
        env.setTileState(8, 5, TileState.WALL);
        env.setTileState(8, 6, TileState.WALL);
        env.setTileState(8, 7, TileState.WALL);
        
        env.setTileState(8, 8, TileState.BROWN);
        env.setTileState(8, 9, TileState.BROWN);
        
        // Row 10
        env.setTileState(9, 2, TileState.WALL);
        env.setTileState(9, 3, TileState.WALL);
        env.setTileState(9, 4, TileState.WALL);
        env.setTileState(9, 5, TileState.WALL);
        env.setTileState(9, 6, TileState.WALL);
        env.setTileState(9, 7, TileState.WALL);
        
        env.setTileState(9, 8, TileState.BROWN);
        env.setTileState(9, 9, TileState.BROWN);
        
        // Row 11
         
        // Row 12
        
        return env;
    }
     
    /**
    * Hard-coded function to generate the environment for part 2 of the 
    * assignment to study how complexity affect convergence
    * @return Tile environment required to answer part 2 of the assignment
    */
     public static TileEnv generatePart2ComplexEnvironment() {
        TileEnv env = new TileEnv(6,6);
        // Row1
        env.setTileState(0, 0, TileState.GREEN);
        env.setTileState(0, 1, TileState.WALL);
        env.setTileState(0, 2, TileState.GREEN);
        env.setTileState(0, 3, TileState.GREEN);
        env.setTileState(0, 4, TileState.GREEN);
        env.setTileState(0, 5, TileState.BROWN);
        
        // Row2
        env.setTileState(1, 0, TileState.GREEN);
        env.setTileState(1, 1, TileState.WALL);
        env.setTileState(1, 2, TileState.BROWN);
        env.setTileState(1, 3, TileState.WALL);
        env.setTileState(1, 4, TileState.WALL);
        env.setTileState(1, 5, TileState.BROWN);
        
        // Row3
        env.setTileState(2, 0, TileState.BROWN);
        env.setTileState(2, 1, TileState.BROWN);
        env.setTileState(2, 2, TileState.GREEN);
        env.setTileState(2, 3, TileState.GREEN);
        env.setTileState(2, 4, TileState.WALL);
        env.setTileState(2, 5, TileState.GREEN);
        
        // Row4
        env.setTileState(3, 0, TileState.BROWN);
        env.setTileState(3, 1, TileState.BROWN);
        env.setTileState(3, 2, TileState.GREEN);
        env.setTileState(3, 3, TileState.GREEN);
        env.setTileState(3, 4, TileState.WALL);
        env.setTileState(3, 5, TileState.GREEN);
        
        // Row5
        env.setTileState(4, 0, TileState.GREEN);
        env.setTileState(4, 1, TileState.WALL);
        env.setTileState(4, 2, TileState.WALL);
        env.setTileState(4, 3, TileState.WALL);
        env.setTileState(4, 4, TileState.WALL);
        env.setTileState(4, 5, TileState.BROWN);
        
        // Row6
        env.setTileState(5, 0, TileState.BROWN);
        env.setTileState(5, 1, TileState.GREEN);
        env.setTileState(5, 2, TileState.BROWN);
        env.setTileState(5, 3, TileState.BROWN);
        env.setTileState(5, 4, TileState.BROWN);
        env.setTileState(5, 5, TileState.GREEN);
        
        return env;
    }
}
