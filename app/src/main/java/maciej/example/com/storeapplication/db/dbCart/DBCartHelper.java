package maciej.example.com.storeapplication.db.dbCart;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;




public class DBCartHelper extends OrmLiteSqliteOpenHelper{
    
    
    public static final String DB_NAME = "cart.db";
    public static final int DB_version = 6;
    private Dao<Cart, Long> cartDao;



    public Dao<Cart, Long> getCartDao() {
        if(cartDao == null){
            try {
                cartDao = getDao(Cart.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cartDao;
    }


    public DBCartHelper(Context context) {
        super(context, DB_NAME, null, DB_version);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Cart.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Cart.class, true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        onCreate(database, connectionSource);
    }


    public  int deleteById(Class clazz, Object aId) throws SQLException {
        Dao<Cart, Object> dao = getDao(clazz);
        return dao.deleteById(aId);
    }


}
