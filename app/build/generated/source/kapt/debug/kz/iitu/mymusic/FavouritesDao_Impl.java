package kz.iitu.mymusic;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class FavouritesDao_Impl implements FavouritesDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfFavourites;

  public FavouritesDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFavourites = new EntityInsertionAdapter<Favourites>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `favourites`(`art_id`,`art_name`,`art_thumbnail`,`art_genre`,`art_year`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Favourites value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getArt_name() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getArt_name());
        }
        if (value.getArt_thumbnail() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getArt_thumbnail());
        }
        if (value.getArt_genre() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getArt_genre());
        }
        if (value.getArt_year() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getArt_year());
        }
      }
    };
  }

  @Override
  public void insertFavourites(final Favourites favourites) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfFavourites.insert(favourites);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Favourites> getFavourites() {
    final String _sql = "SELECT * FROM favourites";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "art_id");
      final int _cursorIndexOfArtName = CursorUtil.getColumnIndexOrThrow(_cursor, "art_name");
      final int _cursorIndexOfArtThumbnail = CursorUtil.getColumnIndexOrThrow(_cursor, "art_thumbnail");
      final int _cursorIndexOfArtGenre = CursorUtil.getColumnIndexOrThrow(_cursor, "art_genre");
      final int _cursorIndexOfArtYear = CursorUtil.getColumnIndexOrThrow(_cursor, "art_year");
      final List<Favourites> _result = new ArrayList<Favourites>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Favourites _item;
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final String _tmpArt_name;
        _tmpArt_name = _cursor.getString(_cursorIndexOfArtName);
        final String _tmpArt_thumbnail;
        _tmpArt_thumbnail = _cursor.getString(_cursorIndexOfArtThumbnail);
        final String _tmpArt_genre;
        _tmpArt_genre = _cursor.getString(_cursorIndexOfArtGenre);
        final String _tmpArt_year;
        _tmpArt_year = _cursor.getString(_cursorIndexOfArtYear);
        _item = new Favourites(_tmpId,_tmpArt_name,_tmpArt_thumbnail,_tmpArt_genre,_tmpArt_year);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
