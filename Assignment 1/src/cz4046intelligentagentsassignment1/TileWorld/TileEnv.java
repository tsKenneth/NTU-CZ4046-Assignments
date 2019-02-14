package cz4046intelligentagentsassignment1.TileWorld;

import java.io.Serializable;

/**
 * Class that represents the Tile Environment that the agent operates in
 * @author Kenneth
 */
public class TileEnv implements Serializable {
    /**
    * Nested array of tiles that form the Tile Environment
    */
    private Tile[][] environment;
    
    /**
    * Height of the Tile Environment
    */
    private int height;
    
    /**
    * Width of the Tile Environment
    */
    private int width;
    
    /**
    * Define a new Tile Environment. 
    * By default, all tiles are of the state White and can be changed later
    * 
    * @param width The width of the Tile Environment
    * @param height the height of the Tile Environment
    */
    public TileEnv(int width, int height) {
        environment = new Tile[width][height];
        this.height = height;
        this.width = width;
        for (int row=0; row<height; row++) {
            for (int col=0; col<width; col++) {
                environment[row][col] = new Tile(TileState.WHITE);
            }
        }
    }
    
    /**
    * Prints the Tile Environment in a grid format. Check TileState.java to
    * see what each symbol represents
    * 
    */
    public void printEnv() {
        for (int row=0; row<height; row++) {
            for (int col=0; col<width; col++) {
                System.out.print(environment[row][col].getState().getRepresentation());
            }
            System.out.print("\n");
        }
    }
    
    /**
    * Get the Tile object at the specified row and column in this
    * Tile Environment
    * 
    * @param row Row of the tile object
    * @param col Column of the tile object
    * 
    * @return The tile object
    */
    public Tile getTile(int row, int col) {
        return environment[row][col];
    }
    
    /**
    * Get the width of this Tile Environment
    * 
    * @return The width of this Tile Environment
    */
    public int getWidth() {
        return width;
    }
    
    /**
    * Get the height of this Tile Environment
    * 
    * @return The height of this Tile Environment
    */
    public int getHeight() {
        return height;
    }
    
    /**
    * Set the tile state of the tile object at the specified row and column in
    * this Tile Environment
    * 
    * @param row Row of the tile object
    * @param col Column of the tile object
    * @param tileState The new tile state of the tile object
    */
    public void setTileState(int row, int col, TileState tileState) {
        environment[row][col].setState(tileState);
    }
    
    /**
    * Set the reward of the tile object at the specified row and column in
    * this Tile Environment
    * 
    * @param row Row of the tile object
    * @param col Column of the tile object
    * @param reward The new reward of the tile object
    */
    public void setTileReward(int row, int col, double reward) {
        environment[row][col].setReward(reward);
    }
    
}
