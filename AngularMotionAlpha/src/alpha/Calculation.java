package alpha;

public class Calculation {
	double aVelocity;
	double lVelocity;
	double radius;
	double angle;
	double time;
	double aLength;

	public static final String ANGULAR_V = "w";
	public static final String LINEAR_V = "v";

	public Calculation() {
	}

	public void setAngularVelocity(double value) {
		this.aVelocity = value;
	}

	public void setLinearVelocity(double value) {
		this.lVelocity = value;
	}

	public void setRadius(double value) {
		this.radius = value;
	}

	public void setAngle(double value) {
		this.angle = value;
	}

	public void setTime(double value) {
		this.time = value;
	}

	public void setArcLength(double value) {
		this.aLength = value;
	}

	public double getAngularVelocity(double value) {
		return aVelocity;
	}

	public double getLinearVelocity(double value) {
		return lVelocity;
	}

	public double getRadius(double value) {
		return radius;
	}

	public double getAngle(double value) {
		return angle;
	}

	public double getTime(double value) {
		return time;
	}

	public double getArcLength(double value) {
		return aLength;
	}

	public void calculate(String varName) {
		if (varName.equalsIgnoreCase("w")) {
		}
	}
}