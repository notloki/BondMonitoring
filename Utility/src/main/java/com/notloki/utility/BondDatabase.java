//package com.notloki.bondMonitoring;
//
//import android.content.Context;
//
//import androidx.room.Database;
//import androidx.room.Room;
//import androidx.room.RoomDatabase;
//import androidx.room.TypeConverters;
//
//@Database(entities = {History.class}, version = 1)
//@TypeConverters({Converters.class})
//public abstract class BondDatabase extends RoomDatabase {
//    public abstract BondDAO bondDAO();
//
//    private BondDatabase instance = null;
//
//}
//
//
////    public BondDatabase getInstance(Context context) {
////        if(instance == null) {
////
////                synchronized(BondDatabase.class) {
////                    instance = Room.databaseBuilder(
////                            context.getApplicationContext(),
////                            BondDatabase.class, "bond_database"
////                )
////                    .fallbackToDestructiveMigration()
////                            .addCallback(roomCallback)
////                            .build();
////                }
////            }
////            return instance;
////    } }
//
//
