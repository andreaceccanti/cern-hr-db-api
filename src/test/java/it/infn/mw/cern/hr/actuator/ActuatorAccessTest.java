package it.infn.mw.cern.hr.actuator;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ActuatorAccessTest {

  @Autowired
  private MockMvc mvc;

  @WithAnonymousUser
  @Test
  public void infoAndHealthEndpointHasAnonymousAccess() throws Exception {
    mvc.perform(get("/actuator/info")).andExpect(status().isOk());
    mvc.perform(get("/actuator/health")).andExpect(status().isOk());
  }
  
  @WithAnonymousUser
  @Test
  public void metricsEndpointRequiresAuthenticatedAccess() throws Exception {
    mvc.perform(get("/actuator/metrics")).andExpect(status().isUnauthorized());
    mvc.perform(get("/actuator/prometheus")).andExpect(status().isUnauthorized());
  }
  
  @WithMockUser(roles="API")
  @Test
  public void metricsEndpointRequireMetricsRole() throws Exception {
    mvc.perform(get("/actuator/metrics")).andExpect(status().isForbidden());
    mvc.perform(get("/actuator/prometheus")).andExpect(status().isForbidden());
  }
  
  @WithMockUser(roles="METRICS")
  @Test
  public void metricsEndpointRequireMetricsRoleSuccess() throws Exception {
    mvc.perform(get("/actuator/metrics")).andExpect(status().isOk());
    mvc.perform(get("/actuator/prometheus")).andExpect(status().isOk());
  }

}
