package salesman.negotiation.infrastructure.libraries;

import com.google.common.collect.Sets;

import java.util.Set;

public class ValidationException extends RuntimeException{

  /**
   * 
   */
  private static final long serialVersionUID = -9125619432657328867L;

  private Set<String> errors = Sets.newHashSet();

  public ValidationException(Set<String> errors) {
    this.errors = errors;
  }

  public Set<String> getErrors() {
    return errors;
  }
}
