package fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileUtil {

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
