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

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.InputStream;
import java.util.HashMap;

/**
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
public class ParseResourceIDs {
   enum Columns {
      ResourceName,
      ResourceID,
      AccessType,
      Type,
      Range,
      Units,
      Descriptions
   }

   public static void main(String[] args) throws Exception {
      InputStream is = ParseResourceIDs.class.getResourceAsStream("/resourceids.html");
      Document doc = Jsoup.parse(is, "UTF-8", "/");
      Elements trs = doc.getElementsByTag("TR");
      System.out.printf("Found %s TRs\n", trs.size());

      HashMap<Integer, String> idToName = new HashMap<>();
      for(Element tr : trs) {
         Elements tds = tr.getElementsByTag("TD");
         String name = null;
         int id = 0;
         String accessType = null;
         String type = null;
         String range = null;
         String units = null;
         String description = null;
         for(int col = 0; col <= Columns.Descriptions.ordinal(); col ++) {
            Element td = tds.get(col);
            String text = getText(td);
            Columns colID = Columns.values()[col];
            switch (colID) {
               case ResourceName:
                  name = text.replace(" ", "");
                  break;
               case ResourceID:
                  id = Integer.parseInt(text);
                  break;
               case AccessType:
                  accessType = text.replace(" ", "");
                  break;
               case Type:
                  type = text;
                  break;
               case Range:
                  range = text;
                  break;
               case Units:
                  units = text;
                  break;
               case Descriptions:
                  description = text;
                  break;
            }
         }
         idToName.put(id, name);
         // Output a ResourceID enum declaration
         System.out.printf("\t%s(%s,\"%s\",\"%s\",\"%s\",\"%s\",\"%s\"),\n", name, id, accessType, type, range, units, description);
      }

      // Generate an id to ResourceID function
      System.out.printf("\tpublic static ResourceID valueOf(int id) {\n");
      System.out.printf("\t\tResourceID resID = null;\n");
      System.out.printf("\t\tswitch(id) {\n");
      for(int id : idToName.keySet()) {
         System.out.printf("\t\t\tcase %d:\n", id);
         System.out.printf("\t\t\t\tresID = ResourceID.%s;\n", idToName.get(id));
         System.out.printf("\t\t\tbreak;\n");
      }
      System.out.printf("\t\t}\n\t};\n");
   }

   static String getText(Element element) {
      StringBuilder text = new StringBuilder();
      Elements children = element.children();
      for (Element e : children) {
         text.append(e.text());
      }
      return text.toString();
   }
}
