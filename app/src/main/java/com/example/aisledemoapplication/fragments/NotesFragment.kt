package com.example.aisledemoapplication.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.aisledemoapplication.R
import com.example.aisledemoapplication.adapter.NoteRecyclerAdapter
import com.example.aisledemoapplication.databinding.FragmentNotesBinding
import com.example.aisledemoapplication.interfaces.RetrofitService
import com.example.aisledemoapplication.repository.MainRepository
import com.example.aisledemoapplication.repository.MyViewModelFactory
import com.example.aisledemoapplication.viewmodel.MainViewModel

class NotesFragment : Fragment() {

    private val args: NotesFragmentArgs by navArgs()
    private var _binding: FragmentNotesBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitService.getInstance()
    private var adapter: NoteRecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            MyViewModelFactory(MainRepository(retrofitService))
        )[(MainViewModel::class.java)]
        adapter = NoteRecyclerAdapter(requireActivity())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentNotesBinding.inflate(inflater, container, false)
        getNotesList(args.token)
        return binding.root

    }


    private fun getNotesList(token: String) {
        viewModel.notesApiList.observe(requireActivity()) {
            Log.d("msg", "onCreate: $it")
            adapter?.addData(it.likes.profiles)
            val textDetails: String = it.invites.profiles[0].generalInformation.firstName + "," + it.invites.profiles[0].generalInformation.age
            binding.txtNameAge.text = textDetails
            Glide.with(requireActivity())
                .load(it.invites.profiles[0].photos[0])
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.ivMainImage)
        }
        viewModel.errorMessage.observe(requireActivity()) {
        }
        viewModel.getNotesApi(token)
    }
}