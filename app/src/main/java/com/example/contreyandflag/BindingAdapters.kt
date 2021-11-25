package com.example.contreyandflag

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.load
import coil.request.ImageRequest
import com.example.contreyandflag.network.FlagPhoto

//@BindingAdapter("imageUrl")
//fun bindImage(imgView: ImageView, imgUrl: String?) {
//    imgUrl?.let {
//        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
//        imgView.load(imgUri) {
//            placeholder(R.drawable.loading_animation)
//            error(R.drawable.ic_baseline_broken_image_24)
//        }
//    }
//}
@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?){
    imgUrl.let {
        val imageLoader = ImageLoader.Builder(imgView.context)
            .componentRegistry { add(SvgDecoder(imgView.context)) }
            .build()

        val request = ImageRequest.Builder(imgView.context)
            .data(imgUrl)
            .target(imgView)
            .build()

        imageLoader.enqueue(request)
    }


}
