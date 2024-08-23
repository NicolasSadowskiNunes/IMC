package com.example.imc
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultadoActivity : AppCompatActivity() {

    private lateinit var titleDensidadeCorporal: TextView
    private lateinit var textViewHeaderDensidadeCorporal: TextView
    private lateinit var textViewResultadoDensidadeCorporal: TextView
    private lateinit var textViewPeso: TextView
    private lateinit var textViewAltura: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado2)
        titleDensidadeCorporal = findViewById(R.id.titleDensidadeCorporal)
        textViewHeaderDensidadeCorporal = findViewById(R.id.textViewHeaderDensidadeCorporal)
        textViewResultadoDensidadeCorporal = findViewById(R.id.textViewResultadoDensidadeCorporal)
        textViewPeso = findViewById(R.id.textViewPeso)
        textViewAltura = findViewById(R.id.textViewAltura)

        val imc = intent.getParcelableExtra<IMC>("value")


        titleDensidadeCorporal.text = imc?.nome.toString()
        textViewHeaderDensidadeCorporal.text = imc?.calcular()
        textViewResultadoDensidadeCorporal.text = "Seu IMC: " + imc?.imc.toString()


        textViewAltura.text = "Altura: ${imc?.altura.toString()}"
        textViewPeso.text = "Peso: ${imc?.peso.toString()} kg"

    }
}
