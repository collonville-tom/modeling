package org.tc.osgi.bundle.fwmetamodel.core.instance;

import org.junit.Assert;
import org.junit.Test;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.exception.InstanceIteratorException;
import org.tc.osgi.bundle.fwmetamodel.core.interfaces.exception.MetaIteratorException;
import org.tc.osgi.bundle.fwmetamodel.core.module.service.LoggerServiceProxy;
import org.tc.osgi.bundle.fwmetamodel.core.type.MetaAttribute;
import org.tc.osgi.bundle.fwmetamodel.core.type.MetaEntity;
import org.tc.osgi.bundle.fwmetamodel.core.type.MetaModel;
import org.tc.osgi.bundle.fwmetamodel.core.type.MetaRelation;
import org.tc.osgi.bundle.utils.module.service.impl.LoggerUtilsServiceImpl;

/**
 * ModelTest.java.
 * @author thomas collonvillé
 * @version 0.0.1
 * @req STD_BUNDLE_FWMETAMODEL_CORE_030
 * @track SRS_BUNDLE_FWMETAMODEL_CORE_010, SRS_BUNDLE_FWMETAMODEL_CORE_020, SRS_BUNDLE_FWMETAMODEL_CORE_030, SRS_BUNDLE_FWMETAMODEL_CORE_040
 */
public class ModelTest {

	/**
	 * test.
	 */
	@Test
	public void test() {
		
		LoggerServiceProxy.getInstance().setService(new LoggerUtilsServiceImpl());
		// Definition les elements du metamodel
		final MetaModel mo1 = new MetaModel("ReseauRoutier");
		Assert.assertNotNull(mo1.toXML());
		final MetaRelation re1 = new MetaRelation("Route");
		final MetaRelation re2 = new MetaRelation("Autoroute");
		Assert.assertNotNull(re1.toXML());
		final MetaEntity me1 = new MetaEntity("Ville");
		final MetaEntity me2 = new MetaEntity("Village");
		Assert.assertNotNull(me1.toXML());
		final MetaAttribute at1 = new MetaAttribute("Population", "0");
		final MetaAttribute at2 = new MetaAttribute("Temperature", "0.0");
		Assert.assertNotNull(at1.toXML());

		me1.addMetaAttribute(at1);
		me1.addMetaAttribute(at2);
		me2.addMetaAttribute(at1);
		me2.addMetaAttribute(at2);

		re1.addMetaEntity(me1);
		re1.addMetaEntity(me2);
		re2.addMetaEntity(me1);

		mo1.addMetaEntity(me1);
		mo1.addMetaEntity(me2);

		mo1.addMetaRelation(re1);
		mo1.addMetaRelation(re2);

		// Creation du modele
		final Model model = mo1.create("RegionAlsace");

		re1.create("D22");
		re2.create("A26");

		me1.create("Mulhouse");
		me2.create("Belfort");

		at1.create("Mulhouse");
		at2.create("Belfort");

		System.out.println(mo1.toString());
		System.out.println(model.toString());
		Assert.assertNotNull(mo1.toString());
		Assert.assertNotNull(model.toString());

		me1.delete("Mulhouse");

	}

