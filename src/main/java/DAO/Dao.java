/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;

/**
 *
 * @author facundo
 * @param <T>
 */
public interface Dao<T> { 

    T buscar(T dto);

    List<T> listarPorCriterio(T dto);

    List<T> listarTodos();

    boolean insertar(T dto);

    boolean modificar(T dto);

    boolean borrar(T dto);

}