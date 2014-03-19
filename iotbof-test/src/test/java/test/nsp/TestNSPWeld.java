package test.nsp;
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

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.annotation.Resource;

/**
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
@RunWith(Arquillian.class)
public class TestNSPWeld {
   @Deployment
   public static JavaArchive createDeployment() {
      return ShrinkWrap.create(JavaArchive.class)
         .addClass(TestINSP.class)
         .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
   }

   @Resource(lookup = "java:global/NSPDomain")
   private String domain;

   @Resource(lookup = "java:global/NSPDomain")
   public void setDomain(String domain) {
      this.domain = domain;
   }
   @Test
   public void queryNSP() throws Exception {
      System.out.printf("domain=%s\n", domain);
   }
}
