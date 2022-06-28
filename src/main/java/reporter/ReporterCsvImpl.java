package reporter;

import provider.DataProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReporterCsvImpl implements Reporter {
    List<String[]> data;
    List<String> columnNames;
    List<String> fieldsToReport;

    public ReporterCsvImpl(DataProvider data) {
        this.data = data.provideData();
        columnNames = returnColumnsAvailableForReport();
        fieldsToReport = new ArrayList<>();
    }

    public void addFieldToReport (String field) {
        if (columnNames.contains(field)) {
            fieldsToReport.add(field);
        } else {
            System.out.format("No such field \"%s\", please check available column names and try again \n", field);
        }
    }

    public void clearFieldsToReport () {
        fieldsToReport.clear();
    }

    public List<String> returnColumnsAvailableForReport () {
        int columnNamesLine = 0;

        return Arrays.asList(data.get(columnNamesLine));
    }

    public void generateReport (){
        data.forEach(a -> System.out.println(reportLine(a)));
    }

    public String reportLine (String[] line) {
        int spacePadding = 10;
        StringBuilder preparedLine = new StringBuilder();

        for (String field : fieldsToReport) {
            preparedLine.append(String.format("%" + -spacePadding + "s", line[columnNames.indexOf(field)]));
        }
        return preparedLine.toString();
    }


}
