import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;

public class XmlToCsv {

    private static final String PARAM_FILE = "src/main/java/style.xsl";

    public static void execute(String inFile, String outFile) throws ParserConfigurationException, TransformerException, IOException, SAXException {
        File stylesheet = new File(PARAM_FILE);
        File xmlSource = new File(inFile);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlSource);
        StreamSource styleSource = new StreamSource(stylesheet);
        Transformer transformer = TransformerFactory.newInstance().newTransformer(styleSource);
        Source source = new DOMSource(document);
        Result outputTarget = new StreamResult(new File(outFile));
        transformer.transform(source, outputTarget);
    }

}
