/*
 * Created on 18 f�vr. 2005
 *
 * TODO To change the template for this generated file go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
package org.tc.osgi.bundle.fwmetamodel.command.io.matching.configuration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.tc.osgi.bundle.fwmetamodel.command.io.matching.Matching;

/**
 * @author thomas
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ConfigMatching extends Matching {

    static Pattern closing = Pattern.compile("Unrecognized closing tag:([.]*)", Pattern.CASE_INSENSITIVE);
    static Pattern namePat = Pattern.compile("name='([^']*)", Pattern.CASE_INSENSITIVE);
    static Pattern opening = Pattern.compile("Unrecognized opening tag:([.]*)", Pattern.CASE_INSENSITIVE);
    static Pattern suppclosing = Pattern.compile("Unrecognized closing tag:", Pattern.CASE_INSENSITIVE);

    static Pattern suppnamePat = Pattern.compile("name='", Pattern.CASE_INSENSITIVE);
    static Pattern suppopening = Pattern.compile("Unrecognized opening tag:", Pattern.CASE_INSENSITIVE);

    private String name;
    private String tag;

    public ConfigMatching(final String page) {
        System.out.println(page);
        final Matcher matcher = ConfigMatching.opening.matcher(page);
        if (matcher.find()) {
            System.out.println(ConfigMatching.suppopening.matcher(page).replaceAll(""));
            /*
             * matcher=opening.matcher(page).group(); if (matcher.find()) {
             * System.out.println(suppTagPat.matcher(page).replaceAll(""));
             *
             * System.out.println(page); }
             */
            // beaucoup trop dur ..... de charger un fichier xml en tenant
            // compte des imbrications entre noeuds et enfants.

        }
    }

    @Override
    protected void found(final Matcher matcher) {
    }

    public String getName() {
        return name;
    }

    public String getTag() {
        return tag;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setTag(final String tag) {
        this.tag = tag;
    }

}
