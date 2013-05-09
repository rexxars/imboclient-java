/**
 * This file is part of the imboclient-java package
 *
 * (c) Espen Hovlandsdal <espen@hovlandsdal.com>
 *
 * For the full copyright and license information, please view the LICENSE file that was
 * distributed with this source code.
 */
package org.imboproject.javaclient;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import org.imboproject.javaclient.Http.ResponseInterface;
import org.imboproject.javaclient.Images.Image;
import org.imboproject.javaclient.Images.QueryInterface;
import org.imboproject.javaclient.Url.ImageUrl;
import org.imboproject.javaclient.Url.ImagesUrl;
import org.imboproject.javaclient.Url.MetadataUrl;
import org.imboproject.javaclient.Url.StatusUrl;
import org.imboproject.javaclient.Url.UrlInterface;
import org.imboproject.javaclient.Url.UserUrl;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Imbo client interface
 *
 * @author Espen Hovlandsdal <espen@hovlandsdal.com>
 */
public interface ClientInterface {

    /**
     * Return the current server URL's used by the client
     *
     * @return
     */
    public String[] getServerUrls();

    /**
     * Get the URL to the status resource
     *
     * @return URL to the status resource
     */
    public StatusUrl getStatusUrl();

    /**
     * Get the URL to the current user
     *
     * @return URL to the current user
     */
    public UserUrl getUserUrl();

    /**
     * Get the URL to the images resource of the current user
     *
     * @return URL to the images resource
     */
    public ImagesUrl getImagesUrl();

    /**
     * Get the URL to a specific image
     *
     * @param imageIdentifier Image identifier for the wanted image
     * @return URL to the image
     */
    public ImageUrl getImageUrl(String imageIdentifier);

    /**
     * Get the URL to the meta data of a specific image
     *
     * @param imageIdentifier Image identifier for the wanted image
     * @return URL to the meta data resource
     */
    public MetadataUrl getMetadataUrl(String imageIdentifier);

    /**
     * Add a new image to the server
     *
     * @param image File instance to add to the server
     * @return Response from the server
     * @throws IOException
     */
    public ResponseInterface addImage(File image) throws IOException;

    /**
     * Add a new image to the server
     *
     * @param bytes Byte array of data to add to the server
     * @return Response from the server
     * @throws IOException
     */
    public ResponseInterface addImage(byte[] bytes) throws IOException;

    /**
     * Add a new image to the server from a given URL
     *
     * @param url URL to the image you want to add
     * @return Response from the server
     * @throws IOException
     */
    public ResponseInterface addImageFromUrl(URI url) throws IOException;
    
    /**
     * Add a new image to the server from a given URL
     *
     * @param url URL to the image you want to add
     * @return Response from the server
     * @throws IOException
     */
    public ResponseInterface addImageFromUrl(UrlInterface url) throws IOException;

    /**
     * Checks if a given image exists on the server already by specifying a local image
     *
     * @param image Image you want to check if exists
     * @return True if image exists on server, false otherwise
     * @throws FileNotFoundException 
     * @throws IllegalArgumentException 
     * @throws IOException 
     */
    public boolean imageExists(File image) throws IllegalArgumentException, IOException;

    /**
     * Checks if a given image exists on the server already by specifying an image identifier
     *
     * @param imageIdentifier Image identifier you want to check if exists
     * @return True if image exists on server, false otherwise
     * @throws IOException 
     */
    public boolean imageExists(String imageIdentifier) throws IOException;

    /**
     * Request an image using HEAD
     *
     * @param imageIdentifier Image identifier to do the request against
     * @return Response from the server
     * @throws IOException 
     */
    public ResponseInterface headImage(String imageIdentifier) throws IOException;

    /**
     * Delete an image from the server
     *
     * @param imageIdentifier Image identifier of the image to delete
     * @return Response from the server
     * @throws IOException 
     */
    public ResponseInterface deleteImage(String imageIdentifier) throws IOException;

