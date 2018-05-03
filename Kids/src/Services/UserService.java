/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author annab
 */
public class UserService 
{
    private void CallWebService()
    {
        ConnectionRequest post = new ConnectionRequest()
        {
            @Override
            protected void buildRequestBody(OutputStream os) throws IOException {
                //os.write(json.toString().getBytes("UTF-8"));
            }

            @Override
            protected void readResponse(InputStream input) throws IOException 
            {
                // parse response data
            }   
        };
        post.setUrl("http://localhost:8093/halimatbank/cbs/staff");
        post.setPost(true);
        post.setContentType("application/json");
    }
}
