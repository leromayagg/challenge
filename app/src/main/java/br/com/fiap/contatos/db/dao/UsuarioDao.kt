package br.com.fiap.contatos.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

import br.com.fiap.contatos.model.usuario.Usuario


@Dao
interface UsuarioDao {
    @Insert
    fun createUser(usuario: Usuario)

    @Query("SELECT * FROM tbl_usuario")
    fun getAllUsers(): List<Usuario>

    @Delete
    fun excluir(usuario: Usuario): Int

    @Query("SELECT * FROM tbl_usuario" +
            " WHERE email = :email AND password = :password AND telefone = :telefone")
    fun getUser(email: String, password: String, telefone: String): Usuario

    @Query("SELECT * FROM tbl_usuario WHERE id = :id")
    fun getUserById(id: Int): Usuario
}