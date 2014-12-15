package genieprojet.aspects;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogger {
	public static void printToLogFile(String toPrint){
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("methodCallLog.txt", true)))) {
		    out.println(toPrint);
		}catch (IOException e) {
		    //exception handling left as an exercise for the reader
		}
	}
}
