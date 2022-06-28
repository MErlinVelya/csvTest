package provider;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DataProviderCsvImpl implements DataProvider{
    String source;

    DataProviderCsvImpl() {
        source = "";
    }

    public DataProviderCsvImpl(String source) {
        this.source = source;
    }

    public List<String[]> provideData() {
        try (CSVReader reader = new CSVReader(new FileReader(source))) {
            return  reader.readAll();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Unable to read source");
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
