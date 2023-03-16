package org.example.DataTypes;

import lombok.*;

/**
 * Location of musicBand's
 */
@ToString(includeFieldNames = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Location {
    /**
     * X coordinate
     */
    private int x;
    /**
     * Y coordinate
     */
    private Float y; //Поле не может быть null
    /**
     * Z coordinate
     */
    private long z;
    /**
     * Name of location
     */
    private String name; //Поле может быть null
}
