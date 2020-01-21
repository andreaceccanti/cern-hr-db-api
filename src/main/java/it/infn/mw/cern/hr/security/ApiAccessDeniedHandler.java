/**
 * Copyright (c) Istituto Nazionale di Fisica Nucleare (INFN). 2016-2020
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
package it.infn.mw.cern.hr.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.infn.mw.cern.hr.api.dto.ErrorDTO;

public class ApiAccessDeniedHandler implements AccessDeniedHandler {

  final ObjectMapper mapper;

  public ApiAccessDeniedHandler(ObjectMapper mapper) {
    this.mapper = mapper;
  }

  @Override
  public void handle(HttpServletRequest request, HttpServletResponse response,
      AccessDeniedException accessDeniedException) throws IOException, ServletException {

    ErrorDTO dto =
        ErrorDTO.newError(HttpStatus.FORBIDDEN.name(), accessDeniedException.getMessage());
    
    response.setStatus(HttpStatus.FORBIDDEN.value());
    mapper.writeValue(response.getWriter(), dto);
  }

}
