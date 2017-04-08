package exam1_1;

public class BoardingPass {
	private String flight;
	private int gate;
	private String seat;
	public String getFlight() {
		return flight;
	}
	public void setFlight(String flight) {
		this.flight = flight;
	}
	public int getGate() {
		return gate;
	}
	public void setGate(int gate) {
		this.gate = gate;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	
	public int group() {
		int group;
		int row = Integer.parseInt(seat.substring(0, seat.length()-1));
		if (row >= 1 && row <= 8) {
			group = 1;
		}
		else if (row >= 9 && row <= 21) {
			group = 2;
		}
		else {
			group = 3;
		}
		return group;
	}
}
