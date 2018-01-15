package org.tc.osgi.bundle.fwmetamodel.core.instance;

import org.junit.Assert;
import org.junit.Test;
import org.tc.osgi.bundle.fwmetamodel.core.module.service.LoggerServiceProxy;
import org.tc.osgi.bundle.fwmetamodel.core.type.MetaAttribute;
import org.tc.osgi.bundle.fwmetamodel.core.type.MetaEntity;
import org.tc.osgi.bundle.utils.module.service.impl.LoggerUtilsServiceImpl;

/**
 * EntityTest.java.
 * @author thomas collonvillé
 * @version 0.0.1
 * @req STD_BUNDLE_FWMETAMODEL_CORE_020
 * @track SRS_BUNDLE_FWMETAMODEL_CORE_010, SRS_BUNDLE_FWMETAMODEL_CORE_020, SRS_BUNDLE_FWMETAMODEL_CORE_030, SRS_BUNDLE_FWMETAMODEL_CORE_040
 */
public class EntityTest {

	/**
	 * testEntityAttribute.
	 *
	 * Ce test verifie la bonne construction des entité et attribut sur des MetaEntité et MetaAttribut.
	 * Et verifie la bonne veriication lors de la mise en relation au niveau instance.
	 */
	@Test
	public void testEntityAttribute() {
		
		LoggerServiceProxy.getInstance().setService(new LoggerUtilsServiceImpl());
		// Definition les elements du metamodel
		final MetaEntity me1 = new MetaEntity("Ville");
		final MetaEntity me2 = new MetaEntity("Village");

		final MetaAttribute<Integer> at1 = new MetaAttribute<Integer>("Population", 0);
		final MetaAttribute<Double> at2 = new MetaAttribute<Double>("Temperature", 0.0);

		me1.addMetaAttribute(at1);
		me1.addMetaAttribute(at2);
		me2.addMetaAttribute(at1);

		final Entity e1 = me1.create("Mulhouse");
		final Entity e2 = me2.create("Belfort");

		Assert.assertEquals(true, e1.addAttribute(at1.create("popMulhouse")));
		Assert.assertEquals(true, e1.addAttribute(at2.create("tempMulhouse")));
		Assert.assertEquals(true, e2.addAttribute(at1.create("popBelfort")));
		Assert.assertEquals(false, e2.addAttribute(at2.create("tempBelfort")));

		me2.addMetaAttribute(at2);
		Assert.assertEquals(true, e2.addAttribute(at2.create("tempBelfort")));

		System.out.println(me1.toString());
		System.out.println(e1.toString());
		Assert.assertNotNull(me1.toString());
		Assert.assertNotNull(e1.toString());
	}

}
