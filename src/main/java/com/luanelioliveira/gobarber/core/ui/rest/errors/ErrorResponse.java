package com.luanelioliveira.gobarber.core.ui.rest.errors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName = "of")
public class ErrorResponse {
  private String title;
  private String detail;

  @JsonInclude(Include.NON_NULL)
  private List<InvalidParam> invalidParams;

  public static ErrorResponse of(String title, String detail) {
    return ErrorResponse.of(title, detail, null);
  }
}
