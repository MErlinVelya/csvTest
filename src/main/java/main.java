import provider.DataProvider;
import provider.DataProviderCsvImpl;
import reporter.Reporter;
import reporter.ReporterCsvImpl;

public class main {
    public static void main(String[] args) {
        DataProvider dataProvider = new DataProviderCsvImpl("src/main/resources/input-data.csv");
        Reporter reporterCsv = new ReporterCsvImpl(dataProvider);
        System.out.println(reporterCsv.returnColumnsAvailableForReport());
        reporterCsv.addFieldToReport("Team");
        reporterCsv.addFieldToReport("Original Estimate");
        reporterCsv.generateReport();
    }
}
