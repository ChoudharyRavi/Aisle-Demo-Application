package com.example.aisledemoapplication.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.aisledemoapplication.databinding.FragmentPhoneScreenBinding
import com.example.aisledemoapplication.interfaces.RetrofitService
import com.example.aisledemoapplication.model.PhoneNumber
import com.example.aisledemoapplication.repository.MainRepository
import com.example.aisledemoapplication.repository.MyViewModelFactory
import com.example.aisledemoapplication.viewmodel.MainViewModel

class PhoneScreenFragment : Fragment() {
    private var _binding: FragmentPhoneScreenBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitService.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService)))[(MainViewModel::class.java)]

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPhoneScreenBinding.inflate(inflater, container, false)

        onClickListeners(binding)
        return binding.root
    }

    private fun onClickListeners(binding: FragmentPhoneScreenBinding) {
        binding.btnContinue.setOnClickListener {
            getUserData(binding)
        }
    }

    private fun getUserData(binding: FragmentPhoneScreenBinding) {
        val mobileCode: String = binding.edtMobileCode.text.toString()
        val mobileNumber: String = binding.edtMobileNo.text.toString()
        if (mobileCode == "+91" && mobileNumber == "9876543212") {
            val number = PhoneNumber(mobileCode + mobileNumber)
               getOtp(number)
        } else {
            Toast.makeText(requireActivity(),"Invalid Details",Toast.LENGTH_SHORT).show()
        }
    }

    private fun getOtp(number: PhoneNumber) {
        viewModel.dataList.observe(requireActivity()) {
            Log.d("msg", "onCreate: $it")
            if (it.status) {
                val action = PhoneScreenFragmentDirections.actionPhoneScreenFragmentToOtpFragment(number.number)
                findNavController().navigate(action)
            }

        }
        viewModel.errorMessage.observe(requireActivity()){
        }
        viewModel.getStatusUpdate(number)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}