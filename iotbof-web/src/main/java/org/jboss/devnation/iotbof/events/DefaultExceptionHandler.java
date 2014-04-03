package org.jboss.devnation.iotbof.events;/*
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

import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.core.Response;

/**
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
public class DefaultExceptionHandler implements ExceptionMapper<Exception> {


    @Override
    public Response toResponse(Exception e) {
        // For simplicity I am preparing error xml by hand.
        // Ideally we should create an ErrorResponse class to hold the error info.
        StringBuilder response = new StringBuilder("<response>");
        response.append("<status>ERROR</status>");
        response.append("<message>" + e.getMessage() + "</message>");
        response.append("</response>");
        return Response.serverError().entity(response.toString()).type(MediaType.APPLICATION_XML).build();
    }
}