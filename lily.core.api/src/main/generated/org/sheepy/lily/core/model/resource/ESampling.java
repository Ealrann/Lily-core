package org.sheepy.lily.core.model.resource;

public enum ESampling {
  Linear(0),
  Nearest(1);

  private final int value;

  ESampling(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
