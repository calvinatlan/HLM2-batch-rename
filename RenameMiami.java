//Rename Miami
//by Calvin Atlan
//
//Renames all songs in a folder based on a tracklist
//
//Credit to stackoverflow
//http://stackoverflow.com/questions/1844688/read-all-files-in-a-folder
 
import java.io.*;

 public class RenameMiami {
 	public static void main(String[] args){

 		try{
	 		//Tracklist file
	 		File tracklist = new File("/Users/marcatlan/Desktop/Calvin Projects/HLM2-batch-rename/hlm2-tracklist.txt");

	 		//Read in all lines of the tracklist
	 		FileInputStream fstream = new FileInputStream(tracklist);
	 		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

	 		//Create a Song class for each song on the tracklist
	 		//Will run through files in directory to match titles
	 		String track = null;
	 		while((track = br.readLine()) != null){
	 			Song song = new Song();
	 			song.fromList(track);
	 			song.printTitle();
	 		}

	 		//Folder containing songs
	 		File folder = new File("/Users/marcatlan/Desktop/HLM2/");
	 		File[] listOfFiles = folder.listFiles();

			for (File file : listOfFiles) {
	   			 if (file.isFile()) {
	   			 	String name = file.getName();
	      	  		//System.out.println(name);
	    		}
			}
		}catch(Exception e){
			System.out.println("Error while trying to read file " + e.getMessage());
		}

 	}
 }
 
