/*
 * Created on 27 janv. 2005
 *
 * TODO To change the template for this generated file go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
package org.tc.osgi.bundle.fwmetamodel.command.io.matching.type;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.tc.osgi.bundle.fwmetamodel.command.core.type.CreateMetaRelation;
import org.tc.osgi.bundle.fwmetamodel.command.io.matching.Matching;

/**
 * @author thomas
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class MetaRelationMatcher extends Matching {

    static Pattern extPattern = Pattern.compile(".*name='");
    static Pattern model = Pattern.compile("(MetaRelation)\\s*(name=')([^']*)");

    public MetaRelationMatcher(final String page) {
        final Matcher matcher = MetaRelationMatcher.model.matcher(page);
        found(matcher);
    }

    @Override
    protected void found(final Matcher matcher) {
        while (matcher.find()) {
            final String group = matcher.group();
            if (!mustBeDiscard(group, MetaRelationMatcher.extPattern.matcher(group))) {
                new CreateMetaRelation(removePrefix(group, MetaRelationMatcher.extPattern.matcher(group)));
            }
        }
    }

}
