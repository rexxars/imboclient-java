/**
 * This file is part of the imboclient-java package
 *
 * (c) Espen Hovlandsdal <espen@hovlandsdal.com>
 *
 * For the full copyright and license information, please view the LICENSE file that was
 * distributed with this source code.
 */
package org.imboproject.javaclient.Images;

import java.util.Date;
import java.util.HashMap;

import org.json.JSONObject;

/**
 * Query class for the images resource
 *
 * @author Espen Hovlandsdal <espen@hovlandsdal.com>
 */
public class Query implements QueryInterface {

    /**
     * The page to get
     */
    private int page = 1;

    /**
     * The maximum number of images to get
     */
    private int limit = 20;

    /**
     * Whether to return meta data for the images or not
     */
    private boolean returnMetadata = false;

    /**
     * Meta data query
     */
    private JSONObject metadataQuery = null;

    /**
     * Date to start fetching from
     */
    private Date from;

    /**
     * Date to stop fetching at
     */
    private Date to;

    /**
     * {@inheritDoc}
     */
    public int page() {
        return page;
    }

    /**
     * {@inheritDoc}
     */
    public QueryInterface page(int pageNum) {
        this.page = pageNum;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    public int limit() {
        return limit;
    }

    /**
     * {@inheritDoc}
     */
    public QueryInterface limit(int limit) {
        this.limit = limit;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    public boolean returnMetadata() {
        return returnMetadata;
    }

    /**
     * {@inheritDoc}
     */
    public QueryInterface returnMetadata(boolean returnMetadata) {
        this.returnMetadata = returnMetadata;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    public JSONObject metadataQuery() {
        return metadataQuery;
    }

    /**
     * {@inheritDoc}
     */
    public QueryInterface metadataQuery(JSONObject metadataQuery) {
        this.metadataQuery = metadataQuery;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    public Date from() {
        return from;
    }

    /**
     * {@inheritDoc}
     */
    public QueryInterface from(Date from) {
        this.from = from;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    public Date to() {
        return to;
    }

    /**
     * {@inheritDoc}
     */
    public QueryInterface to(Date to) {
        this.to = to;
        return this;
    }
    
    /**
     * {@inheritDoc}
     */
    public HashMap<String, String> toHashMap() {
    	HashMap<String, String> params = new HashMap<String, String>();
    	
    	if (this.page() > 0) {
    		params.put("page", Integer.toString(this.page()));
    	}
    	
    	if (this.limit() > 0) {
    		params.put("limit", Integer.toString(this.limit()));
    	}
    	
    	if (this.returnMetadata()) {
    		params.put("metadata", "1");
    	}
    	
    	if (this.from() != null) {
    		params.put("from", Long.toString(this.from().getTime()));
    	}
    	
    	if (this.to() != null) {
    		params.put("to", Long.toString(this.to().getTime()));
    	}
    	
    	if (this.metadataQuery() != null) {
    		params.put("query", this.metadataQuery().toString());
    	}
    	
    	return params;
    }

}