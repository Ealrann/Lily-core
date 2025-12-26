package org.sheepy.lily.core.model.types;

public enum EKeyState {
  RELEASED(0),
  PRESSED(1),
  REPEATED(2);

  private final int value;

  EKeyState(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
