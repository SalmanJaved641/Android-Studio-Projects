package com.example.roomlidrarydatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@Dao
public interface ExpenseDao {
//    DAO stand for Data Access Object

    @Query("SELECT * FROM expense")
    abstract List<Expense> getAllExpense();
    /*
    @Query("SELECT * FROM expense"):
        this query select all coloums based on paranthesis comond entity and return it
    abstract:/interface
        means that this method is declared but cannot implemented here but only in subclass
    List<Expense>:
        is return type of method
    getAllExpense():
        is method decleration
    */

    @Insert
    void addTx(Expense expanse);

    @Update
    void updateTx(Expense expense);

    @Delete
    void deleteTx(Expense expense);

}