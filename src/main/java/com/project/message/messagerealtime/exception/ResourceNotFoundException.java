package com.project.message.messagerealtime.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException {

    private String resourceName;
    private String fieldName;
    private String fieldValueString;
    private Integer fieldValueInteger;

    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValueString, Integer fieldValueInteger) {
        super(String.format("%s not found with %s: %s, %d", resourceName, fieldName, fieldValueString, fieldValueInteger));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValueString = fieldValueString;
        this.fieldValueInteger = fieldValueInteger;
    }

    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValueString) {
        super(String.format("%s not found with %s: %s", resourceName, fieldName, fieldValueString));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValueString = fieldValueString;
    }

    public ResourceNotFoundException(String resourceName, String fieldName, Integer fieldValueInteger) {
        super(String.format("%s not found with %s: %d", resourceName, fieldName, fieldValueInteger));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValueInteger = fieldValueInteger;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldValueString() {
        return fieldValueString;
    }

    public void setFieldValueString(String fieldValueString) {
        this.fieldValueString = fieldValueString;
    }

    public Integer getFieldValueInteger() {
        return fieldValueInteger;
    }

    public void setFieldValueInteger(Integer fieldValueInteger) {
        this.fieldValueInteger = fieldValueInteger;
    }
}
