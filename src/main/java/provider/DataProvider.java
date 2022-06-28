package provider;

import java.util.List;
import java.util.stream.Stream;

public interface DataProvider {
    List<String[]> provideData ();
}
