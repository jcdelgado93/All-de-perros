package com.example.listadeperros.network.api

import com.example.listadeperros.detalleDelPerro.data.remote.ApiFotos
import com.example.listadeperros.listadoDePerros.data.remote.ApiRazas
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitHandler {

    companion object {

        private fun getRazasRetrofit(): Retrofit {

            val interceptor = HttpLoggingInterceptor()
            interceptor.apply { interceptor.level = HttpLoggingInterceptor.Level.BODY }

            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

            return Retrofit.Builder()
                .baseUrl("https://dog.ceo/api/breeds/")
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
        }

        fun obtenerRazasApi(): ApiRazas {
            return getRazasRetrofit().create(ApiRazas::class.java)
        }

        private fun getFotosRetrofit(): Retrofit {

            val interceptor = HttpLoggingInterceptor()
            interceptor.apply { interceptor.level = HttpLoggingInterceptor.Level.BODY }

            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

            return Retrofit.Builder()
                .baseUrl("https://dog.ceo/api/breed/")
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
        }

        fun obtenerFotosApi(): ApiFotos {
            return getFotosRetrofit().create(ApiFotos::class.java)
        }
    }
}
