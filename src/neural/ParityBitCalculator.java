package neural;

/**
 * Calculates the parity bit of numbers using a feed-forward neural network,
 * which has to be trained before being ready for use.
 * 
 * @author Maike Rees
 * @author Torben Kr&uuml;ger
 *
 */
public class ParityBitCalculator {

	/**
	 * The number of input nodes.
	 */
	public static final int INPUT_NODES = 4;

	/**
	 * The number of hidden nodes.
	 */
	public static final int HIDDEN_NODES = 10;

	/**
	 * The number of output nodes.
	 */
	public static final int OUTPUT_NODES = 1;

	/**
	 * The input nodes.
	 */
	private InputNode[] input;

	/**
	 * The hidden nodes.
	 */
	private HiddenNode[] hidden;

	/**
	 * the output nodes.
	 */
	private OutputNode output;

	/**
	 * Returns a new ParityBitCalculator, which needs to be fed with training
	 * examples before ready to use.
	 * 
	 * @param learningRate
	 *            the learning rate to be used
	 */
	public ParityBitCalculator(double learningRate) {

		input = new InputNode[INPUT_NODES];
		for (int i = 0; i < input.length; i++) {
			input[i] = new InputNode();
		}

		hidden = new HiddenNode[HIDDEN_NODES];
		for (int i = 0; i < hidden.length; i++) {
			hidden[i] = new HiddenNode(input, learningRate);
		}

		output = new OutputNode(hidden, learningRate);
	}

	/**
	 * Trains the network using a specific training example and its solution.
	 * 
	 * @param example
	 *            the training example
	 * @param solution
	 *            the solution for the training example
	 */
	public void train(int[] example, int solution) {

		for (int i = 0; i < input.length; i++) {
			input[i].setValue(example[i]);
		}

		for (int i = 0; i < hidden.length; i++) {
			hidden[i].reset();
		}

		output.adjustDelta(solution);

		for (int i = 0; i < hidden.length; i++) {
			hidden[i].adjustWeights();
		}

		output.adjustWeights();

	}

	/**
	 * Returns the parity bit for a specific input. The accuracy depends on the
	 * number of training examples inserteted before calling this method.
	 * 
	 * @param input
	 *            the bit sequence
	 * @return calculated parity bit
	 */
	public double getParity(int[] input) {
		for (int i = 0; i < INPUT_NODES; i++) {
			this.input[i].setValue(input[i]);
		}
		return output.getValue();
	}

}
