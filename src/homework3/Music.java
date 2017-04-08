package homework3;

public class Music {
	private String title, artist, duration;
	
	public Music(String title, String artist, String duration) {
		this.title = title;
		this.artist = artist;
		this.duration = duration;
	}

	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	public String getDuration() {
		return duration;
	}
	
	public void print() {
		System.out.println("Title: " + getTitle());
		System.out.println("Artist: " + getArtist());
		System.out.println("Duration " + getDuration() + " minutes");
	}
}
