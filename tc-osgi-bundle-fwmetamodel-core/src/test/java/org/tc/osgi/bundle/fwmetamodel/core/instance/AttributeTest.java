package org.tc.osgi.bundle.fwmetamodel.core.instance;

import org.junit.Assert;
import org.junit.Test;
import org.tc.osgi.bundle.fwmetamodel.core.module.service.LoggerServiceProxy;
import org.tc.osgi.bundle.fwmetamodel.core.type.MetaAttribute;
import org.tc.osgi.bundle.utils.module.service.impl.LoggerUtilsServiceImpl;

/**
 * AttributeTest.java.
 * @author thomas collonvillé
 * @version 0.0.1
 * @req STD_BUNDLE_FWMETAMODEL_CORE_010
 * @track SRS_BUNDLE_FWMETAMODEL_CORE_010, SRS_BUNDLE_FWMETAMODEL_CORE_020, SRS_BUNDLE_FWMETAMODEL_CORE_030, SRS_BUNDLE_FWMETAMODEL_CORE_040
 */
public class AttributeTest {

	/**
	 * testAttributeMetaAttribute.
	 * On  verifie la bonne initialisation des variables
	 */
	@Test
	public void testAttributeMetaAttribute() {

		LoggerServiceProxy.getInstance().setService(new LoggerUtilsServiceImpl());
		
		final MetaAttribute<Integer> at1 = new MetaAttribute<Integer>("Integer", 0);
		final MetaAttribute<Double> at2 = new MetaAttribute<Double>("Float", 0.0);

		// Definitions du model
		final Attribute valeur1 = at1.create("var1");
		Assert.assertEquals(0, valeur1.getId());
		final Attribute valeur2 = at1.create("var2");
		Assert.assertEquals(1, valeur2.getId());
		final Attribute valeur3 = at2.create("var3");
		Assert.assertEquals(0, valeur3.getId());
		final Attribute valeur4 = at2.create("var4");
		Assert.assertEquals(1, valeur4.getId());

		Assert.assertEquals(2, at1.getInstanceCounter());
		Assert.assertEquals(2, at2.getInstanceCounter());
		Assert.assertEquals(at1, valeur1.getType());
		Assert.assertEquals(at1, valeur2.getType());
		Assert.assertEquals(at2, valeur3.getType());
		Assert.assertEquals(at2, valeur3.getType());

		at1.delete("var1");

		Assert.assertEquals(1, at1.getInstanceCounter());

		System.out.println(at1.toString());
		System.out.println(valeur1.toString());
		Assert.assertNotNull(at1.toString());
		Assert.assertNotNull(valeur1.toString());
		Assert.assertNotNull(valeur1.toXML());
	}

}
