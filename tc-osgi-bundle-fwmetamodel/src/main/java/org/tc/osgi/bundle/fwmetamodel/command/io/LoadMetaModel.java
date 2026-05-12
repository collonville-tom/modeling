package org.tc.osgi.bundle.fwmetamodel.command.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.tc.osgi.bundle.fwmetamodel.command.core.AbstractCommand;
import org.tc.osgi.bundle.fwmetamodel.command.io.matching.type.MetaAttributeMatcher;
import org.tc.osgi.bundle.fwmetamodel.command.io.matching.type.MetaEntityMatcher;
import org.tc.osgi.bundle.fwmetamodel.command.io.matching.type.MetaModelMatcher;
import org.tc.osgi.bundle.fwmetamodel.command.io.matching.type.MetaRelationMatcher;

public class LoadMetaModel extends AbstractCommand {

	private final String path;

	public LoadMetaModel(final String name, final String path) throws ClassNotFoundException {
		super(name);
		this.path = path;

	}

	@Override
	public void exec() {
		BufferedReader is;
		try {
			is = new BufferedReader(new FileReader(this.path));
			String line;
			final StringBuffer page = new StringBuffer();
			while ((line = is.readLine()) != null) {
				page.append(line);
			}

			// mettre ici le code permettant le matching
			new MetaModelMatcher(page.toString());
			new MetaRelationMatcher(page.toString());
			new MetaEntityMatcher(page.toString());
			new MetaAttributeMatcher(page.toString());

			// mettre ici le code pour faire les liens entre les elements du meta
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
