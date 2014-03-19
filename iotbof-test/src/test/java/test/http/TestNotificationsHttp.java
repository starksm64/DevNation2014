package test.http;
/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;

public class TestNotificationsHttp {
   static final int PORT = 9091;
   public static void main(String[] args) throws IOException {
      InetSocketAddress addr = new InetSocketAddress(PORT);
      HttpServer server = HttpServer.create(addr, 0);

      server.createContext("/", new MyHandler());
      server.setExecutor(Executors.newCachedThreadPool());
      server.start();
      System.out.printf("Server is listening on port %d\n", PORT);
   }
}

class MyHandler implements HttpHandler {
   public void handle(HttpExchange exchange) throws IOException {
      String requestMethod = exchange.getRequestMethod();
      URI requestURI = exchange.getRequestURI();
      System.out.printf("+++ Request(%s): %s; from: %s\n", requestMethod, requestURI, exchange.getRemoteAddress());
      Headers responseHeaders = exchange.getResponseHeaders();
      if (requestMethod.equalsIgnoreCase("PUT")) {
         responseHeaders.set("Content-Type", "text/plain");
         exchange.sendResponseHeaders(200, 0);

         OutputStream responseBody = exchange.getResponseBody();
         Headers requestHeaders = exchange.getRequestHeaders();
         Set<String> keySet = requestHeaders.keySet();
         Iterator<String> iter = keySet.iterator();
         while (iter.hasNext()) {
            String key = iter.next();
            List values = requestHeaders.get(key);
            String s = key + " = " + values.toString() + "\n";
            responseBody.write(s.getBytes());
            System.out.printf("%s\n", s);
         }

         System.out.printf("---Begin Body(%s):\n", responseHeaders.get("Content-length"));
         InputStream is = exchange.getRequestBody();
         int b = is.read();
         while(b >= 0) {
            System.out.write(b);
            b = is.read();
         }
         responseBody.close();
         System.out.printf("\n---End Body:\n");
      } else {
         System.out.printf("Unsupported request type: %s\n", requestMethod);
         exchange.sendResponseHeaders(400, 0);
      }
   }
}
