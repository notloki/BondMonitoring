package com.notloki.bondMonitoring;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;


import java.sql.Date;
import java.util.List;


@Dao
public interface BondDAO {
    @Query("SELECT * FROM history")
    List<History> getAll();

    @Query("SELECT * FROM history WHERE historyIds IN (:ids)")
    List<History>loadAllByIds(int[] ids);

    @Query("SELECT * FROM history WHERE dates in (:date)")
    History findByDate(Date date);

    @Query("SELECT * FROM history WHERE transaction_key IN (:key)")
    History findByKey(String key);

    @Insert
    void insertAll(History... histories);

    @Delete
    void delete(History history);
}