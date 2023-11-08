package org.jeferson.reciclaje_botellas.exception;

import java.text.MessageFormat;

// Esta es una checked exception
public class RecyclerCustomerNotCountException extends Exception {

  public RecyclerCustomerNotCountException(int initialAge, int finalAge) {
    super(
        MessageFormat.format(
            "The initial age: {0} or final age {1} is not valid ", initialAge, finalAge));
  }
}
