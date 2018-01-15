package org.tc.osgi.bundle.fwmetamodel.core.instance;

import org.junit.Assert;
import org.junit.Test;
import org.tc.osgi.bundle.fwmetamodel.core.module.service.LoggerServiceProxy;
import org.tc.osgi.bundle.fwmetamodel.core.type.MetaAttribute;
import org.tc.osgi.bundle.fwmetamodel.core.type.MetaEntity;
import org.tc.osgi.bundle.fwmetamodel.core.type.MetaRelation;
import org.tc.osgi.bundle.utils.module.service.impl.LoggerUtilsServiceImpl;

/**
 * RelationTest.java.
 * @author thomas collonvillé
 * @version 0.0.1
 * @req STD_BUNDLE_FWMETAMODEL_CORE_040
 * @track SRS_BUNDLE_FWMETAMODEL_CORE_010, SRS_BUNDLE_FWMETAMODEL_CORE_020, SRS_BUNDLE_FWMETAMODEL_CORE_030, SRS_BUNDLE_FWMETAMODEL_CORE_040
 */
public class RelationTest {

	/**
	 * test.
	 */
	@Test
	public void testRelationEntiteAttribute() {
		LoggerServiceProxy.getInstance().setService(new LoggerUtilsServiceImpl());
		// Definition les elements du metamodel
		final MetaRelation re1 = new MetaRelation("Route");
		final MetaRelation re2 = new MetaRelation("Autoroute");

		final MetaEntity me1 = new MetaEntity("Ville");
		re1.addMetaEntity(me1);
		re2.addMetaEntity(me1);
		final MetaEntity me2 = new MetaEntity("Village");
		re1.addMetaEntity(me2);

		final MetaAttribute<Integer> at3 = new MetaAttribute<Integer>("Distance", 0);
		re1.addMetaAttribute(at3);
		re2.addMetaAttribute(at3);

		final Relation d22 = re1.create("D22");
		final Relation a26 = re2.create("A26");

		final Entity mul = me1.create("Mulhouse");
		final Entity belf = me2.create("Belfort");
		Assert.assertEquals(true, d22.addEntity(mul));
		Assert.assertEquals(true, d22.addEntity(belf));
		Assert.assertEquals(true, a26.addEntity(mul));
		Assert.assertEquals("Car belfort est declaré comme village", false, a26.addEntity(belf));

		Assert.assertEquals(true, d22.addAttribute(at3.create("dMulBelfwithRoute")));
		Assert.assertEquals(true, a26.addAttribute(at3.create("dMulBelfwithAutoroute")));

		System.out.println(re1.toString());
		System.out.println(d22.toString());
		Assert.assertNotNull(re1.toString());
		Assert.assertNotNull(d22.toString());
	}

}
