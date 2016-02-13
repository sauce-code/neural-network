package neural;

/**
 * Represents a Node in an artificial neural network.
 * 
 * @author Maike Rees
 * @author Torben Kr&uuml;ger
 *
 */
public class InputNode extends Node {

	/**
	 * The current value.
	 */
	private double value;

	/**
	 * Generates a new {@link InputNode}.
	 */
	public InputNode() {
		this.value = 0;
	}

	/**
	 * Sets the value.
	 * 
	 * @param value
	 *            value
	 */
	public void setValue(int value) {
		this.value = (double) value;
	}

	@Override
	public double getValue() {
		return this.value;
	}

	@Override
	public void adjustDelta(double delta) {
	}

}
