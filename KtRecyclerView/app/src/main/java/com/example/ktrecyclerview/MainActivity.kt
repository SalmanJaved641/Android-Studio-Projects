package com.example.ktrecyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ktrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val arrContact=ArrayList<ContactModel>()

        arrContact.add(ContactModel(R.drawable.a,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.b,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.c,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.d,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.e,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.f,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.g,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.h,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.i,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.j,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.k,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.l,"A","98757643623"))

        arrContact.add(ContactModel(R.drawable.a,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.b,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.c,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.d,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.e,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.f,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.g,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.h,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.i,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.j,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.k,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.l,"A","98757643623"))

        arrContact.add(ContactModel(R.drawable.a,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.b,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.c,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.d,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.e,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.f,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.g,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.h,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.i,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.j,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.k,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.l,"A","98757643623"))

        arrContact.add(ContactModel(R.drawable.a,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.b,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.c,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.d,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.e,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.f,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.g,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.h,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.i,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.j,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.k,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.l,"A","98757643623"))

        arrContact.add(ContactModel(R.drawable.a,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.b,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.c,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.d,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.e,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.f,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.g,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.h,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.i,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.j,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.k,"A","98757643623"))
        arrContact.add(ContactModel(R.drawable.l,"A","98757643623"))


        binding.recylerView.layoutManager =GridLayoutManager(this,2)
        val recylerContectAdapter = RecylerContectAdapter(this,arrContact)
        binding.recylerView.adapter = recylerContectAdapter
    }
}