package de.fhl.ultimaster.api.v1.response.materials.material_guid;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.materials.material_guid.MaterialsMaterialGuidPutResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class MaterialsMaterialGuidPutTest {

    @Test
    public void testMaterialsMaterialGuidPutResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithNoResponse(HttpStatus.SC_NO_CONTENT);
        Assert.assertTrue(MaterialsMaterialGuidPutResponseParser.parse(mockedHttpResponse));
    }

}
