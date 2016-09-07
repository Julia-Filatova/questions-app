package models.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Yuliia_Filatova on 9/7/2016.
 */
@Entity
@Table(name="fields")
public class Field implements Serializable {

    @Id
    @GeneratedValue
    private Long fieldId;

    @Column
    private String name;

    @Column
    private FieldType type;

    @Column
    private boolean isActive;

    @Column
    private boolean required;

    public Long getFieldId() {
        return fieldId;
    }

    public void setFieldId(Long fieldId) {
        this.fieldId = fieldId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FieldType getType() {
        return type;
    }

    public void setType(FieldType type) {
        this.type = type;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }
}
