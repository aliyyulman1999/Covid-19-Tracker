package com.d3if4070.tubescovid.network

import com.d3if4070.tubescovid.ui.CoronaGlobal.data.WorldData
import com.d3if4070.tubescovid.ui.CoronaGlobaldanIndo.data.GlobalMeninggal
import com.d3if4070.tubescovid.ui.CoronaGlobaldanIndo.data.GlobalPositif
import com.d3if4070.tubescovid.ui.CoronaGlobaldanIndo.data.GlobalSembuh
import com.d3if4070.tubescovid.ui.CoronaGlobaldanIndo.data.Indonesia
import com.d3if4070.tubescovid.ui.CoronaIndoprov.data.Provinsi
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("api")
    fun getWorldData(): Single<List<WorldData>>

    @GET("indonesia")
    fun getIDNData(): Single<List<Indonesia>>

    @GET("indonesia/provinsi")
    fun getProvinsiData(): Single<List<Provinsi>>

    @GET("meninggal")
    fun getMeninggalData(): Single<GlobalMeninggal>

    @GET("positif")
    fun getPositifData(): Single<GlobalPositif>

    @GET("sembuh")
    fun getSembuhData(): Single<GlobalSembuh>
}