package cosc3p71.ass3;

/**
 * Represents an output Node.
 * 
 * @author Maike Rees
 * @author Torben Kr&uuml;ger
 *
 */
public class OutputNode extends GreaterNode {

	/**
	 * Returns a new OutputNode, which is linked to all Nodes given as an
	 * argument, owning a specific learning rate.
	 * 
	 * @param parents
	 *            the parent Nodes
	 * @param learningRate
	 *            the learning rate
	 */
	public OutputNode(Node[] parents, double learningRate) {
		super(parents, learningRate);
	}

	@Override
	public void adjustDelta(double delta) {
		this.delta = delta - getValue();
		adjustDeltaParents();
	}

}
