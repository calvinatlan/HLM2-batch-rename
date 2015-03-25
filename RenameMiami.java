//Rename Miami
//by Calvin Atlan
//
//Renames all songs in a folder based on a tracklist
//
//Credit to stackoverflow
//http://stackoverflow.com/questions/1844688/read-all-files-in-a-folder
 
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

 public class RenameMiami {
 	public static void main(String[] args){

 		//Tracklist file
 		File tracklist = new File("/Users/marcatlan/Desktop/Calvin Projects/HLM2-batch-rename/hlm2-tracklist.txt");

 		//Read in all lines of the tracklist
 		FileInputStream fstream = new FileInputStream(tracklist);
 		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

 		//Folder containing songs
 		File folder = new File("/Users/marcatlan/Desktop/HLM2/");
 		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
   			 if (file.isFile()) {
   			 	String name = file.getName();
      	  		//System.out.println(name);
    		}
		}

 	}
 }
 
