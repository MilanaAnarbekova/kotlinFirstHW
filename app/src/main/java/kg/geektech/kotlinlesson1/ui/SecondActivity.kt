package kg.geektech.kotlinlesson1.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kg.geektech.kotlinlesson1.R
import kg.geektech.kotlinlesson1.databinding.ActivityMainBinding
import kg.geektech.kotlinlesson1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    companion object {
        const val MY_KEY = "key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (intent.hasExtra(MY_KEY)) {
            goContent()
        }
        btnOnClick()
    }

    private fun goContent() {
        binding.secondEditText.setText(intent.getStringExtra(MY_KEY).toString())
    }

    private fun btnOnClick() {
        binding.secondButton.setOnClickListener {
            if(TextUtils.isEmpty(binding.secondEditText.text.toString())){
                Toast.makeText(this, getString(R.string.ErrorText), Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent()
                val editText = binding.secondEditText.text.toString()
                intent.putExtra(MY_KEY, editText)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }


}