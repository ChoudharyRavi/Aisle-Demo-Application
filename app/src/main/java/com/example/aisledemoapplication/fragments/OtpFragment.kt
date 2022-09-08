package com.example.aisledemoapplication.fragments

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.aisledemoapplication.R
import com.example.aisledemoapplication.databinding.FragmentOtpBinding
import com.example.aisledemoapplication.interfaces.RetrofitService
import com.example.aisledemoapplication.model.TokenDetails
import com.example.aisledemoapplication.repository.MainRepository
import com.example.aisledemoapplication.repository.MyViewModelFactory
import com.example.aisledemoapplication.viewmodel.MainViewModel
import java.util.*
import java.util.concurrent.TimeUnit

class OtpFragment : Fragment() {
    private val args: OtpFragmentArgs by navArgs()
    private var _binding: FragmentOtpBinding? = null
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
        _binding = FragmentOtpBinding.inflate(inflater, container, false)
        onClickListeners(binding)
        setTimer(binding)
        binding.txtMobile.text = args.mobileNumber
        return binding.root
    }

    private fun setTimer(binding: FragmentOtpBinding) {
       val duration: Long = TimeUnit.MINUTES.toMillis(1)
        val timer = object : CountDownTimer(duration,1000){
            override fun onTick(p0: Long) {
                val sDuration: String = String.format(Locale.ENGLISH,"%02d : %02d",
                    TimeUnit.MILLISECONDS.toMinutes(1),
                    TimeUnit.MILLISECONDS.toSeconds(1)-
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(1)))

                binding.txtTimer.text = sDuration
            }

            override fun onFinish() {
                binding.txtTimer.visibility = View.GONE
                Toast.makeText(requireActivity(),"Resend Otp",Toast.LENGTH_SHORT).show()
            }
        }
        timer.start()
    }

    private fun onClickListeners(binding: FragmentOtpBinding) {
        binding.btnContinue.setOnClickListener {
            val mobileNumber = args.mobileNumber
            getUserData(binding,mobileNumber)
        }
        binding.txtMobile.setOnClickListener {
            findNavController().navigate(R.id.action_otpFragment_to_phoneScreenFragment)

        }
    }

    private fun getUserData(binding: FragmentOtpBinding, mobileNumber: String?) {
        val otp: String = binding.edtMobileCode.text.toString()
        if (otp == "1234") {
            val getOtp = mobileNumber?.let { TokenDetails(it,otp) }
            getOtp(getOtp)
        } else {
            Toast.makeText(requireActivity(),"Invalid Details", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getOtp(getOtp: TokenDetails?) {
        viewModel.otpList.observe(requireActivity()) {
            Log.d("msg", "onCreate: $it")
            val token: String = it.token
            val action = OtpFragmentDirections.actionOtpFragmentToNotesFragment(token)
            findNavController().navigate(action)

        }
        viewModel.errorMessage.observe(requireActivity()) {
        }
        viewModel.getOtpUpdate(getOtp)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}