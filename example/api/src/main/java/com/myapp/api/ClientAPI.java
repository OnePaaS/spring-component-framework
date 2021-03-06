/**
 * @author XiongJie, Date: 13-11-27
 */

package com.myapp.api;

/**
 * The Client API
 * <p/>
 * called by server by RMI
 */
public interface ClientAPI {
    /**
     * A service export to server to be assigned with some job
     *
     * @param job the job to be performed
     * @return the job result
     */
    Object perform(String job);
}
