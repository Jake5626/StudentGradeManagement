package Data;

public class Subject {
	
	private String id;
	private String name;
	private String score;
	private String rank;
	private String level;
	
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}


	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", score=" + score + ", rank=" + rank + ", level=" + level
				+ "]";
	}
	
	
	
}
