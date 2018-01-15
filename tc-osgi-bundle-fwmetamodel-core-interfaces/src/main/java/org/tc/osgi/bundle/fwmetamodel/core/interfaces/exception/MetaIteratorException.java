package org.tc.osgi.bundle.fwmetamodel.core.interfaces.exception;

/**
 * MetaIteratorException.java.
 * @author thomas collonvillé
 * @version 0.0.1
 */
public class MetaIteratorException extends Exception {

    /**
     * long serialVersionUID.
     */
    private static final long serialVersionUID = -706997803886258544L;

    /**
     * MetaIteratorException constructor.
     * @param msg String
     */
    public MetaIteratorException(final String msg) {
        super(msg);
    }

    /**
     * MetaIteratorException constructor.
     * @param msg String
     * @param cause Throwable
     */
    public MetaIteratorException(final String msg, final Throwable cause) {
        super(msg, cause);
    }

}