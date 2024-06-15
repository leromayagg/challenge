package br.com.fiap.contatos.db.repository

import android.content.Context
import br.com.fiap.contatos.db.connect.Usuariodb
import br.com.fiap.contatos.model.usuario.Usuario

class UsuarioRepository(context: Context) {
    private val db = Usuariodb.getDatabase(context).usuariodao()

    fun createUser(usuario: Usuario) {
        db.createUser(usuario)
    }

    fun getAllUsers(): List<Usuario> {
        return db.getAllUsers()
    }

    fun getUser(email: String, password: String, telefone: String): Usuario {
        return db.getUser(email, password, telefone)
    }

    fun getUserById(id: Int): Usuario {
        return db.getUserById(id)
    }

    fun delete(usuario: Usuario) : Int{
        return db.excluir(usuario)
    }
}