package com.example.imc

import android.os.Parcel
import android.os.Parcelable

class IMC(var nome: String?, var peso: Float, var altura: Float, var imc: Float = 0.0f) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readFloat()
    )

    constructor(nome: String, peso: Float, altura: Float) : this(nome, peso, altura, 0.0f)

    fun calcular(): String {
            val valorDaAltura = altura / 100
        imc = peso / (valorDaAltura * valorDaAltura)

        imc = String.format("%.2f", imc).toFloat()

        return when (imc) {
            in 0.0..16.0 -> "Magreza grave"
            in 16.0..17.0 -> "Magreza moderada"
            in 17.0..19.0 -> "Magreza leve"
            in 19.0..25.0 -> "Saudável"
            in 25.0..30.0 -> "Sobrepeso"
            in 30.0..35.0 -> "Obesidade I"
            in 35.0..40.0 -> "Obesidade II"
            else -> "Obesidade Mórbida."
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nome)
        parcel.writeFloat(peso)
        parcel.writeFloat(altura)
        parcel.writeFloat(imc)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<IMC> {
        override fun createFromParcel(parcel: Parcel): IMC {
            return IMC(parcel)
        }

        override fun newArray(size: Int): Array<IMC?> {
            return arrayOfNulls(size)
        }
    }
}