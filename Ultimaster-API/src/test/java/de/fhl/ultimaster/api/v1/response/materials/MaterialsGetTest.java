package de.fhl.ultimaster.api.v1.response.materials;

import java.util.List;
import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.materials.MaterialsGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class MaterialsGetTest {

    @Test
    public void testMaterialsGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/materials/MaterialsGet.json");
        List<String> materials = MaterialsGetResponseParser.parse(mockedHttpResponse);
        Assert.assertTrue(materials.get(0).equals("string"));
    }

    @Test
    public void testMaterialsGetLiveResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithJsonResponse("de/fhl/ultimaster/api/v1/response/materials/MaterialsGetLive.json");
        List<String> materials = MaterialsGetResponseParser.parse(mockedHttpResponse);
        Assert.assertTrue(materials.size() == 55);
    }

}