	/**
	 * test2.
	 */
	@Test
	public void test2() {
		// Definition des elements du Meta
		final MetaModel mm1 = new MetaModel("ReseauRoutier");

		final MetaRelation mr1 = new MetaRelation("Route");
		final MetaRelation mr2 = new MetaRelation("Autoroute");

		final MetaEntity me1 = new MetaEntity("Ville");
		final MetaEntity me2 = new MetaEntity("Village");

		final MetaAttribute ma1 = new MetaAttribute("Integer", "0");
		final MetaAttribute ma2 = new MetaAttribute("Float", "0.0");

		// Definition des liens entre Meta
		me1.addMetaAttribute(ma1);
		me1.addMetaAttribute(ma2);
		me2.addMetaAttribute(ma1);
		me2.addMetaAttribute(ma2);

		mr1.addMetaAttribute(ma1);
		mr2.addMetaAttribute(ma1);
		mr1.addMetaEntity(me1);
		mr2.addMetaEntity(me1);
		mr1.addMetaEntity(me2);

		mm1.addMetaAttribute(ma1);
		mm1.addMetaEntity(me1);
		mm1.addMetaEntity(me2);
		mm1.addMetaRelation(mr1);
		mm1.addMetaRelation(mr2);

		// Definition des elements du model

		mm1.create("Alsace");

		final Entity mulhouse = me1.create("Mulhouse");
		final Entity belfort = me1.create("Belfort");
		final Entity dornach = me2.create("Dornach");
		final Entity brunstat = me2.create("Brunstat");
		try {
			mm1.getMetaEntityIterator().getPosition("Ville");
		} catch (final MetaIteratorException e1) {
			Assert.fail(e1.getMessage());
		}
		final Relation d22 = mr1.create("D22");
		final Relation n66 = mr1.create("N66");
		final Relation a36 = mr2.create("A36");

		final Attribute population = ma1.create("Population");
		final Attribute distance = ma1.create("Distance");
		final Attribute temperature = ma2.create("Temperature");
		final Attribute superficie = ma1.create("Superficie");

		// Definition des liens du model

		try {
			mm1.getInstanceIterator().getInstanceAt("Alsace").addEntity(mulhouse);
			mm1.getInstanceIterator().getInstanceAt("Alsace").addEntity(belfort);
			mm1.getInstanceIterator().getInstanceAt("Alsace").addEntity(dornach);
			mm1.getInstanceIterator().getInstanceAt("Alsace").addEntity(brunstat);

			mm1.getInstanceIterator().getInstanceAt("Alsace").addRelation(d22);
			mm1.getInstanceIterator().getInstanceAt("Alsace").addRelation(n66);
			mm1.getInstanceIterator().getInstanceAt("Alsace").addRelation(a36);
			mm1.getInstanceIterator().getInstanceAt("Alsace").addAttribute(superficie);

			mr1.getInstanceIterator().getInstanceAt("D22").addEntity(mulhouse);
			mr1.getInstanceIterator().getInstanceAt("D22").addEntity(dornach);
			mr1.getInstanceIterator().getInstanceAt("D22").addEntity(brunstat);
			mr1.getInstanceIterator().getInstanceAt("D22").addAttribute(distance);

			mr2.getInstanceIterator().getInstanceAt("A36").addEntity(mulhouse);
			mr2.getInstanceIterator().getInstanceAt("A36").addEntity(belfort);
			mr2.getInstanceIterator().getInstanceAt("A36").addAttribute(distance);

			mr1.getInstanceIterator().getInstanceAt("N66").addEntity(mulhouse);
			mr1.getInstanceIterator().getInstanceAt("N66").addEntity(dornach);
			mr1.getInstanceIterator().getInstanceAt("N66").addEntity(brunstat);
			mr1.getInstanceIterator().getInstanceAt("N66").addAttribute(distance);

			me1.getInstanceIterator().getInstanceAt("Mulhouse").addAttribute(population);
			me1.getInstanceIterator().getInstanceAt("Mulhouse").addAttribute(superficie);
			me1.getInstanceIterator().getInstanceAt("Mulhouse").addAttribute(temperature);

			me1.getInstanceIterator().getInstanceAt("Belfort").addAttribute(population);
			me1.getInstanceIterator().getInstanceAt("Belfort").addAttribute(superficie);
			me1.getInstanceIterator().getInstanceAt("Belfort").addAttribute(temperature);

			me2.getInstanceIterator().getInstanceAt("Dornach").addAttribute(population);
			me2.getInstanceIterator().getInstanceAt("Dornach").addAttribute(superficie);
			me2.getInstanceIterator().getInstanceAt("Dornach").addAttribute(temperature);

			me2.getInstanceIterator().getInstanceAt("Brunstat").addAttribute(population);
			me2.getInstanceIterator().getInstanceAt("Brunstat").addAttribute(superficie);
			me2.getInstanceIterator().getInstanceAt("Brunstat").addAttribute(temperature);
		} catch (final InstanceIteratorException e) {
			Assert.fail(e.getMessage());
		}

		System.out.println(mm1.getInstanceIterator().toString());
		Assert.assertNotNull(mm1.getInstanceIterator().toString());
	}

	@Test
	public void testException() {
		final MetaModel mm1 = new MetaModel("ReseauRoutier");

		try {
			mm1.getInstanceIterator().getRelationPosition("toto");
			Assert.fail("Exception non emis");
		} catch (final InstanceIteratorException e) {
			Assert.assertNotNull(e);
		}
		try {
			mm1.getMetaEntityIterator().getPosition("Belfort");
			Assert.fail("Exception non emis");
		} catch (final MetaIteratorException e1) {
			Assert.assertNotNull(e1);
		}

	}

}
