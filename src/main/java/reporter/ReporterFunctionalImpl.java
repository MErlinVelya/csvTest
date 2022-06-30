package reporter;

import provider.DataProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReporterFunctionalImpl implements Reporter {
    List<String[]> data;
    List<String> columnNames;
    List<Function<String[],String>> functionForFiltering = new ArrayList<>();


    public ReporterFunctionalImpl(DataProvider data) {
        this.data = data.provideData();
        columnNames = returnColumnsAvailableForReport();
    }

    @Override
    public void generateReport() {
        data.stream().map(str -> functionForFiltering.stream().map(func -> func.apply(str)))
                .forEach(a -> System.out.println(reportLine(a.collect(Collectors.toList()))));

    }

    @Override
    public List<String> returnColumnsAvailableForReport() {
        int columnNamesLine = 0;

        return Arrays.asList(data.get(columnNamesLine));
    }

    @Override
    public void addFieldToReport(String field) {
        if (columnNames.contains(field)) {
            prepareFilteringPredicate (field);
        } else {
            System.out.format("No such field \"%s\", please check available column names and try again \n", field);
        }

    }

    @Override
    public void clearFieldsToReport() {
        functionForFiltering = new ArrayList<>();

    }

    private void prepareFilteringPredicate (String field) {
        functionForFiltering.add(a -> a[columnNames.indexOf(field)]);
    }

    private String reportLine (List<String> line) {
        int spacePadding = 10;
        StringBuilder preparedLine = new StringBuilder();

        for (String field : line) {
            preparedLine.append(String.format("%" + -spacePadding + "s", field));
        }
        return preparedLine.toString();
    }
}
