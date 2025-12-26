package org.sheepy.lily.core.model.types;

public enum ERelative {
  HORIZONTAL(0),
  VERTICAL(1);

  private final int value;

  ERelative(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
