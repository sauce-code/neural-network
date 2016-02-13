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

		int[][] bits = new int[16][];
		bits[0] = new int[] { 0, 0, 0, 0 };
		bits[1] = new int[] { 0, 0, 0, 1 };
		bits[2] = new int[] { 0, 0, 1, 0 };
		bits[3] = new int[] { 0, 0, 1, 1 };
		bits[4] = new int[] { 0, 1, 0, 0 };
		bits[5] = new int[] { 0, 1, 0, 1 };
		bits[6] = new int[] { 0, 1, 1, 0 };
		bits[7] = new int[] { 0, 1, 1, 1 };
		bits[8] = new int[] { 1, 0, 0, 0 };
		bits[9] = new int[] { 1, 0, 0, 1 };
		bits[10] = new int[] { 1, 0, 1, 0 };
		bits[11] = new int[] { 1, 0, 1, 1 };
		bits[12] = new int[] { 1, 1, 0, 0 };
		bits[13] = new int[] { 1, 1, 0, 1 };
		bits[14] = new int[] { 1, 1, 1, 0 };
		bits[15] = new int[] { 1, 1, 1, 1 };

		int[] parity = new int[] { 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0 };

		Terminal t = new Terminal();

		System.out.println("Please enter the number of iterations: ");
		int it = t.readInt();

		System.out.println("Please enter the learning rate (between 0.0 and 1.0): ");
		ParityBitCalculator pbc = new ParityBitCalculator(t.readDouble());

		System.out.println("Training the neural network...");
		for (int j = 0; j < it; j++) {
			for (int i = 0; i < 16; i++) {
				pbc.train(bits[i], parity[i]);
			}
		}

		System.out.println("Checking solutions...");
		for (int i = 0; i < 16; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append("input: ");
			sb.append(Arrays.toString(bits[i]));
			sb.append("   expected: ");
			sb.append(parity[i]);
			sb.append("   output: ");
			sb.append(pbc.getParity(bits[i]) > 0.5 ? 1 : 0);
			sb.append("   raw output: ");
			sb.append(pbc.getParity(bits[i]));
			System.out.println(sb);
		}

	}

}
