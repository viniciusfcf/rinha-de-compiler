import java.util.Arrays;
import java.util.Objects;

public class MyMapKey {

	private final Object[] objects;
	private final int hashCode;
	private String methodName;

	public MyMapKey(String methodName, Object[] objects) {
		this.methodName = methodName;
		this.objects = objects;
		final int prime = 31;
		int result = prime + Arrays.deepHashCode(objects);
		hashCode = prime * result + Objects.hash(methodName);
	}

	public Object[] getObjects() {
		return objects;
	}

	@Override
	public int hashCode() {
		
		return hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof MyMapKey)) {
			return false;
		}
		MyMapKey other = (MyMapKey) obj;
		return hashCode == other.hashCode && Objects.equals(methodName, other.methodName)
				&& Arrays.deepEquals(objects, other.objects);
	}


}
