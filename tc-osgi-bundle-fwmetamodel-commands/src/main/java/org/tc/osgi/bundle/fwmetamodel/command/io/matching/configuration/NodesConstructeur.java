/*
 * Created on 18 f�vr. 2005
 *
 * TODO To change the template for this generated file go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
package org.tc.osgi.bundle.fwmetamodel.command.io.matching.configuration;

import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author thomas
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class NodesConstructeur {

    private final ArrayList messages = new ArrayList();

    public NodesConstructeur(final String path) throws FileNotFoundException {

        final XMLDecoder d = new XMLDecoder(new BufferedInputStream(new FileInputStream(path)));

        d.setExceptionListener(new ExceptionListener() {

            @Override
            public void exceptionThrown(final Exception arg0) {
                messages.add(arg0.getMessage());

            }

        });
        try {
            d.readObject();
        } catch (final Exception e) {}
        d.close();

        final Iterator it = messages.iterator();
        while (it.hasNext()) {
            final ConfigMatching match = new ConfigMatching((String) it.next());
        }
    }

}
