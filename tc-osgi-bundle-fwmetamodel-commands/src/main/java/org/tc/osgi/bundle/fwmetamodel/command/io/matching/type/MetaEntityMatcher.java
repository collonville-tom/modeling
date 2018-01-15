/*
 * Created on 27 janv. 2005
 *
 * TODO To change the template for this generated file go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
package org.tc.osgi.bundle.fwmetamodel.command.io.matching.type;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.tc.osgi.bundle.fwmetamodel.command.core.type.CreateMetaEntity;
import org.tc.osgi.bundle.fwmetamodel.command.io.matching.Matching;

/**
 * @author thomas
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class MetaEntityMatcher extends Matching {

    static Pattern extPattern = Pattern.compile(".*name='");
    static Pattern model = Pattern.compile("(MetaEntity)\\s*(name=')([^']*)");

    public MetaEntityMatcher(final String page) {
        final Matcher matcher = MetaEntityMatcher.model.matcher(page);
        found(matcher);
    }

    @Override
    protected void found(final Matcher matcher) {
        while (matcher.find()) {
            final String group = matcher.group();
            if (!mustBeDiscard(group, MetaEntityMatcher.extPattern.matcher(group))) {
                new CreateMetaEntity(removePrefix(group, MetaEntityMatcher.extPattern.matcher(group)));
            }
        }
    }

}
