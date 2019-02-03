package de.fhl.ultimaster.api.v1.response.materials;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;
import de.fhl.ultimaster.api.v1.materials.MaterialsGetResponseParser;
import de.fhl.ultimaster.api.v1.materials.XmlParser;
import de.fhl.ultimaster.api.v1.objects.xml.FdmMaterial;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class XmlParserTest {

    @Test
    public void testXmlParser() throws SAXException {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/materials/MaterialsGetLive.json");
        List<String> xmlMaterials = MaterialsGetResponseParser.parse(mockedHttpResponse);
        List<FdmMaterial> fdmMaterials = new ArrayList<>();

        for (String xmlMaterial : xmlMaterials) {
            fdmMaterials.add(XmlParser.deserialize(xmlMaterial));
        }
        Assert.assertTrue(fdmMaterials.size() == 55);
    }

}
