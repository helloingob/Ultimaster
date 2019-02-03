package de.fhl.ultimaster.api.v1.materials;

import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.sax.SAXSource;
import org.pmw.tinylog.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import de.fhl.ultimaster.api.v1.objects.xml.FdmMaterial;
import de.fhl.ultimaster.utils.NamespaceFilter;

public class XmlParser {

    //https://stackoverflow.com/questions/277502/jaxb-how-to-ignore-namespace-during-unmarshalling-xml-document
    //The namespace is invalid, so it has to be removed/ignored
    public static FdmMaterial deserialize(String material) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(FdmMaterial.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            //Create an XMLReader to use with our filter
            XMLReader reader = XMLReaderFactory.createXMLReader();

            //Create the filter (to add namespace) and set the xmlReader as its parent.
            NamespaceFilter inFilter = new NamespaceFilter(null, true);
            inFilter.setParent(reader);

            //Create a SAXSource specifying the filter
            SAXSource source = new SAXSource(inFilter, new InputSource(new StringReader(material)));

            //Do unmarshalling
            FdmMaterial fdmMaterial = (FdmMaterial) unmarshaller.unmarshal(source);

            return fdmMaterial;
        } catch (JAXBException | SAXException e) {
            Logger.error(e);
        }
        return null;
    }

}
