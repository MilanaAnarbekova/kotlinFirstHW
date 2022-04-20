package kg.geektech.kotlinlesson1.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toast.*
import androidx.activity.result.contract.ActivityResultContracts
import kg.geektech.kotlinlesson1.R
import kg.geektech.kotlinlesson1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        const val MY_KEY = "key"
    }

    private val startActivityForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK && it.data != null) {
                val data = it.data?.getStringExtra(MY_KEY)
                binding.firstEditText.setText(data)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btnOnClick()
    }

    private fun btnOnClick() {
        binding.firstButton.setOnClickListener {
            if (binding.firstEditText.text.toString().isEmpty()) {
                Toast.makeText(this, getString(R.string.ErrorText), Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, SecondActivity::class.java)
                val editText = binding.firstEditText.text.toString()
                intent.putExtra(MY_KEY, editText)
                startActivityForResult.launch(intent)
            }
        }
    }
}