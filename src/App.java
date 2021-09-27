import java.io.*;
import java.util.*;

public class App
{
	private static final String IN_URL = "C:\\Users\\HP\\Desktop\\VSCODE\\OOP_UET\\JavaReadFiles\\dictionaries.txt";
	private static final String OUT_URL = "C:\\Users\\HP\\Desktop\\VSCODE\\OOP_UET\\JavaReadFiles\\output.txt";
	private static List<String> data = new ArrayList<String>();

	public static void ReadFile() { 
		try {
			File inFile = new File(IN_URL);
			InputStream inputStream = new FileInputStream(inFile);
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
			BufferedReader reader = new BufferedReader(inputStreamReader);
	
			String line = "";
			while((line = reader.readLine()) != null) {
				data.add(line);
			}
			reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
	}

	public static void WriteFile() throws IOException {
		try {
            File outFile = new File(OUT_URL);
			OutputStream outputStream = new FileOutputStream(outFile);
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
			BufferedWriter writer = new BufferedWriter(outputStreamWriter);

			for(String s : data) {
				writer.write(s);
				writer.write("\n");
				// outputStreamWriter.write(s);
				// outputStreamWriter.write("\n");
			}
			writer.flush();
			writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
	}

	public static void main(String[] args) throws Exception {
		ReadFile();
		WriteFile();
	}
}
