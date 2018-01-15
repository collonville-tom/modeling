package org.tc.osgi.bundle.fwmetamodel.command.io.matching.type;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.tc.osgi.bundle.fwmetamodel.command.core.type.CreateMetaModel;
import org.tc.osgi.bundle.fwmetamodel.command.io.matching.Matching;

;
/**
 * @author thomas
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class MetaModelMatcher extends Matching {

    static Pattern extPattern = Pattern.compile(".*name='");
    static Pattern model = Pattern.compile("(MetaModel)\\s*(name=')([^']*)");

    public MetaModelMatcher(final String page) {
        final Matcher matcher = MetaModelMatcher.model.matcher(page);
        found(matcher);
    }

    @Override
    protected void found(final Matcher matcher) {
        while (matcher.find()) {
            final String group = matcher.group();
            if (!mustBeDiscard(group, MetaModelMatcher.extPattern.matcher(group))) {
                new CreateMetaModel(removePrefix(group, MetaModelMatcher.extPattern.matcher(group)));
            }
        }
    }

}
