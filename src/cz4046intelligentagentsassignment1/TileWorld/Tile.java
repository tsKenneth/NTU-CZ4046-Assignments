package cz4046intelligentagentsassignment1.TileWorld;

import java.io.Serializable;

/**
 * Class that represents a tile on the Tile Environment
 * @author Kenneth
 */
public class Tile implements Serializable{
    
    /**
     * The enum class that represents the state of this tile
     */
    private TileState tileState;
    
    /**
     * The reward of the tile
     */
    private double reward;
    
    /**
     * Create a tile to be placed in a Tile Environment by specifying the reward
     *
     * @param tileState         The enum class that represents the state 
     *                          of this tile
     * @param reward            The reward for being in this tile
     */
    public Tile(TileState tileState,double reward) {
        this.tileState = tileState;
        this.reward = reward;
    }
    
    /**
     * Create a tile to be placed in a Tile Environment by using the default
     * of the tile state
     *
     * @param tileState         The enum class that represents the state 
     *                          of this tile
     */
    public Tile(TileState tileState) {
        this.tileState = tileState;
        this.reward = tileState.getReward();
    }
    
    /**
     * Returns the reward of this tile
     * @return Reward for being in this tile
     */
    public double getReward() {
        return reward;
    }
    
    /**
     * Returns the default reward as specified by the tile state
     * @return Default reward for being in this tile
     */
    public double getDefaultReward() {
        return tileState.getReward();
    }
    
    /**
     * Returns the tile state of this tile
     * @return Tile state of this tile
     */
    public TileState getState() {
        return tileState;
    }
    
    /**
     * Change the reward of this tile
     * @param reward New reward of this tile
     */
    public void setReward(double reward) {
        this.reward = reward;
    }
    
    /**
     * Change the state of this tile and revert reward to default reward
     * @param tileState New state of this tile
     */
    public void setState(TileState tileState) {
        this.tileState = tileState;
        this.reward = tileState.getReward();
    }
    
    /**
     * Change the tile entirely with a new tile
     * @param tileState New state of this tile
     * @param reward New reward of this tile
     */
    public void setTile(TileState tileState, double reward) {
        this.tileState = tileState;
        this.reward = reward;
    }
    
}
