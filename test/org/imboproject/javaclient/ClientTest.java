/**
 * ImboClient-java
 *
 * Copyright (c) 2012, Espen Hovlandsdal <espen@hovlandsdal.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to
 * deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or
 * sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * * The above copyright notice and this permission notice shall be included in
 *   all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 *
 * @author Espen Hovlandsdal <espen@hovlandsdal.com>
 * @copyright Copyright (c) 2012, Espen Hovlandsdal <espen@hovlandsdal.com>
 * @license http://www.opensource.org/licenses/mit-license MIT License
 * @link https://github.com/rexxars/imboclient-java
 */
package org.imboproject.javaclient;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Client test
 *
 * @author Espen Hovlandsdal <espen@hovlandsdal.com>
 */
@RunWith(JUnit4.class)
public class ClientTest extends TestCase {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private Client client;
    private String serverUrl = "http://host";
    private String publicKey = "key";
    private String privateKey = "8495c97ea3a313c12c0661dc5526e769";
    private String imageIdentifier = "23d7f91b25f3013fcc75ce070c40e004";
    private String signedUrlPattern = "/signature=.*?&timestamp=\\d{4}-\\d\\d-\\d\\dT\\d\\d%3A\\d\\d%3A\\d\\dZ$/";

    @Before
    public void setUp() {
        client = new Client(serverUrl, publicKey, privateKey);
    }

    @After
    public void tearDown() {
        client = null;
    }

    /**
     * When trying to add a local image that does not exist the client must throw an exception
     */
    @Test
    public void testThrowsExceptionWhenTryingToAddLocalImageThatDoesNotExist() throws IOException {
        exception.expect(FileNotFoundException.class);
        exception.expectMessage("The system cannot find the file specified");

        File nonExistant = new File("non-existant-file");
        client.addImage(nonExistant);
    }

    /**
     * When trying to add an empty local image the client must throw an exception
     */
    @Test
    public void testThrowsExceptionWhenTryingToAddEmptyLocalImage() throws IOException {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("The specified file was empty");

        File emptyImage = new File("misc/empty.jpg");
        client.addImage(emptyImage);
    }

    /**
     * The client must be able to add a valid local image
     */
    @Test
    public void testReturnsResponseWhenAddingValidLocalImage() {

    }

}