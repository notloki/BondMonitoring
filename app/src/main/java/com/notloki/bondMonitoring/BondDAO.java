//package com.notloki.bondMonitoring;
//
//import androidx.room.Dao;
//import androidx.room.Delete;
//import androidx.room.Insert;
//import androidx.room.Query;
//
//
//import java.sql.Date;
//import java.util.Collection;
//import java.util.List;
//
//
//@Dao
//public interface BondDAO {
//    @Query("SELECT * FROM history")
//    List<History>getAll();
//
//    @Query("SELECT * FROM history WHERE id IN (:id)")
//    List<History>loadAllByIds(int[] id);
//
//    @Query("SELECT * FROM history WHERE date in (:date)")
//    History findByDate(String date);
//
//    @Query("SELECT * FROM history WHERE tKey IN (:tKey)")
//    History findByKey(String tKey);
//
//    @Query("SELECT * FROM history LIMIT 10")
//    Collection<History> loadLast10();
//
//    @Insert
//    void insertAll(History... histories);
//
//    @Delete
//    void delete(History history);
//}