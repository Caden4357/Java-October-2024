import java.util.ArrayList;

public interface ManagerManagement {
	abstract ArrayList<Double> EODReports();
	
	public default boolean validateShiftReports(ArrayList<Double> expecteReports) {
		if(EODReports().equals(expecteReports)) {
			return true;
		}
		else {
			return false;
		}
	}
}
