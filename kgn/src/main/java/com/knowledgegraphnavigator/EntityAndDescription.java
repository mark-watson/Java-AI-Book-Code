package com.knowledgegraphnavigator;

public class EntityAndDescription {
  public String entityName;
  public String entityUri;
  public EntityAndDescription(String entityName, String entityUri) {
    this.entityName = entityName;
    this.entityUri = entityUri;
  }
  public String toString() {
    return "[EntityAndDescription name: " + entityName +
        " description: " + entityUri + "]";
  }
}
