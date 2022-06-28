package reporter;

import java.util.List;

public interface Reporter {
    void generateReport ();
    List<String> returnColumnsAvailableForReport ();
    void addFieldToReport (String field);
    void clearFieldsToReport ();
}
