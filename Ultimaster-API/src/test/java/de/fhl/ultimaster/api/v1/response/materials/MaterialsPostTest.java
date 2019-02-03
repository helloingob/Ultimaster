package de.fhl.ultimaster.api.v1.response.materials;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.materials.MaterialsPostResponseParser;
import de.fhl.ultimaster.api.v1.utils.MockedResponseHandler;

public class MaterialsPostTest {

    @Test
    public void testMaterialsPostResponseParser() {
        HttpResponse mockedHttpResponse = MockedResponseHandler.mockResponseWithNoResponse(HttpStatus.SC_NO_CONTENT);
        Assert.assertTrue(MaterialsPostResponseParser.parse(mockedHttpResponse));
    }

}
