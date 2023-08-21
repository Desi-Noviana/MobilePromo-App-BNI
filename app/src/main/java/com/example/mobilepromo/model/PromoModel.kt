package com.example.mobilepromo.model

import com.google.gson.annotations.SerializedName

data class PromoModel(

	@field:SerializedName("PromoModel")
	val promoModel: List<PromoModelItem?>? = null
)

data class PromoModelItem(

	@field:SerializedName("img")
	val img: Img? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("lokasi")
	val lokasi: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("desc")
	val desc: String? = null,
)

data class Img(

	@field:SerializedName("formats")
	val formats: Formats? = null,
)

data class Medium(
	@field:SerializedName("url") //Using for Image
	val url: String? = null
)

data class Formats(

	@field:SerializedName("medium")
	val medium: Medium? = null

)

