package de.fhl.ultimaster.api.v1.response.materials.material_guid;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.materials.material_guid.MaterialsMaterialGuidGetResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class MaterialsMaterialGuidGetTest {

    @Test
    public void testMaterialsMaterialGuidGetResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithStringResponse(HttpStatus.SC_OK);
        Assert.assertTrue(MaterialsMaterialGuidGetResponseParser.parse(mockedHttpResponse).equals("string"));
    }

}
