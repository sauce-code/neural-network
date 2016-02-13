package cosc3p71.ass3;

/**
 * Represents a hidden Node.
 * 
 * @author Maike Rees
 * @author Torben Kr&uuml;ger
 *
 */
public class HiddenNode extends GreaterNode {

	/**
	 * Returns a new HiddenNode, which is linked to all Nodes given as an
	 * argument, owning a specific learning rate.
	 * 
	 * @param parents
	 *            the parent Nodes
	 * @param learningRate
	 *            the learning rate
	 */
	public HiddenNode(Node[] parents, double learningRate) {
		super(parents, learningRate);
	}

	/**
	 * Resets the delta.<br>
	 * Needs to be done during network training.
	 */
	public void reset() {
		delta = 0;
	}

	@Override
	public void adjustDelta(double delta) {
		this.delta += delta;
		adjustDeltaParents();
	}

}
