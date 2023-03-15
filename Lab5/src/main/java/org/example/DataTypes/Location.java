package org.example.DataTypes;

import lombok.*;

@ToString(includeFieldNames = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Location {
    private int x;
    private Float y; //Поле не может быть null
    private long z;
    private String name; //Поле может быть null
}
