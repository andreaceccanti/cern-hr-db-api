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
package it.infn.mw.cern.hr.api.error;

import static it.infn.mw.cern.hr.api.dto.ErrorDTO.newError;

import java.time.format.DateTimeParseException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import it.infn.mw.cern.hr.api.dto.ErrorDTO;

@RestControllerAdvice
public class ApiExceptionHandler {

  @ResponseStatus(code=HttpStatus.NOT_FOUND)
  @ExceptionHandler(NotFoundError.class)
  public ErrorDTO handleNotFoundError(NotFoundError e) {
    return newError(HttpStatus.NOT_FOUND.name(), e.getMessage());
  }
  
  @ResponseStatus(code=HttpStatus.BAD_REQUEST)
  @ExceptionHandler(DateTimeParseException.class)
  public ErrorDTO handleDateTimeParseException(DateTimeParseException e) {
    return newError(HttpStatus.BAD_REQUEST.name(), e.getMessage());
  }

}
