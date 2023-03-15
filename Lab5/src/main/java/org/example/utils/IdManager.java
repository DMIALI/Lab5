package org.example.utils;

import org.example.DataTypes.MusicBand;

import java.util.Comparator;
import java.util.LinkedList;

public class IdManager {
    private LinkedList<Integer> ids = new LinkedList<>();
    private Long maxid = 0L;

    public IdManager(LinkedList<MusicBand> musicBands) {
        for (MusicBand i : musicBands) {
            Long currid = i.getId();
            if (currid > maxid) {
                maxid = currid;
            }
            ids.add(Math.toIntExact(currid));
            if (maxid.equals(Integer.MAX_VALUE)) {
                ids.sort(Comparator.naturalOrder());
            }
        }
    }

    public Long add() {
        if (!maxid.equals(Integer.MAX_VALUE)) {
            maxid += 1;
            return maxid;
        } else {
            Long counter = 0L;
            for (Integer i : ids) {
                counter++;
                if (i > counter + 1) {
                    ids.add(ids.indexOf(i), i - 1);
                    return Long.valueOf(i - 1);
                }
            }
        }
        return 0L;
    }
    public void resetToZero(){
        maxid = 0L;
        ids.clear();
    }

    public void remove(Long id) {
        ids.remove(id);
    }
}
