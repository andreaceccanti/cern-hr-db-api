package it.infn.mw.cern.hr.api;


import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
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

import it.infn.mw.cern.hr.api.experiments.ExperimentController;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
@WithMockUser(roles="API")
public class ExperimentApiTest {

  @Autowired
  private MockMvc mvc;
  
  
  @WithAnonymousUser
  public void accessRequiresApiRole() throws Exception {
    mvc.perform(get(ExperimentController.RESOURCE))
    .andExpect(status().isForbidden());
  }
  
  @Test
  public void getExperimentWorks() throws Exception {
    mvc.perform(get(ExperimentController.RESOURCE))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.totalResults", is(5)))
      .andExpect(jsonPath("$.itemsPerPage", is(100)))
      .andExpect(jsonPath("$.startIndex", is(0)));
  }

  @Test
  public void findExperimentByNameWorks() throws Exception {
    mvc.perform(get(ExperimentController.RESOURCE + "/cms"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.name", is("CMS")));

    mvc.perform(get(ExperimentController.RESOURCE + "/Atlas"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.name", is("ATLAS")));

    mvc.perform(get(ExperimentController.RESOURCE + "/SILVIOBELLUSCONA"))
      .andExpect(status().isNotFound())
      .andExpect(jsonPath("$.error", is("NOT_FOUND")))
      .andExpect(jsonPath("$.errorMessage", Matchers.containsString("SILVIOBELLUSCONA")));
  }

}
