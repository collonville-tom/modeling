/*
 * Created on 27 janv. 2005
 *
 * TODO To change the template for this generated file go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
package org.tc.osgi.bundle.fwmetamodel.command.io.matching;

import java.util.regex.Matcher;

/**
 * @author thomas
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public abstract class Matching {

    protected abstract void found(Matcher matcher);

    protected boolean mustBeDiscard(final String group, final Matcher matcher) {
        final Matcher groupMatcher = matcher;
        return groupMatcher.matches();
    }

    protected String removePrefix(final String group, final Matcher matcher) {
        final Matcher prefixMatcher = matcher;
        return prefixMatcher.replaceAll("");
    }

}
