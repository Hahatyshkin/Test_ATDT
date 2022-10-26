import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class XmlToCsvTest {

    //Проверить что новосозданный файл совпадает со старым
    //проверить другие исключения

    @Test
    public void fileTest() throws ParserConfigurationException, IOException, TransformerException, SAXException {
        String input = "C:/Users/ivanm/IdeaProjects/Testovoe_zadanie_maven/src/main/resources/data.xml";
        String output = "C:/Users/ivanm/IdeaProjects/Testovoe_zadanie_maven/src/main/resources/result.csv";
        XmlToCsv.execute(input, output);
    }

    @Test
    public void ioExTest() {
        String input = "C:/Users/ivanm/IdeaProjects/Testovoe_zadanie_maven/src/main/resources/data";
        String output = "C:/Users/ivanm/IdeaProjects/Testovoe_zadanie_maven/src/main/resources/result.csv";
        Throwable thrown = assertThrows(IOException.class, () -> {
            XmlToCsv.execute(input, output);
        });
        Assert.assertNotNull(thrown.getMessage());
    }

    @Test
    public void ResultTest() throws ParserConfigurationException, IOException, TransformerException, SAXException {
        String input = "C:/Users/ivanm/IdeaProjects/Testovoe_zadanie_maven/src/main/resources/data.xml";
        String output = "C:\\Users\\ivanm\\IdeaProjects\\Testovoe_zadanie_maven\\src\\test\\resources\\Result_Test.csv";
        String output2 = "C:/Users/ivanm/IdeaProjects/Testovoe_zadanie_maven/src/main/resources/result.csv";
        XmlToCsv.execute(input, output);
        List<String[]> result1 = readerCSV(output, '"', ',');
        List<String[]> result2 = readerCSV(output2, '"', ',');
        if(result1.size()!=result2.size())
        {
            Assert.fail("Содержимое файлов не равно");
        }
        for(int i=0; i<result1.size();i++){
            if(!Arrays.toString(result1.get(i)).equals(Arrays.toString(result2.get(i)))){
                Assert.fail("Содержимое файлов не равно");
            }
        }
    }

    public List<String[]> readerCSV(String csvFile, char quotechar, char separator) throws IOException {

        CSVReader reader = new CSVReader(new FileReader(csvFile), separator, quotechar, 1);
        //Read all rows at once
        List<String[]> allRows = reader.readAll();
        //Read CSV line by line and use the string array as you want
        for(String[] row : allRows){
            System.out.println(Arrays.toString(row));
        }
        return allRows;
    }

}
