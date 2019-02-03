package de.fhl.ultimaster.api.v1.connection.materials;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.materials.MaterialsGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class MaterialsGetTest {

    @Test
    public void testMaterialsGetTest() {
        Assert.assertNotNull(MaterialsGet.get(TestPrinter.getInstance().getPrinter()));
    }

}
