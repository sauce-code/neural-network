package neural;

/**
 * Represents a Node, which knows his parents and their weights and is able to
 * hold its own delta value.
 * 
 * @author Maike Rees
 * @author Torben Kr&uuml;ger
 *
 */
public abstract class GreaterNode extends Node {

	/**
	 * The minimum initiation value for weights.<br>
	 * Has to be in range {@code [-1.0 , 0.0)}.
	 */
	public static final double WEIGHT_INIT_MIN = -0.5;

	/**
	 * The maximum initiation value for weights.<br>
	 * Has to be in range {@code (0.0 , 1.0]}.
	 */
	public static final double WEIGHT_INIT_MAX = 0.5;

	/**
	 * The parent Nodes.
	 */
	protected Node[] parents;

	/**
	 * The weights of every {@link #parents}.
	 */
	protected double[] weights;

	/**
	 * The learning rate.
	 */
	protected double learningRate;

	/**
	 * The current delta.
	 */
	protected double delta;

	/**
	 * Returns a new GreatherNode, which is linked to all Nodes given as an
	 * argument, owning a specific learning rate.
	 * 
	 * @param parents
	 *            the parent Nodes
	 * @param learningRate
	 *            the learning rate
	 */
	public GreaterNode(Node[] parents, double learningRate) {
		this.parents = parents;
		this.weights = new double[parents.length];
		for (int i = 0; i < weights.length; i++) {
			weights[i] = initWeight();
		}
		this.learningRate = learningRate;
	}

	/**
	 * Returns a random value in range {@code [{@link #WEIGHT_INIT_MIN} ,
	 * {@link #WEIGHT_INIT_MAX}]}.
	 * 
	 * @return random value
	 */
	protected double initWeight() {
		return (Math.random() * (WEIGHT_INIT_MAX - WEIGHT_INIT_MIN)) + WEIGHT_INIT_MIN;
	}

	/**
	 * Returns the input value for this Node, based on the values of
	 * {@link #parents} and their {@link #weights}.
	 * 
	 * @return the input value
	 */
	protected double getInputValue() {
		double sum = 0.0;
		for (int i = 0; i < parents.length; i++) {
			sum += parents[i].getValue() * weights[i];
		}
		return sum;
	}

	@Override
	public double getValue() {
		return sigmoid(getInputValue());
	}

	/**
	 * Adjusts all delta values for all parents.
	 */
	public void adjustDeltaParents() {
		for (int i = 0; i < parents.length; i++) {
			parents[i].adjustDelta(delta * weights[i]);
		}
	}

	/**
	 * Adjusts all weights based on the current {@link #learningRate},
	 * {@link #delta}, {@link #parents} and their {@link #weights}.
	 */
	public void adjustWeights() {
		for (int i = 0; i < weights.length; i++) {
			weights[i] += learningRate * delta * derivative(getInputValue()) * parents[i].getValue();
		}
	}

	/**
	 * Returns the sigmoid value of the given argument. The result will be in
	 * range {@code [0.0 , 1.0]}.
	 * 
	 * @param z
	 *            to calculate the sigmund value from
	 * @return the calculated sigmund value
	 */
	private double sigmoid(double z) {
		return 1.0 / (1.0 + Math.exp(-z));
	}

	/**
	 * Calculates the derivative for a value.
	 * 
	 * @param z
	 *            the value to calculate derivative for
	 * @return the calculated derivative
	 */
	private double derivative(double z) {
		return sigmoid(z) * (1 - sigmoid(z));
	}

}
