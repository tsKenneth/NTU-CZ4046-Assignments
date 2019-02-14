package cz4046intelligentagentsassignment1.UtilityRules;

import java.io.Serializable;

/**
 * Class that represents a transition model
 * @author Kenneth
 */
public class TransitionModel implements Serializable {
    /**
     * Probability of agent achieving intended outcome
     */
    private double intentionProbability;
    
    /**
     * Probability of agent moving 90 degrees clockwise
     */
    private double cwProbability;
    
    /**
     * Probability of agent moving 90 degrees counter-clockwise
     */
    private double ccwProbability;

    /**
     * Create a transition model given probabilities of the outcome
     *
     * @param intentionProbability  Probability of agent achieving intended outcome
     * @param cwProbability         Probability of agent moving 90 degrees clockwise
     * @param ccwProbability        Probability of agent moving 90 degrees counter-clockwise
     */
    public TransitionModel(double intentionProbability,
            double cwProbability,double ccwProbability) {
        this.intentionProbability = intentionProbability;
        this.cwProbability = cwProbability;
        this.ccwProbability = ccwProbability;
    }
    
    /**
     * Returns probability of agent achieving intended outcome
     * @return Probability of agent achieving intended outcome
     */
    public double getIntentionProbability() {
        return intentionProbability;
    }
    
    /**
     * Returns probability of agent moving 90 degrees clockwise
     * @return Probability of agent moving 90 degrees clockwise
     */
    public double getCWProbability() {
        return cwProbability;
    }
    
    /**
     * Returns probability of agent moving 90 degrees counter-clockwise
     * @return Probability of agent moving 90 degrees counter-clockwise
     */
    public double getCCWProbability() {
        return ccwProbability;
    }
    
    /**
     * Change probability of agent achieving intended outcome
     * @param intentionProbability Probability of agent achieving intended outcome
     */
    public void setIntentionProbability(double intentionProbability) {
        this.intentionProbability = intentionProbability;
    }
    
    /**
     * Change probability of agent moving 90 degrees clockwise
     * @param cwProbability Probability of agent moving 90 degrees clockwise
     */
    public void setCWProbability(double cwProbability) {
        this.cwProbability = cwProbability;
    }
    
    /**
     * Change probability of agent moving 90 degrees counter-clockwise
     * @param ccwProbability Probability of agent moving 90 degrees counter-clockwise
     */
    public void setCCWProbability(double ccwProbability) {
        this.ccwProbability = ccwProbability;
    }
    
}
