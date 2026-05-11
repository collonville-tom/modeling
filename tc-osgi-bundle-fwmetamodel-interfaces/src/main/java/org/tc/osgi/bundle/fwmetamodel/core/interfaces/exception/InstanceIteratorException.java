package org.tc.osgi.bundle.fwmetamodel.core.interfaces.exception;

/**
 * InstanceIteratorException.java.
 * @author thomas collonvillé
 * @version 0.0.1
 */
public class InstanceIteratorException extends Exception {

    /**
     * long serialVersionUID.
     */
    private static final long serialVersionUID = -956244872965433371L;

    /**
     * InstanceIteratorException constructor.
     * @param msg String
     */
    public InstanceIteratorException(final String msg) {
        super(msg);
    }

    /**
     * InstanceIteratorException constructor.
     * @param msg String
     * @param cause Throwable
     */
    public InstanceIteratorException(final String msg, final Throwable cause) {
        super(msg, cause);
    }

}
