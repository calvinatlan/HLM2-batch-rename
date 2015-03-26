//Rename Miami
//by Calvin Atlan
//
//Renames all songs in a folder based on a tracklist
//
//Credit to stackoverflow
//http://stackoverflow.com/questions/1844688/read-all-files-in-a-folder
 
import java.io.*;
import java.util.*;

 public class RenameMiami {

 	public static int matches = 0;
 	public static boolean d = false;
 	public static String music_dir;

 	public static void main(String[] args){

 		System.out.println("Drag the folder with your music in here: ");
 		Scanner input = new Scanner(System.in);
 		music_dir = input.next();
 		String user_choice = "";
 		while(!(user_choice.equals("y")) && !(user_choice.equals("n"))){
 			System.out.println("Do you want to delete the original files y/n?");
 			user_choice = input.next();
 		}

 		if (user_choice.equals("y")) d = true;


 		try{

	 		//Tracklist file
	 		File tracklist = new File("hlm2-tracklist.txt");
	 		File folder = new File(music_dir);

	 		//Read in all lines of the tracklist
	 		FileInputStream fstream = new FileInputStream(tracklist);
	 		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

	 		//Create a Song class for each song on the tracklist
	 		//Will run through files in directory to match titles
	 		String track = null;

	 		while((track = br.readLine()) != null){
	 			Song song = new Song();
	 			song.fromList(track);
	 			song.findSong(folder);
	 		}
			System.out.println(matches + " matches");

		}catch(Exception e){

			System.out.println("Error: " + e.getMessage());
		}

 	}
 }
