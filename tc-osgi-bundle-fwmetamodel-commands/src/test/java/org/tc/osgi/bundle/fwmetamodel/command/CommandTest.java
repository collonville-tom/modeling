package org.tc.osgi.bundle.fwmetamodel.command;

import org.junit.Assert;
import org.junit.Test;
import org.tc.osgi.bundle.fwmetamodel.command.config.AbstractConfigAssociation;
import org.tc.osgi.bundle.fwmetamodel.command.config.instance.EntityConfig;
import org.tc.osgi.bundle.fwmetamodel.command.config.instance.ModelConfig;
import org.tc.osgi.bundle.fwmetamodel.command.config.instance.RelationConfig;
import org.tc.osgi.bundle.fwmetamodel.command.config.type.MetaEntityConfig;
import org.tc.osgi.bundle.fwmetamodel.command.config.type.MetaModelConfig;
import org.tc.osgi.bundle.fwmetamodel.command.config.type.MetaRelationConfig;
import org.tc.osgi.bundle.fwmetamodel.command.core.instance.CreateAttribute;
import org.tc.osgi.bundle.fwmetamodel.command.core.instance.CreateEntity;
import org.tc.osgi.bundle.fwmetamodel.command.core.instance.CreateModel;
import org.tc.osgi.bundle.fwmetamodel.command.core.instance.CreateRelation;
import org.tc.osgi.bundle.fwmetamodel.command.core.type.CreateMetaAttribute;
import org.tc.osgi.bundle.fwmetamodel.command.core.type.CreateMetaEntity;
import org.tc.osgi.bundle.fwmetamodel.command.core.type.CreateMetaModel;
import org.tc.osgi.bundle.fwmetamodel.command.core.type.CreateMetaRelation;
import org.tc.osgi.bundle.fwmetamodel.command.module.service.CommandRunnerUtilsProxy;
import org.tc.osgi.bundle.utils.interf.pattern.command.exception.CommandExecutionException;

/**
 * CommandTest.java.
 * @author Collonville Thomas
 * @version 0.0.1
 * @req STD_BUNDLE_FWMETAMODEL_COMMANDS_010
 * @tack SRS_BUNDLE_FWMETAMODEL_COMMANDS_010, SRS_BUNDLE_FWMETAMODEL_COMMANDS_020, SRS_BUNDLE_FWMETAMODEL_COMMANDS_030
 */
public class CommandTest {

	/**
	 * test.
	 */
	@Test
	public void test() {
		new CreateMetaModel("ReseauRoutier");
		new CreateMetaModel("DiagrammeDesClasses");

		new CreateMetaRelation("Route");
		new CreateMetaRelation("Autoroute");

		new CreateMetaEntity("Ville");
		new CreateMetaEntity("Village");

		new CreateMetaAttribute<Integer>("Integer", 0);
		new CreateMetaAttribute<Double>("Float", 0.0);

		final AbstractConfigAssociation cListA = new MetaModelConfig("ReseauRoutier");
		cListA.add("Integer");
		cListA.add("Route");
		cListA.add("Autoroute");
		cListA.add("Ville");
		cListA.add("Village");

		final AbstractConfigAssociation cListB = new MetaEntityConfig("Ville");
		cListB.add("Integer");
		cListB.add("Float");

		final AbstractConfigAssociation cListC = new MetaEntityConfig("Village");
		cListC.add("Integer");
		cListC.add("Float");

		final AbstractConfigAssociation cListD = new MetaRelationConfig("Route");
		cListD.add("Integer");
		cListD.add("Ville");
		cListD.add("Village");

		final AbstractConfigAssociation cListE = new MetaRelationConfig("Autoroute");
		cListE.add("Integer");
		cListE.add("Ville");

		new CreateModel("ReseauRoutier", "Alsace");
		new CreateModel("ReseauRoutier", "Nord");

		new CreateEntity("Ville", "Mulhouse");
		new CreateEntity("Ville", "Belfort");
		new CreateEntity("Village", "Dornach");
		new CreateEntity("Village", "Brunstat");

		new CreateRelation("Route", "D22");
		new CreateRelation("Route", "N66");
		new CreateRelation("Route", "A36");

		new CreateAttribute("Integer", "Population");
		new CreateAttribute("Integer", "Distance");
		new CreateAttribute("Integer", "Superficie");
		new CreateAttribute("Float", "Temperature");

		final AbstractConfigAssociation cListF = new ModelConfig("Alsace");
		cListF.add("Mulhouse");
		cListF.add("Belfort");
		cListF.add("Dornach");
		cListF.add("Brunstat");
		cListF.add("D22");
		cListF.add("N66");
		cListF.add("A36");
		cListF.add("Population");
		cListF.add("Superficie");
		cListF.add("Temperature");

		final AbstractConfigAssociation cListG = new EntityConfig("Mulhouse");
		cListG.add("Population");
		cListG.add("Superficie");
		cListG.add("Temperature");

		final AbstractConfigAssociation cListH = new EntityConfig("Belfort");
		cListH.add("Population");
		cListH.add("Superficie");
		cListH.add("Temperature");

		final AbstractConfigAssociation cListI = new EntityConfig("Brunstat");
		cListI.add("Population");
		cListI.add("Superficie");
		cListI.add("Temperature");

		final AbstractConfigAssociation cListJ = new EntityConfig("Dornach");
		cListJ.add("Population");
		cListJ.add("Superficie");
		cListJ.add("Temperature");

		final AbstractConfigAssociation cListK = new RelationConfig("D22");
		cListK.add("Mulhouse");
		cListK.add("Dornach");
		cListK.add("Brunstat");
		cListK.add("Distance");

		final AbstractConfigAssociation cListL = new RelationConfig("N66");
		cListL.add("Mulhouse");
		cListL.add("Dornach");
		cListL.add("Brunstat");
		cListL.add("Distance");

		final AbstractConfigAssociation cListM = new RelationConfig("A36");
		cListM.add("Mulhouse");
		cListM.add("Belfort");
		cListM.add("Distance");

		try {
			CommandRunnerUtilsProxy.getInstance().getRunner().exec();
		} catch (final CommandExecutionException e) {
			Assert.fail();
		}

	}
}
