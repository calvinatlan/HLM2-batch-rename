//Song class for comparing titles

import java.util.*;
import java.io.*;

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
		
		String[] splitTrackTitle = track.split("([0-9]*\\-\\s|\\(.*)|\\.*\\s+");
		
		for(int i = 1; i < splitTrackTitle.length; i++){
			title.add(splitTrackTitle[i]);
		}

		String[] splitTrackArtist = track.split("(.*\\(|\\).*|\\s+)");

		for(int i = 1; i < splitTrackArtist.length; i++){
			artist.add(splitTrackArtist[i]);
		}
	}

	public void compareSong(String track){
		
	}

	public void printTitle(){
		// ListIterator<String> itor = title.ListIterator();
		// while(itor.hasNext()){
		// 	System.out.println(itor.next());
		// }
		System.out.println("Title: " + title);
		System.out.println("Artist: " + artist);
	}
}