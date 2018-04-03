package cz4046intelligentagentsassignment1.TileWorld;

/**
 * Enumeration of all possible tile states
 * @author Kenneth
 */
public enum TileState {
    BROWN("BROWN","[x]",-1),
    GREEN("Green","[+]",1),
    WHITE("White","[ ]",-0.04),
    WALL("Wall","[#]",0);
    
    /**
     * Name of the tile state
     */
    private String tileStateName;
    
    /**
     * String to represent tile state on a grid
     */
    private String representation;
    
    /**
     * Default reward of the tile
     */
    private double reward;
    
    /**
     * Create a new tile state
     *
     * @param tileStateName     Name of the tile state
     * @param representation    String to represent tile state on a grid
     * @param reward            Default reward of the tile
     */
    private TileState (String tileStateName,String representation, double reward){
        this.tileStateName = tileStateName;
        this.representation = representation;
        this.reward = reward;
    }
    
    /**
     * Returns the default reward of the tiles with this tile state
     * @return Default reward for being in a tile with this tile state
     */
    public double getReward() {
        return reward;
    }
    
    /**
     * Returns the string to represent tile state on a grid
     * @return String to represent tile state on a grid
     */
    public String getRepresentation() {
        return representation;
    }
}