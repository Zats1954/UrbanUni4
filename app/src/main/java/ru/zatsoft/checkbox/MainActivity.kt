package ru.zatsoft.checkbox

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import ru.zatsoft.checkbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnInput.setOnClickListener {
            binding.tvOutput.text = binding.etInput.text
        }
        binding.btnClear.setOnClickListener {
            onAlertDialog(binding.root)
        }
    }

    private fun onAlertDialog(view: View) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Подтвердите удаление")
            .setPositiveButton("Удалить") { dialog, id ->
                binding.etInput.text.clear()
                binding.tvOutput.text = " "
                Snackbar.make(view, "Данные удалены", Snackbar.LENGTH_LONG)
                    .setAnchorView(binding.etInput)
                    .show()
            }
            .setNegativeButton("Отменить") { dialog, id ->
            }
            .show()
    }
}