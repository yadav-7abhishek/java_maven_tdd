package org.agileguru.baby.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Baby implements Serializable {
    private static final long serialVersionUID = -7831474383352606226L;
    
    private String firstName;
    private String lastName; 
}
