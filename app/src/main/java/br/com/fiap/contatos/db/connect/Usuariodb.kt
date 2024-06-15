package br.com.fiap.contatos.db.connect

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.contatos.db.dao.UsuarioDao
import br.com.fiap.contatos.model.usuario.Usuario

@Database(
    entities = [Usuario::class],
    version = 1
)
abstract class Usuariodb: RoomDatabase() {

    abstract fun usuariodao(): UsuarioDao

    companion object {

        private lateinit var instance: Usuariodb

        fun getDatabase(context: Context): Usuariodb {
            if (!::instance.isInitialized) {
                instance =
                    Room.databaseBuilder(
                        context,
                        Usuariodb::class.java,
                        "usuario_db"
                    )
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
            }
            return instance

        }
    }
}