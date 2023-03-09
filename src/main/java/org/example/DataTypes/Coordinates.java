package org.example.DataTypes;

import lombok.*;

@ToString(includeFieldNames = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Coordinates {
    private Long x; //Значение поля должно быть больше -645, Поле не может быть null
    private double y;
}
