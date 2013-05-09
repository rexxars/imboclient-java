/**
 * This file is part of the imboclient-java package
 *
 * (c) Espen Hovlandsdal <espen@hovlandsdal.com>
 *
 * For the full copyright and license information, please view the LICENSE file that was
 * distributed with this source code.
 */
package org.imboproject.javaclient.Url;

/**
 * Status URL
 *
 * @author Espen Hovlandsdal <espen@hovlandsdal.com>
 */
public class StatusUrl extends Url implements UrlInterface {

    /**
     * {@inheritDoc}
     */
    public StatusUrl(String baseUrl) {
        super(baseUrl, null, null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getResourceUrl() {
        return baseUrl + "/status.json";
    }

}