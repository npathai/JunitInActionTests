package test.required;

import java.io.IOException;
import java.io.InputStream;

public interface ConnectionFactory {
	public InputStream getData() throws IOException;
}
