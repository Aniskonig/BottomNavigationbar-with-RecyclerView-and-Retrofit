package com.medanis.bnbrvr.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.medanis.bnbrvr.R
import com.medanis.bnbrvr.models.FullStoresModel
import com.medanis.bnbrvr.others.setImage

class StoresAdapter(
    private val mContext: Context?,
    var mData: MutableList<FullStoresModel>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View

        val mInflater = LayoutInflater.from(mContext)
        view = mInflater.inflate(R.layout.store_cv, parent, false)
        return MyMainViewHolder(view)
    }

    @SuppressLint("ResourceAsColor", "SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.setIsRecyclable(false)

        val viewHolder = holder as MyMainViewHolder
        viewHolder.categoryTV.text = mData[position].restaurantType
        viewHolder.storeName.text = mData[position].restaurantName
        viewHolder.ratingTV.text = mData[position].ratingsValue
        viewHolder.numberOfMenus.text = mData[position].restaurantMenusNumber.toString()

        setImage(mData[position].storeImage!!, viewHolder.storeImg, false, mContext!!)

        viewHolder.itemDetailsIcon.setOnClickListener {
            Toast.makeText(mContext, "tttttttttttttt", Toast.LENGTH_LONG).show()
        }
        viewHolder.mCardview.setOnClickListener {
            Toast.makeText(mContext, "tttttttttttttt", Toast.LENGTH_LONG).show()
        }
    }


    inner class MyMainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal  var categoryTV : TextView = itemView.findViewById(R.id.categoryTV)
        internal var mCardview: CardView = itemView.findViewById(R.id.cardview_id)
        internal var storeName: TextView = itemView.findViewById(R.id.storeName)
        internal var itemDetailsIcon: ImageView = itemView.findViewById(R.id.itemDetailsIcon)
        internal var storeImg: ImageView = itemView.findViewById(R.id.storeImg)
        internal var ratingTV: TextView = itemView.findViewById(R.id.ratingTV)
        internal var numberOfMenus: TextView = itemView.findViewById(R.id.numberOfMenus)
    }

}