    /**
     * Edit image meta data
     *
     * @param imageIdentifier Image identifier to edit meta data for
     * @param metadata Actual meta data to add
     * @return Response from the server
     * @throws IOException 
     */
    public ResponseInterface editMetadata(String imageIdentifier, JSONObject metadata) throws IOException;

    /**
     * Replace all existing meta data
     *
     * @param imageIdentifier Image identifier to replace meta data for
     * @param metadata Actual meta data to add
     * @return Response from the server
     * @throws IOException 
     */
    public ResponseInterface replaceMetadata(String imageIdentifier, JSONObject metadata) throws IOException;

    /**
     * Delete meta data
     *
     * @param imageIdentifier Image identifier to delete meta data for
     * @return Response from the server
     * @throws IOException 
     */
    public ResponseInterface deleteMetadata(String imageIdentifier) throws IOException;

    /**
     * Get image meta data
     *
     * @param imageIdentifier Image identifier to get meta data for
     * @return Meta data as a JSONObject
     * @throws JSONException 
     * @throws IOException 
     */
    public JSONObject getMetadata(String imageIdentifier) throws JSONException, IOException;

    /**
     * Get the number of images currently stored on the server for the current user
     *
     * @return Number of images for the current user
     * @throws IOException 
     * @throws JSONException 
     */
    public int getNumberOfImages() throws IOException, JSONException;

    /**
     * Get an array of images currently stored on the server
     *
     * @return An array of images (can be empty)
     * @throws IOException 
     * @throws JSONException 
     */
    public org.imboproject.javaclient.Images.Image[] getImages() throws IOException, JSONException;

    /**
     * Get an array of images currently stored on the server
     *
     * @param query Query to send to the server
     * @return An array of images (can be empty)
     * @throws IOException 
     * @throws JSONException 
     */
    public org.imboproject.javaclient.Images.Image[] getImages(QueryInterface query) throws IOException, JSONException;

    /**
     * Get the binary data of an image stored on the server
     *
     * @param imageIdentifier The image identifier to get data from
     * @return Image data as byte-array
     * @throws IOException 
     */
    public byte[] getImageData(String imageIdentifier) throws IOException;

    /**
     * Get the binary data of a URL
     *
     * @param url URL to fetch binary data from
     * @return Image data as a byte-array
     * @throws IOException 
     */
    public byte[] getImageData(URI url) throws IOException;

    /**
     * Get properties of an image
     *
     * @param imageIdentifier Image identifier to get properties for
     * @return Image instance containing the properties
     * @throws IOException 
     */
    public Image getImageProperties(String imageIdentifier) throws IOException;

    /**
     * Generate an image identifier for a given file
     *
     * @param file The file to get an image identifier for
     * @throws IOException
     * @return Image identifier
     */
    public String getImageIdentifier(File file) throws IOException;

    /**
     * Generate an image identifier for a given input stream
     *
     * @param imageStream The stream to generate an image identifier for
     * @throws IOException
     * @return Image identifier
     */
    public String getImageIdentifier(InputStream imageStream) throws IOException;

    /**
     * Generate an image identifier for a given byte-array
     *
     * @param imageData The byte-array to generate an image identifier for
     * @return Image identifier
     */
    public String getImageIdentifier(byte[] imageData);

    /**
     * Get the server status
     *
     * @return Server status as a JSON object
     * @throws JSONException 
     * @throws IOException 
     */
    public JSONObject getServerStatus() throws JSONException, IOException;
    
    /**
     * Get user information
     * 
     * @return User information as a JSON object
     * @throws IOException 
     * @throws JSONException 
     */
    public JSONObject getUserInfo() throws JSONException, IOException;

    /**
     * Set the HTTP client to be used for requests
     *
     * @param client HTTP client to be used
     * @return Returns this instance of the Imbo client
     */
    public ClientInterface setHttpClient(org.imboproject.javaclient.Http.ClientInterface client);
    
    /**
     * Get the HTTP client to be used for requests
     * 
     * @return HTTP client
     */
    public org.imboproject.javaclient.Http.ClientInterface getHttpClient();

}
