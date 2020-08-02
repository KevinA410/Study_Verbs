package classes;

public class Verb {
	public String verb;
	public String past;
	public String partiple;
	public String meaning;
	
	public Verb(String verb, String past, String participle, String meaning) {
		this.verb = verb;
		this.past = past;
		this.partiple = participle;
		this.meaning = meaning;
	}

	public String getVerb() {
		return verb;
	}

	public void setVerb(String verb) {
		this.verb = verb;
	}

	public String getPast() {
		return past;
	}

	public void setPast(String past) {
		this.past = past;
	}

	public String getPartiple() {
		return partiple;
	}

	public void setPartiple(String partiple) {
		this.partiple = partiple;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

}
