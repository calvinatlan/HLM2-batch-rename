//Song class for comparing titles

import java.util.*;
import java.io.*;
import java.nio.file.Files;

public class Song{
	private List<String> title;
	private List<String> artist;

	public Song(){
		title = new ArrayList<String>();
		artist = new ArrayList<String>();
	}

	//Using regex, figure out song title and artist from tracklist
	//Removes all non-alpha numberic characters from track for comparative reasons
	public void fromList(String track){
		
		String[] splitTrackTitle = track.split("([0-9]*\\-\\s|\\(.*|\\s+)");
		
		for(int i = 1; i < splitTrackTitle.length; i++){
			title.add(splitTrackTitle[i]);
		}

		String[] splitTrackArtist = track.split("(.*\\(|\\).*|\\s+)");

		for(int i = 1; i < splitTrackArtist.length; i++){
			artist.add(splitTrackArtist[i]);
		}
	}

	public void findSong(File dir) throws IOException{

		String flatTitle = "";
		Iterator<String> itor = title.iterator();
		while(itor.hasNext()){
			flatTitle += itor.next().toLowerCase();
		}

		File[] listOfFiles = dir.listFiles();

		for (File file : listOfFiles) {
   			 if (file.isFile()) {
   			 	String name = file.getName();
   			 	String nameLow = name.toLowerCase().replaceFirst("(\\..{2,4}$)", "");
      	  		if (flatTitle.contains(nameLow)){
      	  			RenameMiami.matches++;
      	  			String newTitle = "";
      	  			String newArtist = "";
      	  			String filetype = "";


      	  			//Compose new track from directory, title, artist and previous filetype
      	  			Iterator<String> itor2 = title.iterator();
					while(itor2.hasNext()){
						newTitle += itor2.next();
						newTitle += " ";
					}
					newTitle = newTitle.trim();

					itor2 = artist.iterator();
					while(itor2.hasNext()){
						newArtist += itor2.next();
						newArtist += " ";
					}
					newArtist = newArtist.trim();

					filetype = name.replaceFirst(".*\\.", "");

					String newTrack = RenameMiami.music_dir + "/" + newTitle + " - " + newArtist + "." + filetype;
					System.out.println(newTrack);

					//Checks if file exists, and user wanted to delete the original copy
      	  			File file2 = new File (newTrack);
      	  			if(file2.exists() && RenameMiami.d == true) Files.delete(file.toPath());
      	  			if(file2.exists()){
      	  				System.out.println("File: \"" + file2.getName() + "\" already exists");
      	  				break;
      	  			}
      	  			Files.copy(file.toPath(), file2.toPath());
      	  			break;
      	  		}
    		}
		}
		
	}

	public void printTitle(){

		Iterator<String> itor = title.iterator();

		while(itor.hasNext()){
			System.out.print(itor.next() + " ");
		}

		System.out.println();
	}
}