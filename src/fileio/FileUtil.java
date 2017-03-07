package fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * A class that has methods to copy a file in a different way.
 * 
 * @author Non Puthikanon.
 *
 */
public class FileUtil {

	/**
	 * This method copy a file byte by byte.
	 * 
	 * @param in
	 *            is a source file.
	 * @param out
	 *            is a file that copied from in.
	 */
	static void copy(InputStream in, OutputStream out) {
		try {
			while (in.available() > 0) {
				out.write(in.read());
			}
			in.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	/**
	 * This method copy a file using bite array.
	 * 
	 * @param in
	 *            is a source file.
	 * @param out
	 *            is a file that copied from in.
	 * @param blocksize
	 *            is a size of how much byte do you want to read from a file at
	 *            one time.
	 */
	static void copy(InputStream in, OutputStream out, int blocksize) {
		byte[] buff = new byte[blocksize];
		try {
			while (true) {
				int c = in.read(buff);
				if (c < 0)
					break;
				out.write(c);
			}
			in.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	/**
	 * This method copy a file by using BufferedReader
	 * 
	 * @param in
	 *            is a source file.
	 * @param out
	 *            is a file that copied from in.
	 */
	static void bcopy(InputStream in, OutputStream out) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		PrintWriter write = new PrintWriter(out);
		try {
			while (true) {
				String c = reader.readLine();
				if (c == null)
					break;
				write.write(c);
			}
			in.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	/**
	 * This method copy a file by using BufferedReader and read a file for array
	 * of char at one time.
	 * 
	 * @param in
	 *            is a source file.
	 * @param out
	 *            is a file that copied from in.
	 * @param size
	 *            is a size of how much char you want to read from a file at one
	 *            time.
	 */
	static void charCopy(InputStream in, OutputStream out, int size) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		BufferedWriter write = new BufferedWriter(new OutputStreamWriter(out));
		char[] read = new char[size];
		try {
			while (true) {
				int c = reader.read(read);
				if (c < 0)
					break;
				write.write(c);

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}

	}

}
