package neural;

/**
 * Represents a Node in an artificial neural network.
 * 
 * @author Maike Rees
 * @author Torben Kr&uuml;ger
 *
 */
public abstract class Node {

	/**
	 * Returns the current value.
	 * 
	 * @return current value
	 */
	public abstract double getValue();

	/**
	 * Adjusts the delta value.
	 * 
	 * @param delta
	 *            delta given by the Node calling this method
	 */
	public abstract void adjustDelta(double delta);

}
