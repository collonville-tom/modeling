package org.tc.osgi.bundle.fwmetamodel.command.io.matching;

import static org.junit.Assert.fail;

import java.util.Iterator;

import org.junit.Test;
import org.tc.osgi.bundle.fwmetamodel.command.io.LoadMetaModel;
import org.tc.osgi.bundle.fwmetamodel.command.io.PrintMetaModelOnConsole;
import org.tc.osgi.bundle.fwmetamodel.module.service.impl.FwMetaModelCommandImpl;

/**
 * MatchingTest.java.
 * 
 * @author Collonville Thomas
 * @version 0.0.1
 * @req STD_BUNDLE_FWMETAMODEL_COMMANDS_020
 * @tack SRS_BUNDLE_FWMETAMODEL_COMMANDS_010,
 *       SRS_BUNDLE_FWMETAMODEL_COMMANDS_020,
 *       SRS_BUNDLE_FWMETAMODEL_COMMANDS_030
 */
public class MatchingTest {

	/**
	 * test.
	 */
	@Test
	public void test() {
		try {
			LoadMetaModel lmm=new LoadMetaModel("MetaModel Loader","MetaModelReseauRoutier.xml");
			lmm.exec();
		} catch (ClassNotFoundException e) {
			fail(e.getMessage());
		}
		FwMetaModelCommandImpl fwcmd=new FwMetaModelCommandImpl();
		PrintMetaModelOnConsole pmmc=new PrintMetaModelOnConsole("MetaModel Printer" ,"ReseauRoutier",fwcmd);
		
		Iterator it = fwcmd.getCommandsIterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}

}
