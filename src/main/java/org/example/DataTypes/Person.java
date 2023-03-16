package org.example.DataTypes;

import lombok.*;

/**
 * Class of characteristic of people
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(includeFieldNames = true)

public class Person {
    /**
     * Person name
     */
    private String name; //Поле не может быть null, Строка не может быть пустой
    /**
     * Person's pasport ID
     */
    private String passportID; //Строка не может быть пустой, Длина строки должна быть не меньше 6, Поле не может быть null
    /**
     * {@link Color} Peron's hair color
     */
    private Color hairColor; //Поле не может быть null
    /**
     * {@link Country} Person Nationality
     */
    private Country nationality; //Поле может быть null
    /**
     * {@link Location} Person Location
     */
    private Location location; //Поле не может быть null
}
