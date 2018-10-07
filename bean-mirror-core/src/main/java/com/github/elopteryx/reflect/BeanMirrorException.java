package com.github.elopteryx.reflect;

/**
 * Custom RuntimeException class, to wrap the exceptions
 * caused by the invalid invocations.
 */
public class BeanMirrorException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4680935199297647906L;

	/**
     * Default constructor.
     * @param cause The wrapped error
     */
    public BeanMirrorException(final Throwable cause) {
        super(cause);
    }

}
