package kz.iitu.mymusic;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile FavouritesDao _favouritesDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `favourites` (`art_id` INTEGER, `art_name` TEXT NOT NULL, `art_thumbnail` TEXT NOT NULL, `art_genre` TEXT NOT NULL, `art_year` TEXT NOT NULL, PRIMARY KEY(`art_id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'daa736771126f137cc66b378d747bc9f')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `favourites`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsFavourites = new HashMap<String, TableInfo.Column>(5);
        _columnsFavourites.put("art_id", new TableInfo.Column("art_id", "INTEGER", false, 1));
        _columnsFavourites.put("art_name", new TableInfo.Column("art_name", "TEXT", true, 0));
        _columnsFavourites.put("art_thumbnail", new TableInfo.Column("art_thumbnail", "TEXT", true, 0));
        _columnsFavourites.put("art_genre", new TableInfo.Column("art_genre", "TEXT", true, 0));
        _columnsFavourites.put("art_year", new TableInfo.Column("art_year", "TEXT", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFavourites = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFavourites = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFavourites = new TableInfo("favourites", _columnsFavourites, _foreignKeysFavourites, _indicesFavourites);
        final TableInfo _existingFavourites = TableInfo.read(_db, "favourites");
        if (! _infoFavourites.equals(_existingFavourites)) {
          throw new IllegalStateException("Migration didn't properly handle favourites(kz.iitu.mymusic.Favourites).\n"
                  + " Expected:\n" + _infoFavourites + "\n"
                  + " Found:\n" + _existingFavourites);
        }
      }
    }, "daa736771126f137cc66b378d747bc9f", "b7a0f04eef5e3f470321e0fed0ab09d9");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "favourites");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `favourites`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public FavouritesDao getFavouritesDao() {
    if (_favouritesDao != null) {
      return _favouritesDao;
    } else {
      synchronized(this) {
        if(_favouritesDao == null) {
          _favouritesDao = new FavouritesDao_Impl(this);
        }
        return _favouritesDao;
      }
    }
  }
}
