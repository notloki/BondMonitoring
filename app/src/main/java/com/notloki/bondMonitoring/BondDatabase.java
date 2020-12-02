package com.notloki.bondMonitoring;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {History.class}, version = 1)
public abstract class BondDatabase extends RoomDatabase {
    public abstract  BondDAO bondDAO();
}
