package com.example.hw6exercise2new

import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.hw6exercise2new.databinding.ListItemCrimeBinding
import com.example.hw6exercise2new.databinding.ListItemCrimeNewBinding
import java.text.SimpleDateFormat
import java.util.*

class CrimeHolder(
    private val binding: ListItemCrimeBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(crime: Crime) {
        binding.crimeTitle.text = crime.title


//New formatted date for each entry
//Documentation: StackOverFlow -- How to use "android.text.format.DateFormat" with Kotlin?
        val crimeDate = SimpleDateFormat("EE. MMM. dd, yyyy", Locale.US)
        val newDate : String = crimeDate.format(crime.date).toString()
        binding.crimeDate.text = newDate

        binding.root.setOnClickListener {
            Toast.makeText(
                binding.root.context,
                "${crime.title} clicked!",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.crimeSolved.visibility = if (crime.isSolved){
            View.VISIBLE
        } else {
            View.GONE
        }
    }


    class PoliceHolder(

        private val binding: ListItemCrimeNewBinding

    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(crime: Crime) {
            binding.crimeTitle.text = crime.title


//New formatted date for each entry
//Documentation: StackOverFlow -- How to use "android.text.format.DateFormat" with Kotlin?
            val crimeDate = SimpleDateFormat("EE. MMM. dd, yyyy", Locale.US)
            val newDate : String = crimeDate.format(crime.date).toString()
            binding.crimeDate.text = newDate


            binding.root.setOnClickListener {




                Toast.makeText(

                    binding.root.context,

                    "${crime.title} clicked!",

                    Toast.LENGTH_SHORT

                ).show()

            }

            var click = 0;

            binding.RequiresPolice.setOnClickListener {

                click++

                if (click == 1) {

                    Toast.makeText(

                        binding.root.context,

                        // Make the entire toast capitalized to emphasize intensity
                        "POLICE CONTACTED REGARDING ${crime.title.uppercase()}!",

                        Toast.LENGTH_SHORT

                    ).show()
                } else {

                    Toast.makeText(

                        binding.root.context,

                        // Make the entire toast capitalized to emphasize intensity
                        "POLICE REQUIREMENT CANCELED REGARDING ${crime.title.uppercase()}!",

                        Toast.LENGTH_SHORT

                    ).show()

                    click = 0;

                }

            }

        }

    }
}

class CrimeListAdapter(
    private val crimes: List<Crime>
) : RecyclerView.Adapter<CrimeHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CrimeHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemCrimeBinding.inflate(inflater, parent, false)
        return CrimeHolder(binding)
    }

    override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
        val crime = crimes[position]
        holder.bind(crime)
    }

    override fun getItemCount() = crimes.size
}


class CrimeListAdapter2(
    private val crimes: List<Crime>
) : RecyclerView.Adapter<CrimeHolder.PoliceHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CrimeHolder.PoliceHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemCrimeNewBinding.inflate(inflater, parent, false)
        return CrimeHolder.PoliceHolder(binding)
    }

    override fun onBindViewHolder(holder: CrimeHolder.PoliceHolder, position: Int) {
        val crime = crimes[position]
        holder.bind(crime)
    }

    override fun getItemCount() = crimes.size
}













