package eu.k13n.graph_search.shared;

public class Benchmark {
	private long startTime;
	private long elapsedTime;
	private long cycles;
	
	public void startTimeMeasurement() {
		startTime = System.nanoTime();
	}
	
	public void stopTimeMeasurement() {
		elapsedTime = System.nanoTime() - startTime;
	}
	
	public long getElapsedTime() {
		return elapsedTime;
	}
	
	public void increaseCycleCount() {
		cycles++;
	}

	public long getCycleCount() {
		return cycles;
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("Cycles in loop: ");
		s.append(cycles);
		s.append("\n");
		s.append("Time elapsed: ");
		s.append(elapsedTime/1000/1000);
		s.append(" ms");
		return s.toString();
	}
}
