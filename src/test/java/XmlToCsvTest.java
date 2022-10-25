import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

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

    @Test()
    public void ioExTest() {
        String input = "C:/Users/ivanm/IdeaProjects/Testovoe_zadanie_maven/src/main/resources/data";
        String output = "C:/Users/ivanm/IdeaProjects/Testovoe_zadanie_maven/src/main/resources/result.csv";
        Throwable thrown = assertThrows(IOException.class, () -> {
            XmlToCsv.execute(input, output);
        });
        Assert.assertNotNull(thrown.getMessage());
    }
}
