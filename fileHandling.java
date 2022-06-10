import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

public class fileHandling {
	public static void main(String[] args) {
		read();
	}
	
	public static void create() {
		try {
			File myObj = new File("gameRecords.txt");
			if(myObj.createNewFile()) {
				System.out.println("File created:" + myObj.getName());
				

			}else {
				System.out.println("File already exists.");
			}
		}catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		
	}
	
	public static String write(int mode,int AIlvl,int playerID) {
		try {
			FileWriter myWriter = new FileWriter("gameRecords.txt");
			myWriter.write(mode+AIlvl+playerID);
			myWriter.close();
			return "result have been saved";
		}catch (IOException e) {
			System.out.println("An error occured");
			return "An error occured when saving result";
		}
	}
	
	
	public static  read() {
		
		try {
			File myObj = new File("gameRecords.txt");
			Scanner myReader = new Scanner(myObj);
			while(myReader.hasNextLine()) {
			String data = myReader.nextLine();
			System.out.println(data);
		}
			myReader.close();
		}catch(FileNotFoundException e) {
			System.out.println("An error occurred");
		
	}
}
	
}