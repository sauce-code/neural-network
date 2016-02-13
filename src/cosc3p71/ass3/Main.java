package cosc3p71.ass3;

import java.util.Arrays;

/**
 * A simple class for holding the main method and needed methods for running
 * {@link ParityBitCalculator}.
 * 
 * @author Maike Rees
 * @author Torben Kr&uuml;ger
 *
 */
public class Main {

	/**
	 * Runs the an instance of {@link ParityBitCalculator} and asks the user for
	 * settings.
	 * 
	 * @param args
	 *            unused
	 */
	public static void main(String[] args) {

		int[][] bits = {
			// @formatter:off
			{ 0, 0, 0, 0 },
			{ 0, 0, 0, 1 },
			{ 0, 0, 1, 0 },
			{ 0, 0, 1, 1 },
			{ 0, 1, 0, 0 },
			{ 0, 1, 0, 1 },
			{ 0, 1, 1, 0 },
			{ 0, 1, 1, 1 },
			{ 1, 0, 0, 0 },
			{ 1, 0, 0, 1 },
			{ 1, 0, 1, 0 },
			{ 1, 0, 1, 1 },
			{ 1, 1, 0, 0 },
			{ 1, 1, 0, 1 },
			{ 1, 1, 1, 0 },
			{ 1, 1, 1, 1 }
			// @formatter:on
		};

		int[] parities = { 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0 };

		Terminal t = new Terminal();

		System.out.println("Please enter the number of iterations: ");
		int it = t.readInt();

		System.out.println("Please enter the learning rate (between 0.0 and 1.0): ");
		ParityBitCalculator pbc = new ParityBitCalculator(t.readDouble());

		System.out.println("Training the neural network...");
		for (int j = 0; j < it; j++) {
			for (int i = 0; i < 16; i++) {
				pbc.train(bits[i], parities[i]);
			}
		}

		System.out.println("Checking solutions...");
		for (int i = 0; i < 16; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append("input: ");
			sb.append(Arrays.toString(bits[i]));
			sb.append("   expected: ");
			sb.append(parities[i]);
			sb.append("   output: ");
			sb.append(pbc.getParity(bits[i]) > 0.5 ? 1 : 0);
			sb.append("   raw output: ");
			sb.append(pbc.getParity(bits[i]));
			System.out.println(sb);
		}

	}

}
