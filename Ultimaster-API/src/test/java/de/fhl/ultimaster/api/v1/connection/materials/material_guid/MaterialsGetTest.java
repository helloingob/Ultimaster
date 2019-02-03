package de.fhl.ultimaster.api.v1.connection.materials.material_guid;

import org.junit.Assert;
import org.junit.Test;

import de.fhl.ultimaster.api.v1.materials.material_guid.MaterialsMaterialGuidGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class MaterialsGetTest {

    @Test
    public void testMaterialsMaterialGetTest() {
        Assert.assertNotNull(MaterialsMaterialGuidGet.get(TestPrinter.getInstance().getPrinter(), "fe15ed8a-33c3-4f57-a2a7-b4b78a38c3cb"));
    }

}
