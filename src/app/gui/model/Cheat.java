package app.gui.model;

public class Cheat {

	private String code;
	private String effect;
	
	public Cheat (String code, String effect) {
		
		this.code = code;
		this.effect = effect;
		
	}

	public String getCode() { return code; }

	public void setCode(String code) { this.code = code; }

	public String getEffect() { return effect; }

	public void setEffect(String effect) { this.effect = effect; }
	
	
	
	@Override
	public boolean equals(Object o) {

		if (o instanceof Cheat) {
			if (((Cheat)o).getCode().equalsIgnoreCase(code))
				return true;
			
			return false;
		}
		
		return false;
		
	}

	@Override
	public String toString() { return code + " - " + effect; }
	
}
