package org.example.DataTypes;

import lombok.*;

/**
 * Class of coordinates
 */
@ToString(includeFieldNames = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Coordinates {
    /**
     * X coordinate
     */
    private Long x; //Значение поля должно быть больше -645, Поле не может быть null
    /**
     * Y coordinate
     */
    private double y;
}
