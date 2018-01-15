/*
 * Created on 27 janv. 2005
 *
 * TODO To change the template for this generated file go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
package org.tc.osgi.bundle.fwmetamodel.command.io.matching.type;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.tc.osgi.bundle.fwmetamodel.command.core.type.CreateMetaAttribute;
import org.tc.osgi.bundle.fwmetamodel.command.io.matching.Matching;

/**
 * @author thomas
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class MetaAttributeMatcher extends Matching {

    static Pattern firstPrefix = Pattern.compile(".*name='");
    static Pattern model = Pattern.compile("(MetaAttribute)\\s*(name=')([^<]*)");
    static Pattern secondPrefix = Pattern.compile("'>.*");
    static Pattern valuePattern = Pattern.compile("'>");

    public MetaAttributeMatcher(final String page) {
        final Matcher matcher = MetaAttributeMatcher.model.matcher(page);
        found(matcher);
    }

    @Override
    protected void found(final Matcher matcher) {
        final ArrayList listOfType = new ArrayList();
        while (matcher.find()) {
            final String group = matcher.group();
            if (!mustBeDiscard(group, MetaAttributeMatcher.firstPrefix.matcher(group))) {
                final String tmp = removePrefix(group, MetaAttributeMatcher.firstPrefix.matcher(group));
                final String type = removePrefix(tmp, MetaAttributeMatcher.secondPrefix.matcher(tmp));
                final Matcher matcherValue = MetaAttributeMatcher.secondPrefix.matcher(tmp);
                while (matcherValue.find()) {
                    final String value = matcherValue.group();
                    if (!mustBeDiscard(value, MetaAttributeMatcher.valuePattern.matcher(value))) {
                        try {
                            final Iterator it = listOfType.iterator();
                            while (it.hasNext()) {
                                if (it.next().toString().equals(type)) {
                                    throw new Exception();
                                }
                            }
                            new CreateMetaAttribute(type, removePrefix(value, MetaAttributeMatcher.valuePattern.matcher(value)));
                        } catch (final Exception e) {}
                    }
                }
                listOfType.add(type);

            }

        }
    }
}
