package com.example.ejemplorv

import android.transition.TransitionInflater
import android.transition.TransitionManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejemplorv.databinding.ItemContactoBinding
import com.example.tarea3_1.Contacto
import com.example.tarea3_1.ContactoPulsadoListener

class ContactosAdapter(private val contactos: List<Contacto>,
                       private val contactoPulsadoListener : ContactoPulsadoListener
) : RecyclerView.Adapter<ContactosAdapter.ViewHolder>() {
    class ViewHolder(private val binding : ItemContactoBinding) : RecyclerView.ViewHolder(binding.root){
        var completo = false
        fun bind (contacto:Contacto){
            if (contacto.genero.equals("Mujer"))
                binding.Foto.setImageResource(R.drawable.avatarfemenino)
            var iniciales = ""
            val array = contacto.nombre.split(" ")
            for (nombre : String in array){
                iniciales += nombre.get(0)
            }
            Log.d("inicial", iniciales)
            binding.Telefono.text = ""
            binding.Nombre.text = ""
            binding.Inicial.text = iniciales
            binding.Foto.setOnClickListener(object : View.OnClickListener{
                override fun onClick(v: View?) {
                    if (completo.equals(false)){
                        binding.Nombre.text = contacto.nombre
                        binding.Telefono.text = contacto.tlfn
                        completo = true
                    }else{
                        binding.Inicial.text = iniciales
                        binding.Nombre.text = ""
                        binding.Telefono.text = ""
                        completo = false
                    }
                }
            })
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemContactoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }
    override fun getItemCount(): Int = contactos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val transition = TransitionInflater.from(holder.itemView.context).inflateTransition(android.R.transition.fade)

        TransitionManager.beginDelayedTransition(holder.itemView as ViewGroup?, transition)
        holder.bind(contactos[position])
        holder.itemView.setOnClickListener{
            contactoPulsadoListener.contactoPulsado((contactos[position]))
        }
    }
}