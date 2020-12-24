//package com.notloki.bondMonitoring;
//
//import android.content.Context;
//
//import androidx.room.Room;
//
//import java.util.Collection;
//
//import static com.notloki.bondMonitoring.MainActivity.db;
//
//public final class BondDatabaseUtils {
//
//
//    public static BondDatabase getDatabase(Context context) {
//
//        return Room.databaseBuilder(context, BondDatabase.class, "bond-database").build();
//    }
//
//    public static void saveStuff(History history) {
//
//        db.bondDAO().insertAll(history);
//
//    }
//    public static Collection<History> load10() {
//
//    return db.bondDAO().loadLast10();
//    }
//}
//
