package models.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Yuliia_Filatova on 9/7/2016.
 */
@Entity
@Table(name="fields2")
public class Field implements Serializable {

    @Id
    @GeneratedValue
    private Long fieldId;

    @Column
    private String label;

    @Column
    private FieldType typeOfField;

    @Column
    private boolean isActive;

    @Column
    private boolean requiredField;

    public Long getFieldId() {
        return fieldId;
    }

    public void setFieldId(Long fieldId) {
        this.fieldId = fieldId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String name) {
        this.label = name;
    }

    public FieldType getTypeOfField() {
        return typeOfField;
    }

    public void setTypeOfField(FieldType type) {
        this.typeOfField = type;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isRequired() {
        return requiredField;
    }

    public void setRequired(boolean required) {
        this.requiredField = required;
    }
}
