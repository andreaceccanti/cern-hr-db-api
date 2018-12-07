/**
 * Copyright (c) Istituto Nazionale di Fisica Nucleare (INFN). 2016-2018
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package it.infn.mw.cern.hr.api;

import static it.infn.mw.cern.hr.api.countries.CountryController.RESOURCE;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
@WithMockUser(roles="API")
public class CountryApiTest {

  @Autowired
  private MockMvc mvc;

  @WithAnonymousUser
  @Test
  public void apiAccessRequiresApiRole() throws Exception {

    mvc.perform(get(RESOURCE))
      .andExpect(status().isUnauthorized());

  }
  @Test
  public void getCountriesWorks() throws Exception {
    mvc.perform(get(RESOURCE))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.totalResults", is(210)))
      .andExpect(jsonPath("$.itemsPerPage", is(100)))
      .andExpect(jsonPath("$.startIndex", is(0)));
  }

  @Test
  public void getCountriesPaginationWorks() throws Exception {
    mvc.perform(get(RESOURCE).param("startIndex", "0").param("count", "10"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.totalResults", is(210)))
      .andExpect(jsonPath("$.itemsPerPage", is(10)))
      .andExpect(jsonPath("$.startIndex", is(0)));
  }

  @Test
  public void getCountriesByNameWorks() throws Exception {
    mvc.perform(get(RESOURCE + "/Italy"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.name", is("ITALY")));

    mvc.perform(get(RESOURCE + "/ITAly"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.name", is("ITALY")));

    mvc.perform(get(RESOURCE + "/Venusia"))
      .andExpect(status().isNotFound())
      .andExpect(jsonPath("$.error", is("NOT_FOUND")))
      .andExpect(jsonPath("$.errorMessage", containsString("Venusia")));
  }

}
