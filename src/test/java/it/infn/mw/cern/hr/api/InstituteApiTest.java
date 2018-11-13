package it.infn.mw.cern.hr.api;

import static org.hamcrest.CoreMatchers.is;
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

import it.infn.mw.cern.hr.api.institutes.InstituteController;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
@WithMockUser(roles="API")
public class InstituteApiTest {

  @Autowired
  private MockMvc mvc;
  
  @WithAnonymousUser
  @Test
  public void apiAccessRequiresApiRole() throws Exception{
    mvc.perform(get(InstituteController.RESOURCE))
    .andExpect(status().isUnauthorized());
  }
  
  @Test
  public void getInstitutesWorks() throws Exception {
    mvc.perform(get(InstituteController.RESOURCE))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.totalResults", is(1000)))
      .andExpect(jsonPath("$.itemsPerPage", is(100)))
      .andExpect(jsonPath("$.startIndex", is(0)));
  }

}
