package org.sheepy.lily.core.model.types;

public enum ETimeUnit {
  NANOSECONDS(0),
  MICROSECONDS(1),
  MILLISECONDS(2),
  SECONDS(3),
  MINUTES(4),
  HOURS(5),
  DAYS(6);

  private final int value;

  ETimeUnit(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
