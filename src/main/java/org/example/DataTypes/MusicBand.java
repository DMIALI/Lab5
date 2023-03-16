package org.example.DataTypes;

import lombok.*;
import org.example.Commands.CommandData.InputCommandData;
import org.jetbrains.annotations.NotNull;

/**
 * Class that keep information about music group
 */
@Getter
@Setter
@AllArgsConstructor
@ToString(includeFieldNames = true)
@NoArgsConstructor


public class MusicBand implements Comparable<MusicBand>{
    /**
     * MusicBand's id
     */
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    /**
     * MusicBand's name
     */
    private String name; //Поле не может быть null, Строка не может быть пустой
    /**
     * {@link Coordinates} MusicBand's coordinates
     */
    private Coordinates coordinates; //Поле не может быть null
    /**
     * Date of creation MusicBand
     */
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    /**
     * Number of Participants in Music Band
     */
    private long numberOfParticipants; //Значение поля должно быть больше 0
    /**
     * Number of albums in Music Band
     */
    private long albumsCount; //Значение поля должно быть больше 0
    /**
     * {@link MusicGenre} Genre of MusicBand
     */
    private MusicGenre genre; //Поле не может быть null
    /**
     * {@link Person} Front man in MusicBand's
     */
    private Person frontMan; //Поле может быть null

    @Override
    public int compareTo(MusicBand musicBand) {
        return (int) (this.getId() - musicBand.getId());
    }
}
