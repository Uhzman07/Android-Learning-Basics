package com.example.myapplication1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.databinding.ActivityMainBinding
import com.example.myapplication1.databinding.ItemTodoBinding


class TodoAdapter(
    var todos :List<Todo>
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    // This is the normal method we can use for our view
    //inner class TodoViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    inner class TodoViewHolder(val binding:ItemTodoBinding) : RecyclerView.ViewHolder(binding.root) // Note that ItemTodoBinding is auto generated from android for the view

    // To get the functions the #todoAdapter needs to have Ctrl +I

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {

        // Normal method, Here we will have to use find view by Id if we want to use it that way
        /*
        val view = LayoutInflater.from(parent.context) // We are using "parent.context" instead of "this" because it is inside a function in a class
            .inflate(R.layout.item_todo,parent,false) // "parent" here is the root, the third parameter here is attach to root which is set as "false" to prevent it from being attached initially
        // We are returning our view here
        return TodoViewHolder(view)

         */
        // Binding method
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemTodoBinding.inflate(layoutInflater,parent,false)

        return TodoViewHolder(binding) // Here we are returning the view
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        // This is used to take the data from the todo list to the corresponding item list (Text view and the check box)
        /*
        val todo = todos[position]
        holder.binding.tvTitle.text=todo.title
         */
        // Normal way of doing it without the binding that is we will have to use find view by id
        /*
        holder.itemView.apply {
            tvTitle.text = todos[position].title
        }
         */
        holder.binding.apply{
            tvTitle.text =todos[position].title // Position here is the index, This is for the data class
            cbDone.isChecked = todos[position].isChecked // This is for the data class todos
        }
    }



    override fun getItemCount(): Int { // this method here is not really used

        // This is used to get the number of the todos available on screen
        return todos.size
    }


}