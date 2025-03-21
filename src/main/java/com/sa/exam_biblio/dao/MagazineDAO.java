package com.sa.exam_biblio.dao;

import com.sa.exam_biblio.model.Magazine;
import java.util.List;

public interface MagazineDAO {
    void addMagazine(Magazine magazine);
    List<Magazine> getAllMagazines();
    Magazine getMagazineById(Long magazineId);
}
