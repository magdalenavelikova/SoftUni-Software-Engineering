package bg.softuni.webclient.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

  @JsonProperty("data")
  private DataDTO data;
  @JsonProperty("support")
  private SupportDTO support;

  @JsonProperty("data")
  public DataDTO getData() {
    return data;
  }

  @JsonProperty("data")
  public void setData(DataDTO data) {
    this.data = data;
  }

  @JsonProperty("support")
  public SupportDTO getSupport() {
    return support;
  }

  @JsonProperty("support")
  public void setSupport(SupportDTO support) {
    this.support = support;
  }

  @Override
  public String toString() {
    return "User{" +
        "data=" + data +
        ", support=" + support +
        '}';
  }
}