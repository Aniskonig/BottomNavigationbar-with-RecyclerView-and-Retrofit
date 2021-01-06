package com.medanis.bnbrvr.others

import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.PictureDrawable
import android.net.ConnectivityManager
import android.net.Uri
import android.net.wifi.WifiManager
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.medanis.bnbrvr.R
import com.medanis.bnbrvr.models.MenusModel
import com.medanis.bnbrvr.models.RatingsModel
import com.medanis.bnbrvr.models.StoresModel
import java.util.regex.Matcher
import java.util.regex.Pattern
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou

interface CustomCallback  {
    fun getStoreDataLists(storesList: MutableList<StoresModel>, storesMenusList: MutableList<MenusModel>, storeRatingsList: MutableList<RatingsModel>)
}


var wifiManager: WifiManager? = null

fun isConnected(context: Context): Boolean {
    val cnxManager : ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val netInfo = cnxManager.activeNetworkInfo
    if (netInfo !=null){
        return netInfo.isConnected
    }else{
        return false
    }
}
fun dismissProgressBar(progressBar: ProgressBar){
    if( progressBar.visibility == View.VISIBLE){
        progressBar.visibility = View.GONE
    }
}
fun showProgressBar(progressBar: ProgressBar){
    if( progressBar.visibility != View.VISIBLE){
        progressBar.visibility = View.VISIBLE
    }
}
fun isEditTextEmpty(context: Context, editText: EditText): Boolean {
    val text = editText.text.toString().trim()
    if (TextUtils.isEmpty(text)) {
        editText.error = "required!"
        editText.requestFocus()
        return true
    }
    return false
}

private fun isImageSVG(image: String): Boolean {
    val svg = ".svg"
    return image.toLowerCase().indexOf(svg.toLowerCase()) != -1
}

fun setImage(
    image: String,
    imageView: ImageView,
    isProfilePicture: Boolean,
    applicationContext: Context,
) {
    if (!isImageSVG(image)) {
        var firstImagePath = ""
        for (i in image) {
            if (i != '|') {
                firstImagePath += i
            } else {
                break
            }
        }

        val urlREGEX = "^((https?|ftp)://|(www|ftp)\\.)?[a-z0-9-]+(\\.[a-z0-9-]+)+([/?].*)?$"

        val p: Pattern = Pattern.compile(urlREGEX)
        val m: Matcher = p.matcher(image)
        if (!m.find()) {
            firstImagePath = "https://wasali-dz.com/${firstImagePath}"
        }
        if (!isProfilePicture) {
            Glide.with(applicationContext)
                .load(firstImagePath)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        if (!isProfilePicture) {
                            imageView.scaleType = ImageView.ScaleType.FIT_CENTER
                        }
                        imageView.setImageResource(R.mipmap.ic_launcher)
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        imageView.background = resource
                        imageView.scaleType = ImageView.ScaleType.FIT_XY
                        return true
                    }

                }).submit()
        } else {
            if (firstImagePath != "") {
                Glide.with(applicationContext)
                    .load(firstImagePath)
                    .placeholder(R.drawable.ic_error_white)
                    .error(R.drawable.ic_broken_image)
                    .into(imageView)
            } else {
                Glide.with(applicationContext)
                    .load("https://wasali-dz.com/uploads/user.png")
                    .placeholder(R.drawable.ic_error)
                    .error(R.drawable.ic_broken_image)
                    .into(imageView)
            }
        }
    } else {
        val requestBuilder = GlideToVectorYou
            .init()
            .with(applicationContext)
            .requestBuilder
        requestBuilder
            .load(Uri.parse(image))
            .listener(object : RequestListener<PictureDrawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<PictureDrawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    imageView.scaleType = ImageView.ScaleType.FIT_CENTER
                    imageView.setImageResource(R.mipmap.ic_launcher)
                    return false
                }

                override fun onResourceReady(
                    resource: PictureDrawable?,
                    model: Any?,
                    target: Target<PictureDrawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    imageView.setImageDrawable(resource)
                    imageView.scaleType = ImageView.ScaleType.FIT_CENTER
                    return true
                }
            }).submit()
    }
}
