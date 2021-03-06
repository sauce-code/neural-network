package neural;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Provides methods for reading data from the console.
 * 
 * @author Torben Kr&uuml;ger
 */
public class Terminal {

	/**
	 * The reader for receiving data.
	 */
	private BufferedReader console;

	/**
	 * Creates a new Terminal, which is ready for use.
	 */
	public Terminal() {
		console = new BufferedReader(new InputStreamReader(System.in));
	}

	/**
	 * Returns the next line from the console as a String.
	 * 
	 * @return String read from the console
	 */
	public String readLine() {
		try {
			return console.readLine();
		} catch (IOException e) {
			return "\n";
		}
	}

	/**
	 * Returns the next line from the console interpreted as an int. Only the
	 * first digits including a sign will be read.
	 * 
	 * @return int read from the console
	 */
	public int readInt() {
		return parseInt(readLine());
	}

	/**
	 * Parses a String to an int.
	 * 
	 * @param string
	 *            the String to be parsed
	 * @return
	 * 		<ul>
	 *         <li>the parsed int</li>
	 *         <li>{@code 0}, if an error occurred</li>
	 *         </ul>
	 */
	private int parseInt(String string) {
		try {
			return Integer.parseInt(string);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	/**
	 * Returns the next line from the console interpreted as an long. Only the
	 * first digits including a sign will be read.
	 * 
	 * @return long read from the console
	 */
	public long readLong() {
		return parseLong(readLine());
	}

	/**
	 * Parses a String to an long.
	 * 
	 * @param string
	 *            the String to be parsed
	 * @return
	 * 		<ul>
	 *         <li>the parsed long</li>
	 *         <li>{@code 0L}, if an error occurred</li>
	 *         </ul>
	 */
	private long parseLong(String string) {
		try {
			return Long.parseLong(string);
		} catch (NumberFormatException e) {
			return 0L;
		}
	}

	/**
	 * Returns the next line from the console interpreted as an double. Only the
	 * first digits including a sign will be read.
	 * 
	 * @return double read from the console
	 */
	public double readDouble() {
		return parseDouble(readLine());
	}
	
	/**
	 * Parses a String to a double.
	 * 
	 * @param string
	 *            the String to be parsed
	 * @return
	 * 		<ul>
	 *         <li>the parsed double</li>
	 *         <li>{@code 0.0}, if an error occurred</li>
	 *         </ul>
	 */
	private double parseDouble(String string) {
		try {
			return Double.parseDouble(string);
		} catch (NumberFormatException e) {
			return 0.0;
		}
	}

}
